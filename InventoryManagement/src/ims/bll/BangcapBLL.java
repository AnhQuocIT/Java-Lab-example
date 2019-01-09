/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;


import java.util.*;
import entities.*;
import ims.dal.BangcapDAL;

/**
 *
 * @author AnhQuoc
 */
public class BangcapBLL {
    BangcapDAL bangcapDAL = new BangcapDAL();
    public List<Bangcap> getListBC(){
        return bangcapDAL.getListBC();
    }
}
