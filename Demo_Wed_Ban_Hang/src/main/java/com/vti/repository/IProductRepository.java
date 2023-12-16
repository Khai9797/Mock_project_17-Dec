package com.vti.repository;

import com.vti.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    Product findByName(String name);

    boolean existsByName(String name);
    boolean existsById(int id);

    Product findById(int id);
}
