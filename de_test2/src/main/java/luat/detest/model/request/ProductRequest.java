package luat.detest.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luat.detest.model.response.AbstractResponse;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest extends AbstractResponse {
    private Long id;
    @NotEmpty
    @NotNull
    private String productName;

    @NotEmpty
    @NotNull
    private String color;

    @NotNull
    @Min(value = 0,message = "quantity >= 0")
    private Long quantity;
    @NotNull
    @Min(value = 0,message = "sellPrice >= 0")
    private Double sellPrice;
    @NotNull
    @Min(value = 0,message = " orginPrice >= 0")
    private Double orginPrice;


    @Min(value = 1,message = "subCategoryId >= 1")
    private Long subCategoryId;
    @NotNull
    @Max(value = 2,message = "statusId <=2")
    @Min(value = 1,message = "statusId >= 1")
    private Long statusId;
    @NotNull
    @Min(value = 1,message = "brandId >= 1")
    private Long brandId;
}
