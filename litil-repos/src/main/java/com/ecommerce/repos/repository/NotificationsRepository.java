package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.NotificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Integer> {
}
