package com.ecommerce.litil.repository;

import com.ecommerce.litil.entity.AboutUsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AboutUsRepository extends JpaRepository<AboutUsEntity, Integer> {
}
