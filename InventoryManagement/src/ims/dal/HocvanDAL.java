/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import java.util.*;
import entities.*;
import org.hibernate.*;
/**
 *
 * @author AnhQuoc
 */
public class HocvanDAL {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public List<Hocvan> getListHV(){
        try {
            factory.getCurrentSession().beginTransaction();
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Hocvan.class);
            List resultList = criteria.list();
            factory.getCurrentSession().getTransaction().commit();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Hocvan findByName(String name){
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            String sql = "FROM hocvan WHERE TenHocVan = :ten";
            Query query = session.createQuery(sql);
            query.setParameter("ten", name);
            Hocvan result = (Hocvan) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            return null;
        }
    }
}
