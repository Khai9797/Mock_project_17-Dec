package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`Product`")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "`name`" ,length = 500, nullable = false)
    private String name;

    @Column(name = "price" ,length = 50, nullable = false)
    private int price;

    @Column(name = "color" ,length = 50, nullable = false)
    private String color;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "image" ,length = 5000)
    private String image;

    @Column(name = "star")
    private int star;

    @ManyToOne
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
    private Manufacture manufacture;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
