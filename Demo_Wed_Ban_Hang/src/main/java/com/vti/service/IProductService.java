package com.vti.service;

import com.vti.entity.Product;
import com.vti.filter.ProductFilter;
import com.vti.form.CreatingProductForm;
import com.vti.form.UpdatingProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAllProduct(Pageable pageable,  ProductFilter form);

    void createProduct(CreatingProductForm form);

    void updateProduct(UpdatingProductForm form);

    void deleteProduct(int id);

    Product getProductByName(String name);

    Product getProductById(int id);

    boolean isProductExistsByName(String name);

    boolean isProductExistsById(Integer id);

}
