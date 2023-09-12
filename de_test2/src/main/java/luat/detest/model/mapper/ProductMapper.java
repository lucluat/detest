package luat.detest.model.mapper;

import luat.detest.entity.Product;
import luat.detest.model.request.ProductRequest;
import luat.detest.model.response.ProductResponse;
import luat.detest.model.response.StatusResponse;
import luat.detest.model.response.SubCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private SubCategoryMapper subCategoryMapper;
    @Autowired
    private StatusMapper statusMapper;

    public ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductName(product.getProduceName());
        productResponse.setBrand(product.getBrands().size()>0?brandMapper.toResponse(product.getBrands().get(0)):null);
        productResponse.setSellPrice(product.getSellPrice());
        productResponse.setStatus(statusMapper.toResponse(product.getStatus()));
        productResponse.setSubCategory(subCategoryMapper.toResponse(product.getSubCategory()));
        productResponse.setOrginPrice(product.getOrginPrice());
        productResponse.setColor(product.getColor());
        productResponse.setQuantity(product.getQuantity());
        return productResponse;
    }

    public Product toProduct(ProductRequest productResponse) {
        Product product = new Product();
        product.setProduceName(productResponse.getProductName());
        product.setColor(productResponse.getColor());
        product.setOrginPrice(productResponse.getOrginPrice());
        product.setQuantity(productResponse.getQuantity());
        product.setSellPrice(productResponse.getSellPrice());
        return product;
    }


    public Product toProduc(ProductRequest productResponse, Product product) {
        if (productResponse.getId() != null) {
            product.setId(productResponse.getId());
        }
        product.setProduceName(productResponse.getProductName());
        product.setColor(productResponse.getColor());
        product.setOrginPrice(productResponse.getOrginPrice());
        product.setQuantity(productResponse.getQuantity());
        product.setSellPrice(productResponse.getSellPrice());
        return product;
    }
}
