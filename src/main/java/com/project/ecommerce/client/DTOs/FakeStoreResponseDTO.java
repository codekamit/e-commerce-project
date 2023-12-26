package com.project.ecommerce.client.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO {
    private Long id;
    private String title;
    private String image;
    private String description;
    private double price;
    private String category;
}
