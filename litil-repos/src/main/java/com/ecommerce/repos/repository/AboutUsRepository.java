package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.AboutUsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AboutUsRepository extends JpaRepository<AboutUsEntity, Integer> {
}
