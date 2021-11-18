package serhii.orlov.spring.service;

import serhii.orlov.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
