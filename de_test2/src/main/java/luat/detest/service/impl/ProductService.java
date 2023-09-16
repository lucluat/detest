package luat.detest.service.impl;

import jakarta.transaction.Transactional;
import luat.detest.entity.Brand;
import luat.detest.entity.Product;
import luat.detest.entity.Status;
import luat.detest.entity.SubCategory;
import luat.detest.exception.DataInvalid;
import luat.detest.exception.NotFoundException;
import luat.detest.model.mapper.ProductMapper;
import luat.detest.repository.IBrandRepository;
import luat.detest.repository.IProductRepository;
import luat.detest.repository.IStatusRepository;
import luat.detest.repository.ISubCategoryRepository;
import luat.detest.model.request.ProductRequest;
import luat.detest.model.request.SearchRequest;
import luat.detest.model.response.ProductResponse;
import luat.detest.service.IProductService;
import luat.detest.utils.common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ProductMapper productConvert;
    @Autowired
    private ISubCategoryRepository iSubCategoryRepository;
    @Autowired
    private IBrandRepository iBrandRepository;
    @Autowired
    private IStatusRepository iStatusRepository;


    @Override
    public List<ProductResponse> findAll() {
        List<Product> productList = iProductRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : productList
        ) {
            productResponses.add(productConvert.toProductResponse(product));
        }
        return productResponses;
    }

    @Override
    public ProductResponse createOrUpdate(ProductRequest productRequest) {
        Product product;
        if (productRequest.getId() != null) {
            Optional<Product> optional = iProductRepository.findById(productRequest.getId());
            Product oldProduct;
            if (optional.isPresent()) {
                oldProduct = optional.get();
                product = productConvert.toProduc(productRequest, oldProduct);
            } else {
                 product = productConvert.toProduct(productRequest);
            }
        } else {
            product = productConvert.toProduct(productRequest);
        }
        Optional<SubCategory> subCategory = iSubCategoryRepository.findById(productRequest.getSubCategoryId());
        Optional<Status> statusOptional = iStatusRepository.findById(productRequest.getStatusId());
        Optional<Brand> optionalBrand = iBrandRepository.findById(productRequest.getBrandId());
        if (!common.isPresent(subCategory, statusOptional, optionalBrand)) {
            throw new DataInvalid("data invalid");
        }

        product.setSubCategory(subCategory.get());
        product.setStatus(statusOptional.get());
        List<Brand> brands = new ArrayList<>();
        brands.add(optionalBrand.get());
        product.setBrands(brands);
        return productConvert.toProductResponse(iProductRepository.save(product));
    }

    @Override
    public ProductResponse detail(Long id) {
        Optional<Product> product = iProductRepository.findById(id);
        if (product.isPresent()) {
            return productConvert.toProductResponse(product.get());
        }
        throw new NotFoundException("product not found");
    }

    @Override
    public List<ProductResponse> search(SearchRequest searchRequest) {
        List<ProductResponse> productResponses = new ArrayList<>();
        List<Product> products = iProductRepository.findAll();
        List<Product> listFilter = products.stream()
                .filter(item ->
                        (searchRequest.getProductName() == null || item.getProduceName().trim().contains(searchRequest.getProductName())) &&
                                (searchRequest.getSellPrice() == null || item.getSellPrice().equals(searchRequest.getSellPrice())) &&
                                (item.getBrands().size() > 0 && item.getBrands().get(0).getId().equals(searchRequest.getBrandId())) &&
                                (item.getSubCategory().getId().equals(searchRequest.getSubCategoryId())) &&
                                (item.getStatus().getId().equals(searchRequest.getStatusId()))
                )
                .collect(Collectors.toList());
        for (Product product : listFilter) {
            productResponses.add(productConvert.toProductResponse(product));
        }
        return productResponses;
    }

    @Override
    public List<ProductResponse> del(Long id) {
        if (iProductRepository.existsById(id)) {
            iProductRepository.deleteById(id);
            return this.findAll();
        }
        throw new DataInvalid("không có product có id:"+id);
    }
}
