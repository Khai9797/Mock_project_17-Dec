package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingProductForm {
    private String name;

    private int price;

    private String color;

    private int manufactureId;

    private int categoryId;

    private String image;

    private int star;

}
