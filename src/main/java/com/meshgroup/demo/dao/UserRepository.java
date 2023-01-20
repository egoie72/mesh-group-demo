package com.meshgroup.demo.dao;

import com.meshgroup.demo.dao.entity.EmailData;
import com.meshgroup.demo.dao.entity.PhoneData;
import com.meshgroup.demo.dao.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;

public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
    static Specification<User> searchSpec(final UserSearchCriteria criteria) {
        return (user, query, cb) -> {
            if (criteria.isFullFilled()) {
                final var predicates = new ArrayList<Predicate>();
                if (criteria.getName() != null) {
                    predicates.add(cb.like(user.get("name"), criteria.getName() + "%"));
                }
                if (criteria.getDateOfBirth() != null) {
                    predicates.add(cb.greaterThan(user.get("dateOfBirth"), criteria.getDateOfBirth()));
                }
                if (criteria.getPhone() != null) {
                    predicates.add(user.get("id").in(subquery(criteria.getPhone(), PhoneData.class, "phone", query, cb)));
                }
                if (criteria.getEmail() != null) {
                    predicates.add(user.get("id").in(subquery(criteria.getEmail(), EmailData.class, "email", query, cb)));
                }
                return cb.and(predicates.toArray(Predicate[]::new));
            } else {
                return null;
            }
        };
    }

    private static <T> Subquery<Long> subquery(final String value, final Class<T> entity, final String field,
                                               final CriteriaQuery<?> query, final CriteriaBuilder cb) {
        final var subquery = query.subquery(Long.class);
        final var emailData = subquery.from(entity);
        subquery.select(emailData.get("user").get("id"))
                .where(cb.equal(emailData.get(field), value));
        return subquery;
    }
}
