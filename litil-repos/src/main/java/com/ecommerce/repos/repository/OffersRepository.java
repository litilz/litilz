package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.OffersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersRepository extends JpaRepository<OffersEntity, Integer> {
}
