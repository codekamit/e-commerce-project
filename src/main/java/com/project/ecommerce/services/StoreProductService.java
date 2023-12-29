package com.project.ecommerce.services;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.exceptions.ProductNotFoundException;
import com.project.ecommerce.models.Category;
import com.project.ecommerce.models.Product;
import com.project.ecommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
public class StoreProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryService categoryService;
    public StoreProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ServiceUtil::convertProductToServerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        return ServiceUtil.convertProductToServerResponse(product);
    }

    @Override
    @Transactional
    public ProductDTO addNewProduct(GenericProductDTO genericProductDTO) {
        Category category = categoryService.getCategoryByName(genericProductDTO.getCategory());
        Product product = new Product();
                product.setTitle(genericProductDTO.getTitle());
                product.setDescription(genericProductDTO.getDescription());
                product.setImage(genericProductDTO.getImage());
                product.setCategory(category);
                product.setPrice(genericProductDTO.getPrice());
        productRepository.save(product);
        return ServiceUtil.convertProductToServerResponse(product);
    }

    @Transactional
    public void addAllProducts(List<GenericProductDTO> newProducts) {
        newProducts.forEach(this::addNewProduct);
    }

    @Override
    public ProductDTO updateProduct(GenericProductDTO genericProductDTO, UUID productId) {
        return null;
    }

    @Override
    public ProductDTO replaceProduct(GenericProductDTO genericProductDTO, UUID productId) {
        return null;
    }

    @Override
    @Transactional
    public void deleteProduct(UUID productId) {
        if(productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return;
        }
        throw new ProductNotFoundException();
    }
}
