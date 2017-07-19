package by.service;

import by.dao.UserDAO;
import by.model.UsersEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Роман on 18.07.2017.
 */
@Service
public class ServiceUser {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional
    public UsersEntity fingOnAuth(String login, String password){
return userDAO.fingOnAuth(login,password);
    }
}
