package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.CategoryDTO;
import com.project.ecommerce.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CategoryService {
    List<CategoryDTO> getAllcategories();
    CategoryDTO getCategory(UUID categoryId);
    Category getCategoryByName(String categoryName);

}
