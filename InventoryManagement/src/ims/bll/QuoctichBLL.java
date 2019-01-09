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
public class QuoctichBLL {
    QuoctichDAL quoctichDAL = new QuoctichDAL();
    public List<Quoctich> getListQT(){
        return quoctichDAL.getListQT();
    }
    
    public Quoctich findByName(String name){
        return quoctichDAL.findByName(name);
    }
}
