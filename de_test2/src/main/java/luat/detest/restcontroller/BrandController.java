package luat.detest.restcontroller;

import luat.detest.model.response.BrandResponse;
import luat.detest.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("")
    public List<BrandResponse> brands() {
        return brandService.brands();
    }

}
