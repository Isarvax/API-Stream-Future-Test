package org.example;

import org.example.domain.enumm.ProductCategory;
import org.example.domain.initializer.DataInitializer;
import org.example.domain.models.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> products = DataInitializer.initializeProducts();
        ProductFilter filter = new ProductFilter();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println("Menú");
            System.out.println("1. Productos filtrados por Libros y precio menor a 100.000");
            System.out.println("2. Productos filtrados por categoria: Bebé");
            System.out.println("3. Productos filtrados por categoria: Juguetes (10% descuento)");
            System.out.println("4. Filtrar el libro más barato del catálogo");
            System.out.println("5. Exit");
            System.out.print("Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1: filter.getFilteredProductsBooks(products);
                    break;

                case 2: filter.getFilteredProductsBaby(products);
                    break;

                case 3: filter.getFilteredProductsToys(products);
                    break;

                case 4: filter.getCheapestBook(products);
                    break;

                case 10:
                    System.out.println("Thank you, bye.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }

}
