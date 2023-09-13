package luat.detest.restcontroller;

import jakarta.validation.Valid;
import luat.detest.exception.DataInvalid;
import luat.detest.model.request.ProductRequest;
import luat.detest.model.request.SearchRequest;
import luat.detest.model.response.ProductResponse;
import luat.detest.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductResponse> products() {
        return productService.findAll();
    }

    @PostMapping("/post")
    public ProductResponse addProduct(@RequestBody @Valid ProductRequest productRequest, BindingResult error) {
        if (error.hasErrors()) {
            throw new DataInvalid("data invalid");
        }
        return productService.createOrUpdate(productRequest);
    }

    @PutMapping("/put")
    public ProductResponse update(@RequestBody @Valid ProductRequest productResponse,
                                  BindingResult error) {
        if (error.hasErrors()) {
            for (FieldError er : error.getFieldErrors()) {
                String fieldName = er.getField();
                String errorMessage = er.getDefaultMessage();
                System.out.println("Lỗi ở fiel '" + fieldName + "': " + errorMessage);
            }
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

    @GetMapping("/{id}")
    public ProductResponse detail(@PathVariable("id") String string) {
        try {
            Long id = Long.parseLong(string);
            return productService.detail(id);
        }catch (Exception e){
            throw new DataInvalid("id không hợp lệ");
        }
    }

    @DeleteMapping ("/{id}")
    public List<ProductResponse> del(@PathVariable("id")Long id){
        return productService.del(id);
    }
}
