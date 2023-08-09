package org.example;

import org.example.domain.enumm.ProductCategory;
import org.example.domain.models.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {

    public List<Product> getFilteredProductsBooks(List<Product> products) {
        String category ="libros";
        List<Product> filteredProducts =  products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .filter(e->e.getPrice()>100)
                .toList();
        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return filteredProducts;

    }

    public   List<Product> getFilteredProductsBaby(List<Product> products){
        String category = "bebe";

        List<Product> filteredProducts = products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .toList();

        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return filteredProducts;
    }

    public   List<Product> getFilteredProductsToys(List<Product> products){
        String category = "juguetes";
        List<Product> filteredProducts = products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .map(e -> new Product(e.getId(), e.getName(), e.getCategory(), applyDiscount(e.getPrice())))
                .collect(Collectors.toList());

        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return filteredProducts;

    }

    public   double applyDiscount(double price){
        double discount = 0.1;
        return price - (price * discount);
    }

    public   List<Product> getCheapestBook(List<Product> products){
        String category = "libros";
        List<Product> filteredProducts = products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .min(Comparator.comparingDouble(Product::getPrice))
                .stream().toList();

        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return  filteredProducts;

    }

}