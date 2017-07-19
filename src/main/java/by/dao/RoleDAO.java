package by.dao;

import by.model.RolesEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Роман on 18.07.2017.
 */
@Repository
public class RoleDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public String getRoleName(RolesEntity rolesEntity){
        return rolesEntity.getName();
    }

}
