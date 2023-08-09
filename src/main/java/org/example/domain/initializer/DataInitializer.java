package org.example.domain.initializer;



import org.example.domain.enumm.ClientTier;
import org.example.domain.enumm.ProductCategory;
import org.example.domain.models.Customer;
import org.example.domain.models.Order;
import org.example.domain.models.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static Order initializeOrder() {

        Order order = new Order(1L, "Waiting", LocalDate.now(),LocalDate.now().plusDays(7), initializeProducts(),initializeCustomer());
        return order;
    }

    public static List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product(1L, "La biblia", ProductCategory.BOOKS, 50000.0);
        products.add(product1);

        Product product2 = new Product(2L, "Don Quijote", ProductCategory.BOOKS,65000.0);
        products.add(product2);

        Product product3 = new Product(3L,"Tetero", ProductCategory.BABY,100000.0);
        products.add(product3);

        Product product4 = new Product(4L,"Barbie",ProductCategory.TOYS,40000.0);
        products.add(product4);

        return products;
    }

    public static List<Customer> initializeCustomer() {

        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer(1L, "Martin Villegas", ClientTier.TYPE1 );
        customers.add(customer1);

        Customer customer2 = new Customer(2L, "Juan felpe", ClientTier.TYPE2);
        customers.add(customer2);
        Customer customer3 = new Customer(3L, "Ricardo Daniel", ClientTier.TYPE3);



        return customers;
    }
}
