package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.CategoryDTO;
import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;
import com.project.ecommerce.models.Category;
import com.project.ecommerce.models.Product;


public class ServiceUtil {

    public static ProductDTO convertFromClientResponse(FakeStoreResponseDTO fakeStoreResponseDTO) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(fakeStoreResponseDTO.getProductId());
        productDTO.setTitle(fakeStoreResponseDTO.getTitle());
        productDTO.setDescription(fakeStoreResponseDTO.getDescription());
        productDTO.setCategory(fakeStoreResponseDTO.getCategory());
        productDTO.setImage(fakeStoreResponseDTO.getImage());
        productDTO.setPrice(fakeStoreResponseDTO.getPrice());
        return productDTO;
    }

    public static FakeStoreRequestDTO convertToClientRequest(GenericProductDTO genericProductDTO) {
        FakeStoreRequestDTO fakeStoreRequestDTO = new FakeStoreRequestDTO();
        fakeStoreRequestDTO.setTitle(genericProductDTO.getTitle());
        fakeStoreRequestDTO.setDescription(genericProductDTO.getDescription());
        fakeStoreRequestDTO.setCategory(genericProductDTO.getCategory());
        fakeStoreRequestDTO.setImage(genericProductDTO.getImage());
        fakeStoreRequestDTO.setPrice(genericProductDTO.getPrice());
        return fakeStoreRequestDTO;
    }

    public static ProductDTO convertProductToServerResponse(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImage());
        productDTO.setCategory(product.getCategory().getCategoryName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public static CategoryDTO convertCategoryToServerResponse(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setProductId(category.getId());
        categoryDTO.setCategoryName(categoryDTO.getCategoryName());
        return categoryDTO;
    }
}
