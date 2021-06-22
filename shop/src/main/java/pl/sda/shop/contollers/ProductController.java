package pl.sda.shop.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.shop.dao.ProductDAO;
import pl.sda.shop.model.Product;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productService) {
        this.productDAO = productService;
    }

    @GetMapping("/list")
    public String getProducts(Model model) {
        List<Product> allProducts = productDAO.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "products_list";
    }

    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable int id) {
        Product productById = productDAO.getProductById(id);
        model.addAttribute("product", productById);
        return "product_details";
    }


    @GetMapping("/newproduct")
    public String getProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new_product_form";
    }

    @PostMapping("/newproduct")
    public String addNewProduct(Product product) {
        productDAO.addProduct(product);
        return "redirect:/products/list";
    }

}
