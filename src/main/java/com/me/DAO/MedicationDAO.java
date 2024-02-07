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
public class MedicationDAO extends DAO {
    public void saveMedication(Medication medication) {
            begin();
            getSession().persist(medication);
            commit();
            close();
    }
    
    public List<HealthValues> getMedicationByUsers(User user) {
        Query q = getSession().createQuery("FROM Medication where user = :user ", Medication.class);
        q.setParameter("user", user);
        return q.list();
    }
    
    public void editMedication(Medication medication) {
            begin();
            getSession().update(medication);
            commit();
            close();
    }
    
    public Medication getMedicationId(int id) {
            begin();
            Medication med = getSession().get(Medication.class,id);
            commit();
            close();
            return med;
    }
    
    public void deleteById(Medication med){
        begin();
        getSession().delete(med);
        commit();
        close();
    }
    
    
}
