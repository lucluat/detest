package luat.detest.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luat.detest.response.AbstractResponse;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest extends AbstractResponse {

    @NotEmpty
    @NotNull
    private String produceName;

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

    private String description;

    @Min(value = 0,message = "subCategoryId >= 0")
    private Long subCategoryId;
    @NotNull
    @Max(value = 1,message = "statusId <=1")
    @Min(value = 0,message = "statusId >= 0")
    private Long statusId;
    @NotNull
    @Min(value = 0,message = "brandId >= 0")
    private Long brandId;
}
