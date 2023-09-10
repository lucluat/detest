package luat.detest.service.impl;

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
import luat.detest.response.ProductResponse;
import luat.detest.service.IProductService;
import luat.detest.utils.common;
import org.springframework.beans.factory.annotation.Autowired;
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

    //    @Override
//    public Page<ProductResponse> getAll(Pageable pageable) {
//        Page<Product> oldPage = iProductRepository.findAll(pageable);
//        List<Product> products= oldPage.getContent();
//        List<ProductResponse> productResponses = new ArrayList<>();
//        for (Product product : products
//        ) {
//            productResponses.add(productConvert.toProductResponse(product));
//        }
//        Page page= new PageImpl(productResponses,pageable, oldPage.getTotalElements());
//        return page;
//    }
    @Override
    public List<ProductResponse> getAll() {
        List<Product> productList = iProductRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : productList
        ) {
            productResponses.add(productConvert.toProductResponse(product));
        }
        return productResponses;
    }

    @Override
    public ProductResponse createOrUpdate(ProductRequest productResponse) {
        Product product;
        if (productResponse.getId() != null) {
            Optional<Product> optional = iProductRepository.findById(productResponse.getId());
            Product oldProduct;
            if (optional.isPresent()) {
                oldProduct = optional.get();
                product = productConvert.toProduc(productResponse, oldProduct);
            } else {
//                throw new DataInvalid("data invalid");
                product = productConvert.toProduc(productResponse);
            }
        } else {
            product = productConvert.toProduc(productResponse);
        }
        Optional<SubCategory> subCategory = iSubCategoryRepository.findById(productResponse.getSubCategoryId());
        Optional<Status> statusOptional = iStatusRepository.findById(productResponse.getStatusId());
        Optional<Brand> optionalBrand = iBrandRepository.findById(productResponse.getBrandId());
        if (common.isPresent(subCategory, statusOptional, optionalBrand)) {
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
                        (searchRequest.getProduceName() == null || item.getProduceName().trim().contains(searchRequest.getProduceName())) &&
                                (searchRequest.getSellPrice() == null || item.getSellPrice().equals(searchRequest.getSellPrice())) &&
                                (item.getBrands().size() > 0 && item.getBrands().get(0).getId().equals(searchRequest.getBrandId())) &&
                                (item.getSubCategory().getId().equals(searchRequest.getSubCategoryId())) &&
                                (item.getStatus().getId().equals(searchRequest.getStatusId())))
                .collect(Collectors.toList());
        for (Product product : listFilter) {
            productResponses.add(productConvert.toProductResponse(product));
        }
        return productResponses;
    }
}