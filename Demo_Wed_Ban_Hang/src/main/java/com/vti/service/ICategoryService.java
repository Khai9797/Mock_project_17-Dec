package com.vti.service;

import com.vti.entity.Category;
import com.vti.filter.CategoryFilter;
import com.vti.form.CreatingCategoryForm;
import com.vti.form.UpdatingCategoryForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    //List<Category> getAllCategory();

    void createCategory(CreatingCategoryForm form);

    void updateCategory(UpdatingCategoryForm form);

    void deleteCategory(int id);

    Category getCategoryById(int id);

    boolean isCategoryExistsByName(String name);

    Page<Category> getAllCategory(Pageable pageable, CategoryFilter form);
}
