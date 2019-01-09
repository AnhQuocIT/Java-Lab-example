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
public class TinhthanhDAL {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public List<Tinhthanh> getListTT(){
        try {
            factory.getCurrentSession().beginTransaction();
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Tinhthanh.class);
            List resultList = criteria.list();
            factory.getCurrentSession().getTransaction().commit();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }
}
