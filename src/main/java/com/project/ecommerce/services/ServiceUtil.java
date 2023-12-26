package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;


public class ServiceUtil {

    public static ProductDTO convertFromClientResponse(FakeStoreResponseDTO fakeStoreResponseDTO) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(fakeStoreResponseDTO.getId());
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
}
