package com.me.DAO;

import static com.me.DAO.DAO.getSession;
import com.me.pojo.HealthValues;
import com.me.pojo.Medication;
import com.me.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class UserDAO extends DAO {
    public int saveUser(User user) {
            begin();
            int id = (int) getSession().save(user);
            commit();
            return id;
    }
    
   public boolean checkifEmailAlreadyExists(String email){
       begin();
       Query<User> query = getSession().createQuery("FROM User WHERE email = :email",User.class);
       query.setParameter("email", email);
       
       if (query.uniqueResult() == null){
           close();
            return false;
       }
       else{
           close();
            return true;
       }
   }
   
   public User loginUser(String email,String password){
       begin();
       Query<User> query = getSession().createQuery("FROM User WHERE email = :email AND password = :password",User.class);
       query.setParameter("email", email);
       query.setParameter("password", password);
       if (query.uniqueResult() == null){
           close();
            return null;
       }   
        else{
            return query.uniqueResult();
             }
   }
   
   public User getUserById(int id){
       begin();
       User user = getSession().get(User.class,id);
       commit();
       return user;
   }
}
