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
public class BangcapDAL {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    private static String sql = "";
    public List<Bangcap> getListBC(){
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Bangcap.class);
            List resultList = criteria.list();
            session.getTransaction().commit();
            session.close();
            return resultList;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public Bangcap findByName(String name){
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            sql = "FROM bangcap WHERE TenBangCap = :ten";
            Query query = session.createQuery(sql);
            query.setParameter("ten", name);
            Bangcap result = (Bangcap) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            return null;
        }
    }
}
