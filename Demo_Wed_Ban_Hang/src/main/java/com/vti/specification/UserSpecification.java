package com.vti.specification;

import com.vti.entity.User;
import com.vti.filter.UserFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification {
    private static final String USERNAME = "USERNAME";

    public static Specification<User> buildWhere(UserFilter form) {
        if (form == null) {
            return null;
        }

        Specification<User> whereSearchUsername = new SpecificationImpl(USERNAME, form.getSearch());
        return Specification.where(whereSearchUsername);
    }

    @AllArgsConstructor
    @Data
    private static class SpecificationImpl implements Specification<User> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }
            switch (key) {
                case USERNAME:
                    return criteriaBuilder.like(root.get("username"), "%" + value + "%");
                default:
                    return null;
            }
        }
    }
}
