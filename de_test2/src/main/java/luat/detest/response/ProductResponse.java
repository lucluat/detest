package luat.detest.response;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luat.detest.entity.AbstractEntity;
import luat.detest.entity.Brand;
import luat.detest.entity.Status;
import luat.detest.entity.SubCategory;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

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
