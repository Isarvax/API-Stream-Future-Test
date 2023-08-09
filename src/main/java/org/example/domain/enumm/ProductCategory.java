package org.example.domain.enumm;

import java.util.Arrays;

public enum ProductCategory {

    BOOKS("libros"),
    BABY("bebe"),
    TOYS("juguetes");

    private final String value;

    public String getValue() {
        return value;
    }

    ProductCategory(String value) {
        this.value = value;
    }

    public static ProductCategory fromValue(String value) {
        return Arrays.stream(ProductCategory.values())
                .filter(e->e.getValue().equalsIgnoreCase(value))
                .findAny()
                .orElseThrow(()->new RuntimeException("Category not found"));

    }
}
