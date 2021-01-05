package com.ecommerce.litil.repository;

import com.ecommerce.litil.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Integer> {

    @Query("SELECT pe FROM ProductEntity pe where pe.availability = :availability and pe.category = :category")
    List <ProductEntity> findByCategory( String category, boolean availability);

    @Query("SELECT pe FROM ProductEntity pe where pe.name LIKE %:productname%")
    List<ProductEntity> findProductByName(@Param("productname") String productname);

}
