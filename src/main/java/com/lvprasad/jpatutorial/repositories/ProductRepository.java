package com.lvprasad.jpatutorial.repositories;

import com.lvprasad.jpatutorial.entites.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCategory(String category);

    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);


    @Query("select e from ProductEntity e where e.price>=?1")
    List<ProductEntity> findByTitleAndPrice(BigDecimal price);
}
