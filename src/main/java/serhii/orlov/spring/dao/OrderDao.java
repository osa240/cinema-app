package serhii.orlov.spring.dao;

import java.util.List;
import serhii.orlov.spring.model.Order;
import serhii.orlov.spring.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
