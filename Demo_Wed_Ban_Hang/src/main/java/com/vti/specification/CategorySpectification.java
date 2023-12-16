package com.vti.specification;
import com.vti.entity.Category;
import com.vti.entity.Product;
import com.vti.filter.CategoryFilter;
import com.vti.filter.ProductFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
public class CategorySpectification {
    private static final String SEARCH_CATEGORYNAME = "SEARCH_CATEGORYNAME";
    public static Specification<Category> buildWhere(CategoryFilter form) {
        if (form == null) {
            return null;
        }
        Specification<Category> WhereCategoryName = new SpecificationImpl(SEARCH_CATEGORYNAME,form.getSearch());
        return Specification.where(WhereCategoryName);
    }
    @AllArgsConstructor
    static class SpecificationImpl implements Specification<Category> {

        private String key;

        private Object value;

        @Override
        public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }

            switch (key) {
                case SEARCH_CATEGORYNAME:
                    return criteriaBuilder.like(root.get("category"), "%"+ value+ "%");
                default:
                    return null;
            }
        }
    }
}
