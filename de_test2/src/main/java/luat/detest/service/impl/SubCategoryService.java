package luat.detest.service.impl;

import luat.detest.entity.SubCategory;
import luat.detest.model.mapper.SubCategoryMapper;
import luat.detest.repository.ISubCategoryRepository;
import luat.detest.response.SubCategoryResponse;
import luat.detest.service.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService implements ISubCategoryService{
    @Autowired
    private ISubCategoryRepository iSubCategoryRepository;
    @Autowired
    private SubCategoryMapper subCategoryConvert;
    @Override
    public List<SubCategoryResponse> subCategories(){
        List<SubCategory> subCategories = iSubCategoryRepository.findAll();
        List<SubCategoryResponse> responses = new ArrayList<>();
        for (SubCategory subCategory :subCategories) {
                responses.add(subCategoryConvert.toResponse(subCategory));
        }
        return  responses;
    }
}
