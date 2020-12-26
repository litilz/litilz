package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.AddressEntity;
import com.ecommerce.repos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {


    @Query("SELECT u FROM AddressEntity u WHERE u.user_id  = :user_id AND u.enabled = :aTrue")
    List<AddressEntity> findUserAddress(UserEntity user_id, Boolean aTrue);

    @Query("SELECT u FROM AddressEntity u WHERE u.user_id  = :user_id AND u.active = :active AND u.enabled = :enabled")
    AddressEntity findDefault(UserEntity user_id, boolean active, boolean enabled);

    @Transactional
    @Modifying
    @Query("update AddressEntity u set u.enabled = :aFalse where u.id = :id")
    void deleteAddress(Integer id, Boolean aFalse);
}