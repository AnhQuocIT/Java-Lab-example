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
public class NhanvienDAL {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    public List<Nhanvien> getListNV(){
        try {
            factory.getCurrentSession().beginTransaction();
            return factory.getCurrentSession().createCriteria(Nhanvien.class).list();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Nhanvien getOneNV(String maNV){
        try {
            factory.getCurrentSession().beginTransaction();
            return (Nhanvien) factory.getCurrentSession().get(Nhanvien.class, maNV);
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean deleteOneNV (Nhanvien nv){
        try {
            factory.getCurrentSession().beginTransaction();
            factory.getCurrentSession().delete(nv);
            factory.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    
    public boolean saveOrUpdate (Nhanvien nv){
        try {
            factory.getCurrentSession().beginTransaction();
            factory.getCurrentSession().saveOrUpdate(nv);
            factory.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
