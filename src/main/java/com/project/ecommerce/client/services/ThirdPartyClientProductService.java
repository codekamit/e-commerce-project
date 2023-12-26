package com.project.ecommerce.client.services;

import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThirdPartyClientProductService {
    List<FakeStoreResponseDTO> getAllProductsFromClient();
    FakeStoreResponseDTO getProductFromClient(Long id);
    FakeStoreResponseDTO addNewProductToClient(FakeStoreRequestDTO fakeStoreRequestDTO);
    FakeStoreResponseDTO updateProductInClient(FakeStoreRequestDTO fakeStoreRequestDTO, Long id);
    FakeStoreResponseDTO replaceProductInClient(FakeStoreRequestDTO fakeStoreRequestDTO, Long id);
    FakeStoreResponseDTO deleteProductFromClient(Long id);

}
