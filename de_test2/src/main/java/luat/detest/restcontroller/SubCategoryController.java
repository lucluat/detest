package luat.detest.restcontroller;

import luat.detest.response.SubCategoryResponse;
import luat.detest.service.impl.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/sub-categories")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("")
    public List<SubCategoryResponse> subCategories() {
        return subCategoryService.subCategories();
    }

}
