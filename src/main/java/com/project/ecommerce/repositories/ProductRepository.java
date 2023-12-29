package com.project.ecommerce.repositories;

import com.project.ecommerce.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("productrepository")
@Transactional
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
