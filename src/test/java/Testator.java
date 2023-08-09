import org.example.Main;
import org.example.ProductFilter;
import org.example.domain.initializer.DataInitializer;
import org.example.domain.models.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testator {
    @Test
    public void testGetFilteredProductsBaby() {
        ProductFilter filter=new ProductFilter();
        List<Product> products = DataInitializer.initializeProducts();
        List<Product> filteredProducts = filter.getFilteredProductsBaby(products);
        assertEquals("bebe", filteredProducts.get(0).getCategory().getValue());
    }

    @Test
    public void testGetFilteredProductsToys() {
        ProductFilter filter=new ProductFilter();
        List<Product> products = DataInitializer.initializeProducts();
        List<Product> filteredProducts = filter.getFilteredProductsToys(products);
        assertEquals("juguetes", filteredProducts.get(0).getCategory().getValue());
    }

    @Test
    public void testGetCheapest() {
        ProductFilter filter=new ProductFilter();
        List<Product> products = DataInitializer.initializeProducts();
        List<Product> filteredProducts = filter.getCheapestBook(products);
        assertEquals("La biblia", filteredProducts.get(0).getName());
    }
}
