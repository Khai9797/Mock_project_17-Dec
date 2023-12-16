package com.vti.repository;

import com.vti.entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IManufactureRepository extends JpaRepository<Manufacture, Integer>, JpaSpecificationExecutor<Manufacture> {
    boolean existsByName(String name);

    Manufacture findById(int id);
}
