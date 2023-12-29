package com.project.ecommerce.repositories;

import com.project.ecommerce.models.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("categoryrepository")
@Transactional
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> getCategoryByCategoryName(String categoryName);
}
