package luat.detest.repository;

import luat.detest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

//    List<Product> findByProduceNameIsContainingAndSellPriceAndBrands_IdAndSubCategory_IdAndStatus_Id(
//            String produceName, Double sellPrice,Long brandId, Long subCategoryId, Long statusId );

}
