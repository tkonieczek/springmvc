package pl.sda.shop.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.shop.model.CartItem;
import pl.sda.shop.model.Product;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
        items.add(new CartItem(1,"Wodka", 5));

    }

    public void addItemToCart(CartItem cartItem) {
        items.add(cartItem);
    }

    public void addItemToCart(Product cartItem, int quantity) {
        //items.add(cartItem);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void cleanCart() {
        items.clear();
    }
}
