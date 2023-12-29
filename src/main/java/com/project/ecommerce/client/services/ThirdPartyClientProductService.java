package com.project.ecommerce.client.services;

import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ThirdPartyClientProductService {
    List<FakeStoreResponseDTO> getAllProductsFromClient();
    FakeStoreResponseDTO getProductFromClient(UUID productId);
    FakeStoreResponseDTO addNewProductToClient(FakeStoreRequestDTO fakeStoreRequestDTO);
    FakeStoreResponseDTO updateProductInClient(FakeStoreRequestDTO fakeStoreRequestDTO, UUID productId);
    FakeStoreResponseDTO replaceProductInClient(FakeStoreRequestDTO fakeStoreRequestDTO, UUID productId);
    FakeStoreResponseDTO deleteProductFromClient(UUID productId);

}
