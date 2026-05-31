package com.lvprasad.jpatutorial;


import com.lvprasad.jpatutorial.entites.ProductEntity;
import com.lvprasad.jpatutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class jpaTutorialTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void repositoryTest(){

        ProductEntity product = ProductEntity.builder()
                .title("Dell Monitor")
                .description("Ultra HD 27 inch monitor")
                .price(BigDecimal.valueOf(18889.25))
                .category("Electronics")
                .quantity(15)
                .build();

        ProductEntity savedProductEntity =  productRepository.save(product);
        System.out.println(savedProductEntity);

    }

    @Test
    void
    getProductRepositoryTest(){
//        List<ProductEntity> products = productRepository.findByTitle("Dell Monitor");

         List<ProductEntity> products = productRepository.findByTitleAndPrice(BigDecimal.valueOf(6500.00));
        for (ProductEntity product : products) {
            System.out.println(product);
        }
//        System.out.println(products);
    }



}
