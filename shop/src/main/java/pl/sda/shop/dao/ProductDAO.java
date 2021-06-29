package pl.sda.shop.dao;

import pl.sda.shop.model.Product;

import java.util.List;

public interface ProductDAO {


    List<Product> getAllProducts();

    Product getProductById(int productId);

    void addProduct(Product product);

    void deleteProductDAO(int productId);


}
