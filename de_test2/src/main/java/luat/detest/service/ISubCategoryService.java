package luat.detest.service;

import luat.detest.entity.SubCategory;
import luat.detest.model.response.SubCategoryResponse;

import java.util.List;

public interface ISubCategoryService {
    List<SubCategoryResponse> subCategories();
}
