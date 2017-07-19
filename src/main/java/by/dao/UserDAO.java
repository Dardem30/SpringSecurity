package by.dao;

import by.model.UsersEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Роман on 18.07.2017.
 */
@Repository
public class UserDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public UsersEntity fingOnAuth(String login,String password){
//        UsersEntity usersEntity=null;
//        String[] paramsName={"login","password"};
//        Object[] paramValue={login,password};
//        Collection<UsersEntity> usersEntityCollection=
        Query query=this.sessionFactory.getCurrentSession().createQuery("from UsersEntity where username=:login and password=:password");
        query.setString("login",login);
        query.setString("password",password);
        UsersEntity usersEntity= (UsersEntity) query.uniqueResult();
        return usersEntity;
    }
}
