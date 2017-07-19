package by.service;

import by.dao.RoleDAO;
import by.model.RolesEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Роман on 18.07.2017.
 */
@Service
public class ServiceRole {
    private RoleDAO roleDAO;

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    @Transactional
    public String getRoleName(RolesEntity rolesEntity){
        return this.roleDAO.getRoleName(rolesEntity);
    }
}
