package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.PincodeEntity;
import com.ecommerce.repos.entity.Q_AEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Q_ARepository extends JpaRepository<Q_AEntity, Integer> {

}
