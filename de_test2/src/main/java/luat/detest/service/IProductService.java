package luat.detest.service;

import luat.detest.model.request.ProductRequest;
import luat.detest.model.request.SearchRequest;
import luat.detest.model.response.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IProductService {

    List<ProductResponse> findAll();

    ProductResponse createOrUpdate(ProductRequest productResponse);

    ProductResponse detail(Long id);

    List<ProductResponse> search(SearchRequest searchRequest);

    List<ProductResponse> del(Long id);
}
