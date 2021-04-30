package com.barbarhood.app.repository;

import com.barbarhood.app.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long>,
        JpaSpecificationExecutor<Manufacturer> {

}
