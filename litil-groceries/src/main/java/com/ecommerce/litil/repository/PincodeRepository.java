package com.ecommerce.litil.repository;

import com.ecommerce.litil.entity.AboutUsEntity;
import com.ecommerce.litil.entity.PincodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeRepository extends JpaRepository<PincodeEntity, Integer> {
}
