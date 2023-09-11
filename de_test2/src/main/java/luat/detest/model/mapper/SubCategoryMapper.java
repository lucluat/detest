package luat.detest.model.mapper;

import luat.detest.entity.SubCategory;
import luat.detest.model.response.SubCategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryMapper {
    public SubCategoryResponse toResponse(SubCategory subCategory){
        SubCategoryResponse response = new SubCategoryResponse();
        response.setId(subCategory.getId());
        response.setSubCateName(subCategory.getSubCateName());
        response.setSubCateCode(subCategory.getSubCateCode());
        return response;
    }

}
