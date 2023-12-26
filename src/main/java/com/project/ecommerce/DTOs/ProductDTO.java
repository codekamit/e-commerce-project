package com.project.ecommerce.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String title;
    private String image;
    private String description;
    private double price;
    private String category;
}
