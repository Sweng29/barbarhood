package com.barbarhood.app.specifications;

import com.barbarhood.app.model.Manufacturer;
import com.barbarhood.app.payload.request.BarbarhoodPageRequest;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ManufacturerSpecification {

    private ManufacturerSpecification(){}

    public static Specification<Manufacturer> filter(BarbarhoodPageRequest filterAttributes) {

        return (root, cq, cb) -> {

            final Collection<Predicate> predicates = new ArrayList<>();
            applyKeywordSearch(root, cb, predicates, filterAttributes.getKeyword());
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static void applyKeywordSearch(
            Root<Manufacturer> root,
            CriteriaBuilder cb,
            Collection<Predicate> predicates,
            String keyword) {
        if (keyword !=null && !keyword.trim().equals(""))
        {
            predicates.add(cb.or(
                    cb.like(root.get("manufacturerName"),"%" + keyword +"%")
            ));
        }
    }

}
