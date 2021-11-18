package serhii.orlov.spring.service;

import serhii.orlov.spring.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
