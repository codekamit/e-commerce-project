package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;
import com.project.ecommerce.client.services.ThirdPartyClientProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductService implements ProductService {
    private final ThirdPartyClientProductService thirdPartyClientProductServiceService;
    public FakeStoreProductService(ThirdPartyClientProductService thirdPartyClientProductService) {
        this.thirdPartyClientProductServiceService = thirdPartyClientProductService;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        var products = thirdPartyClientProductServiceService.getAllProductsFromClient();
        return products.stream()
                .map(ServiceUtil::convertFromClientResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(UUID productId) {
        var response = thirdPartyClientProductServiceService.getProductFromClient(productId);
        return ServiceUtil.convertFromClientResponse(response);
    }

    @Override
    public ProductDTO addNewProduct(GenericProductDTO genericProductDTO) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ServiceUtil.convertToClientRequest(genericProductDTO);
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.addNewProductToClient(fakeStoreRequestDTO);
        return ServiceUtil.convertFromClientResponse(fakeStoreResponseDTO);
    }

    @Override
    public ProductDTO updateProduct(GenericProductDTO genericProductDTO, UUID productId) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ServiceUtil.convertToClientRequest(genericProductDTO);
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.updateProductInClient(fakeStoreRequestDTO, productId);
        return ServiceUtil.convertFromClientResponse(fakeStoreResponseDTO);
    }

    @Override
    public ProductDTO replaceProduct(GenericProductDTO genericProductDTO, UUID productId) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ServiceUtil.convertToClientRequest(genericProductDTO);
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.replaceProductInClient(fakeStoreRequestDTO, productId);
        return ServiceUtil.convertFromClientResponse(fakeStoreResponseDTO);
    }

    @Override
    public void deleteProduct(UUID productId) {
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.deleteProductFromClient(productId);
    }

    @Override
    public void addAllProducts(List<GenericProductDTO> newProducts) {
        newProducts.forEach(this::addNewProduct);
    }
}
