/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.NhanvienDAL;

import java.util.*;
import entities.*;
/**
 *
 * @author AnhQuoc
 */
public class NhanvienBLL {
    NhanvienDAL nhanvienDAL = new NhanvienDAL();
    public List<Nhanvien> getListNhanvien (){
        return nhanvienDAL.getListNV();
    }
    
    public Boolean addNewNhanvien(Nhanvien nhanvien){
        return nhanvienDAL.addNew(nhanvien);
    }
    
    public Boolean updateNhanvien (Nhanvien nhanvien){
        return nhanvienDAL.update(nhanvien);
    }
    
    public Boolean deleteNhanvien (Nhanvien nhanvien){
        return nhanvienDAL.deleteOneNV(nhanvien);
    }
}
