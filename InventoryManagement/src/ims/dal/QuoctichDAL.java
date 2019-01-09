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
public class QuoctichDAL {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public List<Quoctich> getListQT(){
        try {
            factory.getCurrentSession().beginTransaction();
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Quoctich.class);
            List resultList = criteria.list();
            factory.getCurrentSession().getTransaction().commit();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Quoctich findByName(String name){
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            String sql = "FROM quoctich WHERE TenQuocTich = :ten";
            Query query = session.createQuery(sql);
            query.setParameter("ten", name);
            Quoctich result = (Quoctich) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            return null;
        }
    }
}
