package com.project.ecommerce.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String categoryName;
}
