package com.vti.repository;

import com.vti.entity.Category;
import com.vti.filter.CategoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

    boolean existsByName(String name);

    Category findById(int id);
}
