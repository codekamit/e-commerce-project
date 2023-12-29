package com.project.ecommerce.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {
    @NotNull
    private String title;

    private String image;
    @NotNull
    private String description;
    @NotNull
    private double price;
    @NotNull
    private String category;
}
