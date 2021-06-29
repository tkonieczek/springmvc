package pl.sda.shop.dao;

import org.springframework.stereotype.Repository;
import pl.sda.shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ListProductDAO implements ProductDAO{

    List<Product> products;

    public ListProductDAO() {
        products = new ArrayList<>();
        products.add(new Product("Mleko", "Pyszne mleko", "prod_1.png", 10));
        products.add(new Product("Kasza", "Pyszne kasza", "prod_2.png", 10));
        products.add(new Product("Chleb", "Pyszny chleb", "prod_3.png", 10));
    }


    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        Optional<Product> first = products.stream().filter(product -> product.getId() == productId).findFirst();
        if(first.isPresent()) {
            return first.get();
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProductDAO(int productId) {

    }

}
