package pl.sda.shop.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.sda.shop.model.Product;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary
public class RestProductDAO implements ProductDAO{

    @Value("${rest.students.url}")
    private String productsUrl;

    RestTemplate restTemplate;

    public RestProductDAO(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<Product[]> students = restTemplate.getForEntity(productsUrl, Product[].class, HttpStatus.OK);
        Product[] body = students.getBody();
        return Arrays.asList(body);
    }

    @Override
    public Product getProductById(int productId) {
        return restTemplate.getForObject(productsUrl + "/" + productId, Product.class);
    }

    @Override
    public void addProduct(Product product) {
        restTemplate.postForObject(productsUrl, product, Product.class);
    }

    @Override
    public void deleteProductDAO(int productId) {
        restTemplate.delete(productsUrl + "/" + productId);
    }
}
