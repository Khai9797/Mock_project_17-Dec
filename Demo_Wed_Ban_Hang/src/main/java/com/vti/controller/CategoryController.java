package com.vti.controller;

import com.vti.dto.CategoryDTO;
import com.vti.entity.Category;
import com.vti.filter.CategoryFilter;
import com.vti.form.CreatingCategoryForm;
import com.vti.form.UpdatingCategoryForm;
import com.vti.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<Page<CategoryDTO>> getAllCategory(Pageable pageable, CategoryFilter form) {
        Page<Category> page = categoryService.getAllCategory(pageable, form);
        List<CategoryDTO> categoryDTOS = modelMapper.map(page.getContent(), new TypeToken<List<CategoryDTO>>() {
        }.getType());
        return new ResponseEntity<>(new PageImpl<>(categoryDTOS,pageable, page.getTotalElements()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CreatingCategoryForm form) {
        categoryService.createCategory(form);
        return new ResponseEntity<>("Tao category thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable(name = "id") int id, @RequestBody UpdatingCategoryForm form) {
        form.setId(id);
        categoryService.updateCategory(form);
        return new ResponseEntity<>("update category thanh cong", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id")  int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("delete category thanh cong", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(modelMapper.map(categoryService.getCategoryById(id), CategoryDTO.class), HttpStatus.OK);
    }
    @GetMapping(value = "/categories/{name}")
    public ResponseEntity<?> isCategoryExistsByName(@PathVariable(name = "name") String name) {
        // get entity
        boolean result = categoryService.isCategoryExistsByName(name);

        // return result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
