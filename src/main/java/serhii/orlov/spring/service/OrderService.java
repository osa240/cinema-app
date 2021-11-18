package serhii.orlov.spring.service;

import java.util.List;
import serhii.orlov.spring.model.Order;
import serhii.orlov.spring.model.ShoppingCart;
import serhii.orlov.spring.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
