package com.vti.service;

import com.vti.entity.Category;
import com.vti.entity.Product;
import com.vti.filter.CategoryFilter;
import com.vti.form.CreatingCategoryForm;
import com.vti.form.UpdatingCategoryForm;
import com.vti.repository.ICategoryRepository;
import com.vti.repository.IManufactureRepository;
import com.vti.repository.IProductRepository;
import com.vti.specification.CategorySpectification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

//    @Autowire EmailService..
    @Autowired
    private IManufactureRepository manufactureRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
//    public List<Category> getAllCategory() {
//        return categoryRepository.findAll();
//    }
    public Page<Category>getAllCategory(Pageable pageable, CategoryFilter form){
        Specification<Category> specification = CategorySpectification.buildWhere(form);
        return categoryRepository.findAll(specification, pageable);
    }

    @Override
    public void createCategory(CreatingCategoryForm form) {
        Category category = categoryRepository.save(modelMapper.map(form, Category.class));
        List<Product> products = new ArrayList<>();
        List<CreatingCategoryForm.ProductForm> productForms = form.getProducts();
        productForms.forEach(productForm -> {
            Product product = modelMapper.map(productForm, Product.class);
            product.setCategory(category);
            product.setManufacture(manufactureRepository.findById(productForm.getManufactureId()));
            product.setCategory(categoryRepository.findById(productForm.getCategoryId()));
            products.add(product);
        });
        productRepository.saveAll(products);
    }

    @Override
    public void updateCategory(UpdatingCategoryForm form) {
        categoryRepository.save(modelMapper.map(form, Category.class));
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public boolean isCategoryExistsByName(String name) {

        return categoryRepository.existsByName(name);
    }
}
