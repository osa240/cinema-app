package serhii.orlov.spring.dao;

import serhii.orlov.spring.model.ShoppingCart;
import serhii.orlov.spring.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
