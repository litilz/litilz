package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.AboutUsEntity;
import com.ecommerce.repos.entity.PincodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeRepository extends JpaRepository<PincodeEntity, Integer> {
}
