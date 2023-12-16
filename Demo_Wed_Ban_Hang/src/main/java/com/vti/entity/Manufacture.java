package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`Manufacture`")
@Data
@NoArgsConstructor
public class Manufacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "`name`" ,length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "manufacture", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
