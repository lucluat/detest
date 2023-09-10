package luat.detest.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends AbstractResponse {

    private String produceName;
    private String brandName;
    private String subCategory;
    private Double price;
    private String status;

}
