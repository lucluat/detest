package luat.detest.model.mapper;

import luat.detest.entity.Product;
import luat.detest.model.request.ProductRequest;
import luat.detest.model.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProduceName(product.getProduceName());
        productResponse.setBrandName(product.getBrands().size()>0?product.getBrands().get(0).getBrandName():null);
        productResponse.setPrice(product.getSellPrice());
        productResponse.setStatus(product.getStatus().getStatusName());
        productResponse.setSubCategory(product.getSubCategory().getSubCateName());
        return productResponse;
    }

    public Product toProduc(ProductRequest productResponse) {
        Product product = new Product();
        if (productResponse.getId() != null) {
            product.setId(productResponse.getId());
        }
        product.setProduceName(productResponse.getProduceName());
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
        product.setProduceName(productResponse.getProduceName());
        product.setColor(productResponse.getColor());
        if (product.getDescription() != null) {
            productResponse.setDescription(productResponse.getDescription());
        }
        product.setOrginPrice(productResponse.getOrginPrice());
        product.setQuantity(productResponse.getQuantity());
        product.setSellPrice(productResponse.getSellPrice());
        return product;
    }
}
