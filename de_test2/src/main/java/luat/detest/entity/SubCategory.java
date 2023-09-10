package luat.detest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class SubCategory extends AbstractEntity{
    @Column(unique = true)
    private String subCateCode;
    @Column
    private String subCateName;

    @ManyToOne
    @JoinColumn
    private Category category;

    @OneToMany(mappedBy = "subCategory")
    private List<Product> products= new ArrayList<>();
}
