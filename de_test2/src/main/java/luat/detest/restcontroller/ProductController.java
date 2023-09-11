package luat.detest.restcontroller;

import jakarta.validation.Valid;
import luat.detest.exception.DataInvalid;
import luat.detest.model.request.ProductRequest;
import luat.detest.model.request.SearchRequest;
import luat.detest.model.response.ProductResponse;
import luat.detest.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductResponse> products() {
        return productService.getAll();
    }

    @PostMapping("/post")
    public ProductResponse addProduct(@RequestBody @Valid ProductRequest productRequest, BindingResult error) {
        if (error.hasErrors()) {
            System.out.println("lỗi");
            throw new DataInvalid("data invalid");
        }
        System.out.println("lỗi 2");
        return productService.createOrUpdate(productRequest);
    }

    @PutMapping("/put")
    public ProductResponse update(@RequestBody @Valid ProductRequest productResponse, BindingResult error) {
        if (error.hasErrors()) {
            throw new DataInvalid("data invalid");
        }
        return productService.createOrUpdate(productResponse);
    }

    @PostMapping("/search")
    public List<ProductResponse> search(@RequestBody @Valid SearchRequest searchRequest, BindingResult error) {
        if (error.hasErrors()) {
            throw new DataInvalid("dữ liệu không hợp lệ");
        }
        return productService.search(searchRequest);
    }

    @GetMapping("/detail/{id}")
    public ProductResponse detail(@PathVariable("id") String string) {
        try {
            Long id = Long.parseLong(string);
            return productService.detail(id);
        }catch (Exception e){
            throw new DataInvalid("id không hợp lệ");
        }

    }

}
