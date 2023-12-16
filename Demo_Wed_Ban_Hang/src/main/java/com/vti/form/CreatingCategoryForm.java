package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CreatingCategoryForm {
    private String name;

    private List<ProductForm> products;

    @Data
    @NoArgsConstructor
    public static class ProductForm {

        private Integer id;

        private String name;

        private int price;

        private String color;

        private int manufactureId;

        private int categoryId;

        private String image;

        private int star;
    }
}

