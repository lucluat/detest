package luat.detest.service;

import luat.detest.model.request.ProductRequest;
import luat.detest.model.request.SearchRequest;
import luat.detest.response.ProductResponse;

import java.util.List;


public interface IProductService {

    List<ProductResponse> getAll();

    ProductResponse createOrUpdate(ProductRequest productResponse);

    ProductResponse detail(Long id);

    List<ProductResponse> search(SearchRequest searchRequest);
}
