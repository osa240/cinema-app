package serhii.orlov.spring.service.impl;

import org.springframework.stereotype.Service;
import serhii.orlov.spring.dao.RoleDao;
import serhii.orlov.spring.exception.DataProcessingException;
import serhii.orlov.spring.model.Role;
import serhii.orlov.spring.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName)
                .orElseThrow(() -> new DataProcessingException("Role by role name: "
                        + roleName + " not find!"));
    }
}
