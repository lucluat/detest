package luat.detest.model.mapper;

import luat.detest.entity.Brand;
import luat.detest.model.response.BrandResponse;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {
    public BrandResponse toResponse(Brand brand){
        BrandResponse response= new BrandResponse();
        response.setId(brand.getId());
        response.setBrandName(brand.getBrandName());
        return response;
    }
}
