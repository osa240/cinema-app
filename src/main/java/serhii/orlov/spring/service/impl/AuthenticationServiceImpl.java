package serhii.orlov.spring.service.impl;

import java.util.Set;
import org.springframework.stereotype.Service;
import serhii.orlov.spring.model.Role;
import serhii.orlov.spring.model.User;
import serhii.orlov.spring.service.AuthenticationService;
import serhii.orlov.spring.service.RoleService;
import serhii.orlov.spring.service.ShoppingCartService;
import serhii.orlov.spring.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Role roleUser = roleService.getRoleByName("USER");
        user.setRoles(Set.of(roleUser));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
