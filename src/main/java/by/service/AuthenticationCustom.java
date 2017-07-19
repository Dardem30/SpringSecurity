package by.service;

import by.dao.UserDAO;
import by.model.RolesEntity;
import by.model.UsersEntity;
import by.service.ServiceUser;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 18.07.2017.
 */
@Service
public class AuthenticationCustom implements AuthenticationProvider{
     @Autowired
     private UserDAO userDAO;

    @Override
      @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login=authentication.getName();
        String password=authentication.getCredentials().toString();
          UsersEntity usersEntity=userDAO.fingOnAuth(login,password);
          if(usersEntity!=null){
              List<GrantedAuthority> list=new ArrayList<>();
              for(RolesEntity rolesEntity: usersEntity.getRoles()) {
                  list.add(new SimpleGrantedAuthority(rolesEntity.getName()));
              }
              return new UsernamePasswordAuthenticationToken(login,password,list);
          }else {
              return null;
          }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
