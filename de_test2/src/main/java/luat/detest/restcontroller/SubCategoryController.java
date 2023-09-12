package luat.detest.restcontroller;

import luat.detest.model.response.SubCategoryResponse;
import luat.detest.service.impl.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
