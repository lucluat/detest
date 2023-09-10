package luat.detest.entity;

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
public class Product extends AbstractEntity {
    @Column
    private String produceName;
    @Column
    private String color;
    @Column
    private Long quantity;
    @Column
    private Double sellPrice;
    @Column
    private Double orginPrice;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "Brand_Product",
            joinColumns= @JoinColumn(name = "Product"),
            inverseJoinColumns = @JoinColumn(name = "Brand")
    )
    private List<Brand> brands= new ArrayList<>();


}
