package com.vti.specification;

import com.vti.entity.Product;
import com.vti.filter.ProductFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification {
    private static final String SEARCH_NAME = "SEARCH_NAME";
    private static final String SEARCH_CATEGORYNAME = "SEARCH_CATEGORYNAME";

    public static Specification<Product> buildWhere(ProductFilter form) {
        if (form == null) {
            return null;
        }

        CustomSpecification WhereName = new CustomSpecification(SEARCH_NAME, form.getSearch());
        CustomSpecification WhereCategoryName = new CustomSpecification(SEARCH_CATEGORYNAME, form.getCategoryName());
        return Specification.where(WhereName.or(WhereCategoryName));
    }

    @AllArgsConstructor
    static class CustomSpecification implements Specification<Product> {

        private String key;

        private Object value;

        @Override
        public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }

            switch (key) {
                case SEARCH_NAME:
                    return criteriaBuilder.like(root.get("name"), "%" + value.toString().trim() + "%");

                case SEARCH_CATEGORYNAME:
                    return criteriaBuilder.equal(root.get("category").get("name"), value.toString().trim());
                default:
                    return null;
            }
        }
    }
}
