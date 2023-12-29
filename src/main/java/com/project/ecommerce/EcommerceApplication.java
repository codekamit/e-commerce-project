package com.project.ecommerce;

import com.project.ecommerce.models.Category;
import com.project.ecommerce.models.Product;
import com.project.ecommerce.repositories.CategoryRepository;
import com.project.ecommerce.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

}
