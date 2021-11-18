package serhii.orlov.spring.dao;

import java.util.Optional;
import serhii.orlov.spring.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
