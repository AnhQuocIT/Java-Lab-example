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
    private static Session session;
    public List<Nhanvien> getListNV(){
        try {
            factory.getCurrentSession().beginTransaction();
            List<Nhanvien> list = factory.getCurrentSession().createCriteria(Nhanvien.class).list();
            factory.getCurrentSession().getTransaction().commit();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Nhanvien getOneNV(String maNV){
        try {
            session = factory.openSession();
            session.beginTransaction();
            Nhanvien nhanvien = (Nhanvien) session.load(Nhanvien.class, maNV);
            session.getTransaction().commit();
            session.close();
            return nhanvien;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void deleteOneNV (Nhanvien nv){
        try {
            session = factory.openSession();
            session.beginTransaction();
            Nhanvien nhanvien = (Nhanvien) session.load(Nhanvien.class, nv.getMaNhanVien());
            session.delete(nhanvien);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            factory.getCurrentSession().getTransaction().rollback();
        }
    }
    
    public boolean addNew (Nhanvien nv){
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(nv);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    
    public boolean update (Nhanvien nv){
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(nv);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
