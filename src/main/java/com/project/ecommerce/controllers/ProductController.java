package com.project.ecommerce.controllers;

import com.project.ecommerce.DTOs.GenericProductDTO;
import com.project.ecommerce.DTOs.ProductDTO;
import com.project.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ProductDTO getProductFromClient(@PathVariable(value = "id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    public ProductDTO addNewProductToClient(@RequestBody GenericProductDTO genericProductDTO) {
        return productService.addNewProduct(genericProductDTO);
    }

    @PatchMapping("{id}")
    public ProductDTO updateProductinClient(@RequestBody GenericProductDTO genericProductDTO, @PathVariable("id") Long id) {
        return productService.updateProduct(genericProductDTO, id);
    }

    @PutMapping("{id}")
    public ProductDTO replaceProductinClient(@RequestBody GenericProductDTO genericProductDTO, @PathVariable("id") Long id) {
        return productService.replaceProduct(genericProductDTO, id);
    }

    @DeleteMapping("{id}")
    public ProductDTO deleteProductFromClient(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
