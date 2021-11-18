package serhii.orlov.spring.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import serhii.orlov.spring.dao.AbstractDao;
import serhii.orlov.spring.dao.RoleDao;
import serhii.orlov.spring.exception.DataProcessingException;
import serhii.orlov.spring.model.Role;
import serhii.orlov.spring.model.RoleName;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> findRoleByName = session.createQuery("FROM Role r "
                    + "WHERE r.name = :roleName", Role.class);
            findRoleByName.setParameter("roleName", RoleName.getRoleNameByString(roleName));
            return findRoleByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with role name: " + roleName + " not found", e);
        }
    }
}
