package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatingProductForm {

    private int id;

    private String name;

    private int price;

    private String color;

    private int manufactureId;

    private String categoryId;

    private String image;

    private int star;
}
