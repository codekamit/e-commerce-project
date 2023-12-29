package com.project.ecommerce.client.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FakeStoreResponseDTO {
    private UUID productId;
    private String title;
    private String image;
    private String description;
    private double price;
    private String category;
}
