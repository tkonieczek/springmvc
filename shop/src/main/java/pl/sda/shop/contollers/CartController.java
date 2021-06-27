package pl.sda.shop.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.shop.model.CartItem;
import pl.sda.shop.services.Cart;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    Cart cart;

    @GetMapping("/list")
    public String getCartItems(Model model) {
        model.addAttribute("allItems", cart.getItems());
        return "cart";
    }

    // dodanie dla koszyka SPOSOB 1 i SPOSOB 2
/*    @PostMapping("/add")
    public String addProductToCart(CartItem cartItem) {
        cart.addItemToCart(cartItem);
        return "redirect:/products/" + cartItem.getProductId();
    }*/

    // dodanie dla koszyka SPOSOB 3
    @PostMapping("/add")
    public String addProductToCart(@RequestParam int quantity, @RequestParam String productName, @RequestParam int productId) {
        CartItem cartItem = new CartItem(productId, productName, quantity);
        cart.addItemToCart(cartItem);
        return "redirect:/products/" + cartItem.getProductId();
    }
}
