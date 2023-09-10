package luat.detest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public class AbstractEntity {
    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;



}
