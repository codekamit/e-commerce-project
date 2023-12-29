package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProduct(UUID productId);
    ProductDTO addNewProduct(GenericProductDTO genericProductDTO);
    ProductDTO updateProduct(GenericProductDTO genericProductDTO, UUID productId);
    ProductDTO replaceProduct(GenericProductDTO genericProductDTO, UUID productId);
    void deleteProduct(UUID productId);
    void addAllProducts(List<GenericProductDTO> newProducts);
}
