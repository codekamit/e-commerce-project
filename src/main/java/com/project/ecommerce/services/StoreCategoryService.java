package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.CategoryDTO;
import com.project.ecommerce.exceptions.CategoryNotFoundException;
import com.project.ecommerce.models.Category;
import com.project.ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class StoreCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;
    public StoreCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllcategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList
                .stream()
                .map(ServiceUtil::convertCategoryToServerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategory(UUID categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);
        return ServiceUtil.convertCategoryToServerResponse(category);
    }


    public Category getCategoryByName(String categoryName) {
        Optional<Category> categoryOptional = categoryRepository.
                getCategoryByCategoryName(categoryName);
        if(categoryOptional.isEmpty()) {
            Category category = new Category();
            category.setCategoryName(categoryName);
            return categoryRepository.save(category);
        }
        else {
            return categoryOptional.get();
        }
    }
}
