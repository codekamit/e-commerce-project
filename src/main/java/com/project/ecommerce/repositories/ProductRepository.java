package com.project.ecommerce.repositories;

import com.project.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
