package com.me.DAO;

import static com.me.DAO.DAO.getSession;
import com.me.pojo.FilePdf;
import com.me.pojo.HealthValues;
import com.me.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class FilePdfDAO extends DAO {
    public void saveBook(FilePdf filePdf) {
            begin();
            getSession().persist(filePdf);
            commit();
    }
    
    public List<FilePdf> getFilesByUsers(User user) {
        Query q = getSession().createQuery("From FilePdf where user = :user ", FilePdf.class);
        q.setParameter("user", user);
        return q.list();
    }
    
    public FilePdf getFileById(int id){
        FilePdf file= getSession().get( FilePdf.class,id);
        return file;
    }
    
}
