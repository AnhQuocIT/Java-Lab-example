package entities;
// Generated Jan 9, 2019 4:59:26 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tongiao generated by hbm2java
 */
public class Tongiao  implements java.io.Serializable {


     private String maTonGiao;
     private String tenTonGiao;
     private Set nhanviens = new HashSet(0);

    public Tongiao() {
    }

	
    public Tongiao(String maTonGiao, String tenTonGiao) {
        this.maTonGiao = maTonGiao;
        this.tenTonGiao = tenTonGiao;
    }
    public Tongiao(String maTonGiao, String tenTonGiao, Set nhanviens) {
       this.maTonGiao = maTonGiao;
       this.tenTonGiao = tenTonGiao;
       this.nhanviens = nhanviens;
    }
   
    public String getMaTonGiao() {
        return this.maTonGiao;
    }
    
    public void setMaTonGiao(String maTonGiao) {
        this.maTonGiao = maTonGiao;
    }
    public String getTenTonGiao() {
        return this.tenTonGiao;
    }
    
    public void setTenTonGiao(String tenTonGiao) {
        this.tenTonGiao = tenTonGiao;
    }
    public Set getNhanviens() {
        return this.nhanviens;
    }
    
    public void setNhanviens(Set nhanviens) {
        this.nhanviens = nhanviens;
    }

    @Override
    public String toString() {
        return tenTonGiao; //To change body of generated methods, choose Tools | Templates.
    }


}


