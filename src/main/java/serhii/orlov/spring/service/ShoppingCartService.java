package serhii.orlov.spring.service;

import serhii.orlov.spring.model.MovieSession;
import serhii.orlov.spring.model.ShoppingCart;
import serhii.orlov.spring.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
