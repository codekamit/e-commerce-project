package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProduct(Long id);
    ProductDTO addNewProduct(GenericProductDTO genericProductDTO);
    ProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id);
    ProductDTO replaceProduct(GenericProductDTO genericProductDTO, Long id);
    ProductDTO deleteProduct(Long id);
}
