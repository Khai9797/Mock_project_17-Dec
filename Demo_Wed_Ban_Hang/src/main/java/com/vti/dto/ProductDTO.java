package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProductDTO {

    private int id;

    private String name;

    private int price;

    private String color;

    private String manufactureName;

    private String categoryName;

    private String image;

    private int star;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createDate;


}
