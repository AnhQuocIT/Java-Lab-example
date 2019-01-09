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
public class NgoainguBLL {
    NgoainguDAL ngoainguDAL = new NgoainguDAL();
    public List<Ngoaingu> getListNN(){
        return ngoainguDAL.getListNN();
    }
    
    public Ngoaingu findByName(String name){
        return ngoainguDAL.findByName(name);
    }
}
