/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import java.util.*;
import entities.*;
import ims.dal.*;
/**
 *
 * @author AnhQuoc
 */
public class PhongbanBLL {
    PhongbanDAL phongbanDAL = new PhongbanDAL();
    public List<Phongban> getListPB(){
        return phongbanDAL.getListPB();
    }
    
    public Phongban findByName(String name){
        return phongbanDAL.findByName(name);
    }
}
