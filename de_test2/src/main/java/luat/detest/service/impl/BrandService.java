package luat.detest.service.impl;

import luat.detest.entity.Brand;
import luat.detest.model.mapper.BrandMapper;
import luat.detest.model.response.BrandResponse;
import luat.detest.repository.IBrandRepository;
import luat.detest.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository iBrandRepository;
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<BrandResponse> brands(){
        List<Brand> brands=iBrandRepository.findAll();
        List<BrandResponse> responses= new ArrayList<>();
        for (Brand brand:brands) {
            responses.add(brandMapper.toResponse(brand));
        }
        return responses;
    }
}
