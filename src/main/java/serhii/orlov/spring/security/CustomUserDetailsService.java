package serhii.orlov.spring.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import serhii.orlov.spring.model.User;
import serhii.orlov.spring.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserBuilder userBuilder = withUsername(email);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRoles()
                    .stream().map(r -> r.getName().getStringName())
                    .toArray(String[]::new));
            return userBuilder.build();
        }
        throw new UsernameNotFoundException("Can't load UserDetails by email: " + email);
    }
}
