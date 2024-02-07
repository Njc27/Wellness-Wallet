package com.me.DAO;

import com.me.pojo.HealthValues;
import com.me.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class HealthValuesDAO extends DAO {
    public void saveHealth(HealthValues healthValue) {
            begin();
            getSession().save(healthValue);
            commit();

    }
    
    public List<HealthValues> getHealthDataByUserId(User user) {
        Query q = getSession().createQuery("From HealthValues Where user = :user", HealthValues.class);
        q.setParameter("user", user);
        return q.list();
    }
    
    public HealthValues getHealthDataById(int healthId) {
        HealthValues health= getSession().get( HealthValues.class,healthId);
        return health;
    }
    
    public void updateHealth(HealthValues healthValue) {
            begin();
            getSession().persist(healthValue);
            commit();

    }
    
    
}
