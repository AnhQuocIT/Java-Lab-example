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
}
