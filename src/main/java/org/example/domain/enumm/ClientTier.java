package org.example.domain.enumm;

import java.util.Arrays;

public enum ClientTier {

    TYPE1("Tier1"),
    TYPE2("Tier2"),
    TYPE3("Tier3");

    private final String valueClient;

    public String getValue() {
        return valueClient;
    }


    ClientTier(String valueClient) {
        this.valueClient = valueClient;
    }

    public static ProductCategory fromValueClient(String valueClient) {
        return Arrays.stream(ProductCategory.values())
                .filter(e->e.getValue().equalsIgnoreCase(valueClient))
                .findAny()
                .orElseThrow(()->new RuntimeException("Category not found"));

    }

}
