package com.project.ecommerce.controllers;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.GenericResponse;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDTO> getAllProductsFromClient() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ProductDTO getProductFromClient(@PathVariable(value = "id") UUID productId) {
        return productService.getProduct(productId);
    }

    @PostMapping()
    public ProductDTO addNewProductToClient(@Valid @RequestBody GenericProductDTO genericProductDTO) {
        return productService.addNewProduct(genericProductDTO);
    }

    @PostMapping("add")
    public ResponseEntity<GenericResponse> addProductsToClient(@Valid @RequestBody List<GenericProductDTO> genericProductDTOList) {
        productService.addAllProducts(genericProductDTOList);
        GenericResponse response = new GenericResponse();
        response.setTimeStamp(LocalDateTime.now());
        response.setMessage("Successfully added all the producst");
        response.setStatus(HttpStatus.CREATED);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("{id}")
    public ProductDTO updateProductinClient(@Valid @RequestBody GenericProductDTO genericProductDTO, @PathVariable("id") UUID productId) {
        return productService.updateProduct(genericProductDTO, productId);
    }

    @PutMapping("{id}")
    public ProductDTO replaceProductinClient(@Valid @RequestBody GenericProductDTO genericProductDTO, @PathVariable("id") UUID productId) {
        return productService.replaceProduct(genericProductDTO, productId);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericResponse> deleteProductFromClient(@PathVariable("id") UUID productId) {
        productService.deleteProduct(productId);
        GenericResponse response = new GenericResponse();
        response.setTimeStamp(LocalDateTime.now());
        response.setMessage("Product with id:"+productId+ " deleted successfully.");
        response.setStatus(HttpStatus.OK);
        return ResponseEntity.ok().body(response);
    }
}
