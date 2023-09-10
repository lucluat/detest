package luat.detest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Status extends AbstractEntity{
    @Column
    private String statusName;
    @JsonBackReference
    @OneToMany(mappedBy = "status")
    private List<Product> products= new ArrayList<>();

}
