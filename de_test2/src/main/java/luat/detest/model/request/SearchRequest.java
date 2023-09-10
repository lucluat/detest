package luat.detest.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private String produceName;

    @Min(value = 0,message = "sellPrice >= 0")
    private Double sellPrice;
    @NotNull
        private Long brandId;
    @NotNull
    private Long subCategoryId;
    @NotNull
    private Long statusId;

    @Override
    public String toString() {
        return "SearchRequest{" +
                "produceName=" + produceName  +
                ", sellPrice=" + sellPrice +
                ", brandId=" + brandId +
                ", subCategoryId=" + subCategoryId +
                ", statusId=" + statusId +
                '}';
    }
}
