package pl.sda.shop.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.sda.shop.dao.ProductDAO;
import pl.sda.shop.model.Product;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
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
    public String addNewProduct(Product product, @RequestParam("imageFile") MultipartFile file) {
        productDAO.addProduct(product);
        uploadFile(file);
        return "redirect:/products/list";

    }
    private void uploadFile(MultipartFile file) {

        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
