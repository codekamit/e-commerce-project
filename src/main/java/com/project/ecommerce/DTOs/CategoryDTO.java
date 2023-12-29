package com.project.ecommerce.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryDTO {
    private UUID productId;
    @NotNull
    private String categoryName;
}
