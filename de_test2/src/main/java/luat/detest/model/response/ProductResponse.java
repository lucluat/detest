package luat.detest.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luat.detest.entity.Status;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends AbstractResponse {

    private String productName;
    private BrandResponse brand;
    private SubCategoryResponse subCategory;
    private StatusResponse status;
    private String color;
    private Long quantity;
    private Double sellPrice;
    private Double orginPrice;
}
