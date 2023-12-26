package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;
import com.project.ecommerce.client.services.FakeStoreProductClientService;
import com.project.ecommerce.client.services.ThirdPartyClientProductService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductService implements ProductService {
    private ThirdPartyClientProductService thirdPartyClientProductServiceService;
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
    public ProductDTO getProduct(Long id) {
        var response = thirdPartyClientProductServiceService.getProductFromClient(id);
        return ServiceUtil.convertFromClientResponse(response);
    }

    @Override
    public ProductDTO addNewProduct(GenericProductDTO genericProductDTO) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ServiceUtil.convertToClientRequest(genericProductDTO);
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.addNewProductToClient(fakeStoreRequestDTO);
        return ServiceUtil.convertFromClientResponse(fakeStoreResponseDTO);
    }

    @Override
    public ProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ServiceUtil.convertToClientRequest(genericProductDTO);
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.updateProductInClient(fakeStoreRequestDTO, id);
        return ServiceUtil.convertFromClientResponse(fakeStoreResponseDTO);
    }

    @Override
    public ProductDTO replaceProduct(GenericProductDTO genericProductDTO, Long id) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ServiceUtil.convertToClientRequest(genericProductDTO);
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.replaceProductInClient(fakeStoreRequestDTO, id);
        return ServiceUtil.convertFromClientResponse(fakeStoreResponseDTO);
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        FakeStoreResponseDTO fakeStoreResponseDTO = thirdPartyClientProductServiceService.deleteProductFromClient(id);
        return ServiceUtil.convertFromClientResponse(fakeStoreResponseDTO);
    }
}
