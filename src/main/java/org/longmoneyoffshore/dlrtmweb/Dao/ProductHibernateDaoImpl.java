package org.longmoneyoffshore.dlrtmweb.Dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class ProductHibernateDaoImpl {

    //@Autowired
    private SessionFactory sessionFactory;


    public int getProductCount() {


        String hql = "SELECT COUNT(*) FROM products";
        Query query = getSessionFactory().openSession().createQuery(hql);

        int count = ((Long) query.uniqueResult()).intValue();

        return count;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
