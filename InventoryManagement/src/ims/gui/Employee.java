/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.gui;

import ims.bll.*;

import entities.*;
import java.awt.Dimension;
import java.util.*;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author NAT
 */
public class Employee extends javax.swing.JFrame {
    
    private Nhanvien nhanvien;
    private List<Nhanvien> nhanvienList;
    private List<Bangcap> bangcaps;
    private List<Chucvu> chucvus;
    private List<Congviec> congviecs;
    private List<Tinhthanh> tinhthanhs;
    private List<Loainhanvien> loainhanviens;
    private List<Phongban> phongbans;
    private List<Hocvan> hocvans;
    private List<Ngoaingu> ngoaingus;
    private List<Dantoc> dantocs;
    private List<Quoctich> quoctichs;
    private List<Tinhoc> tinhocs;
    private List<Tongiao> tongiaos;
    
    private NhanvienBLL nhanvienBLL;
    String flag = "";
    private EmployeeList emList;
    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
        stateButton(true);
        setInfoDialog();
    }

    public  void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);        
        setResizable(false);
    }
    public void stateButton(boolean value){
        
        btNew.setVisible(!value);
        btEdit.setVisible(!value);
        btDelete.setVisible(!value);
        btPrint.setVisible(!value);
        btClose.setVisible(!value);
        btSave.setVisible(value);
        btCancel.setVisible(value);
        
    }
    
    public void setEditableId(boolean value){
        txtMaso.setEditable(value);
    }
    
    public void setFlag (String flag){
        this.flag = flag;
    }
    
    public void setNhanvien(Nhanvien nhanvien){
        this.nhanvien = nhanvien;
        txtMaso.setText(nhanvien.getMaNhanVien());
        txtHoten.setText(nhanvien.getHoTen());
        txtBidanh.setText(nhanvien.getBiDanh());
        if(nhanvien.getGioiTinh() == true){
            cbNu.setSelected(true);
        }
        if(nhanvien.getHonNhan() == true){
            cbGiadinh.setSelected(true);
        }
        txtDidong.setText(nhanvien.getDiDong());
        txtDTNha.setText(nhanvien.getDienThoaiNha());
        txtEmail.setText(nhanvien.getEmail());
        txtNgaySinh.setText(String.valueOf(nhanvien.getNgaySinh()));
        txtNoiSinh.setText(nhanvien.getNoiSinh());
        cbbTinh.setSelectedItem(nhanvien.getTinhthanh());
        txtCMND.setText(nhanvien.getCmnd());
        txtNgaycapCMND.setText(String.valueOf(nhanvien.getNgayCap()));
        txtNoiCap.setText(nhanvien.getNoiCap());
        txtQuequan.setText(nhanvien.getQueQuan());
        txtDiaChi.setText(nhanvien.getDiaChi());
        txtTamtru.setText(nhanvien.getTamTru());
        
        cbbLoaiNV.setSelectedItem(nhanvien.getLoainhanvien());
        txtNgayVaoLam.setText(String.valueOf(nhanvien.getNgayVaoLam()));
        cbbCongviec.setSelectedItem(nhanvien.getCongviec());
        cbbPhongBan.setSelectedItem(nhanvien.getPhongban());
        cbbChucvu.setSelectedItem(nhanvien.getChucvu());
        txtLuongCB.setText(String.valueOf(nhanvien.getMucLuongCb()));
        txtHeSo.setText(String.valueOf(nhanvien.getHeSoLuong()));
        txtLuong.setText(String.valueOf(nhanvien.getMucLuong()));
        txtPhucap.setText(String.valueOf(nhanvien.getPhuCapLuong()));
        txtSoLD.setText(nhanvien.getSoLaoDong());
        txtNgayCapLD.setText(String.valueOf(nhanvien.getNgayCapLd()));
        txtNoiCapLD.setText(nhanvien.getNoiCapLd());
        txtTKNH.setText(nhanvien.getTknganHang());
        txtNganHang.setText(nhanvien.getNganHang());
        cbbHocvan.setSelectedItem(nhanvien.getHocvan());
        cbbBangCap.setSelectedItem(nhanvien.getBangcap());
        cbbNgoaiNgu.setSelectedItem(nhanvien.getNgoaingu());
        
        cbbTinhoc.setSelectedItem(nhanvien.getTinhoc());
        
        cbbDantoc.setSelectedItem(nhanvien.getDantoc());
        cbbQuoctich.setSelectedItem(nhanvien.getQuoctich());
        cbbTongiao.setSelectedItem(nhanvien.getTongiao());
    }
    
    public Nhanvien getNhanvien(){
        return nhanvien;
    }
    
    public void setListBangcap(List<Bangcap> bangcaps){
        this.bangcaps = bangcaps;
        loadComboBox(cbbBangCap, bangcaps);
    }
    
    public void setListChucvu (List<Chucvu> chucvus){
        this.chucvus = chucvus;
        loadComboBox(cbbChucvu, chucvus);
    }
    
    public void setListCongviec (List<Congviec> congviecs){
        this.congviecs = congviecs;
        loadComboBox(cbbCongviec, congviecs);
    }
    
    public void setListDantoc (List<Dantoc> dantocs){
        this.dantocs = dantocs;
        loadComboBox(cbbDantoc, dantocs);
    }
    
    public void setListHocvan (List<Hocvan> hocvans){
        this.hocvans = hocvans;
        loadComboBox(cbbHocvan, hocvans);
    }
    
    public void setListLoaiNV (List<Loainhanvien> loainhanviens){
        this.loainhanviens = loainhanviens;
        loadComboBox(cbbLoaiNV, loainhanviens);
    }
    
    public void setListNgoaingu (List<Ngoaingu> ngoaingus){
        this.ngoaingus = ngoaingus;
        loadComboBox(cbbNgoaiNgu, ngoaingus);
    }
    
    public void setListPhongban (List<Phongban> phongbans){
        this.phongbans = phongbans;
        loadComboBox(cbbPhongBan, phongbans);
    }
    
    public void setListQuoctich(List<Quoctich> quoctichs){
        this.quoctichs = quoctichs;
        loadComboBox(cbbQuoctich, quoctichs);
    }
    
    public void setListTinhoc (List<Tinhoc> tinhocs){
        this.tinhocs = tinhocs;
        loadComboBox(cbbTinhoc, tinhocs);
    }
    
    public void setListTinhthanh(List<Tinhthanh> tinhthanhs){
        this.tinhthanhs = tinhthanhs;
        loadComboBox(cbbTinh, tinhthanhs);
    }
    
    public void setListTongiao(List<Tongiao> tongiaos){
        this.tongiaos = tongiaos;
        loadComboBox(cbbTongiao, tongiaos);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNew = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        employeePanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTitle1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBidanh = new javax.swing.JTextField();
        cbNu = new javax.swing.JCheckBox();
        cbGiadinh = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDidong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDTNha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNoiSinh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbbTinh = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNgaycapCMND = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNoiCap = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtQuequan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTamtru = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbbLoaiNV = new javax.swing.JComboBox<>();
        txtLuongCB = new javax.swing.JTextField();
        txtSoLD = new javax.swing.JTextField();
        cbbCongviec = new javax.swing.JComboBox<>();
        txtTKNH = new javax.swing.JTextField();
        cbbHocvan = new javax.swing.JComboBox<>();
        cbbNgoaiNgu = new javax.swing.JComboBox<>();
        cbbDantoc = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtNgayVaoLam = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtHeSo = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtNgayCapLD = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        cbbQuoctich = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbbPhongBan = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cbbChucvu = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtPhucap = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtNoiCapLD = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtNganHang = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        cbbBangCap = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        cbbTinhoc = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        cbbTongiao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btNew.setText("Thêm");
        btNew.setPreferredSize(new java.awt.Dimension(75, 23));
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btEdit.setText("Sửa");
        btEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("Xóa");
        btDelete.setPreferredSize(new java.awt.Dimension(75, 23));

        btPrint.setText("In");
        btPrint.setPreferredSize(new java.awt.Dimension(75, 23));

        btClose.setText("Thoát");
        btClose.setPreferredSize(new java.awt.Dimension(75, 23));
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        btSave.setText("Ghi");
        btSave.setPreferredSize(new java.awt.Dimension(75, 23));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setText("Hủy");
        btCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        employeePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle1.setText("Thông Tin Cá Nhân");

        jLabel2.setText("Mã nhân viên");

        jLabel1.setText("Họ Tên");

        jLabel3.setText("Bí danh");

        cbNu.setText("Nữ");

        cbGiadinh.setText("Có gia đình");
        cbGiadinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGiadinhActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("(*)");

        jLabel5.setText("Di động");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("(*)");

        jLabel7.setText("Điện thoại nhà");

        jLabel8.setText("Địa chỉ email");

        jLabel9.setText("Ngày sinh");

        jLabel10.setText("Nơi sinh");

        jLabel11.setText("Tỉnh thành");

        jLabel12.setText("CMND");

        jLabel13.setText("Ngày cấp");

        jLabel14.setText("Nơi cấp");

        jLabel15.setText("Quê quán");

        jLabel16.setText("Địa chỉ");

        jLabel17.setText("Tạm trú");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Thông Tin Công Việc");

        jLabel19.setText("Loại nhân viên");

        jLabel20.setText("Công việc");

        jLabel21.setText("Mức lương CB");

        jLabel22.setText("Số sổ lao động");

        jLabel23.setText("TK.Ngân hàng");

        jLabel24.setText("Ngoại ngữ");

        jLabel25.setText("Học vấn");

        jLabel26.setText("Dân tộc");

        jLabel27.setText("Ngày vào làm");

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("(*)");

        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("(*)");

        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("(*)");

        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("(*)");

        jLabel32.setText("Hệ số");

        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("(*)");

        jLabel34.setText("Ngày cấp");

        jLabel35.setText("Quốc tịch");

        jLabel36.setText("Phòng ban");

        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setText("(*)");

        jLabel38.setText("Chức vụ");

        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("(*)");

        jLabel40.setText("Mức lương");

        jLabel41.setText("Phụ cấp lương");

        jLabel42.setText("Nơi cấp");

        jLabel43.setText("Ngân hàng");

        jLabel44.setText("Bằng cấp");

        jLabel45.setText("Tin học");

        jLabel46.setText("Tôn giáo");

        javax.swing.GroupLayout employeePanelLayout = new javax.swing.GroupLayout(employeePanel);
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29))
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30))
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle1)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, employeePanelLayout.createSequentialGroup()
                                                .addComponent(cbbLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel31))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, employeePanelLayout.createSequentialGroup()
                                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtSoLD, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtLuongCB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel32)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel33))
                                                    .addComponent(jLabel34))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHeSo)
                                            .addComponent(txtNgayCapLD, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                                    .addComponent(cbbCongviec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTKNH)
                                    .addComponent(cbbHocvan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbNgoaiNgu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addComponent(cbbDantoc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbQuoctich, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel37))
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39))
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPhucap, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                    .addComponent(cbbPhongBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbChucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNoiCapLD)
                                    .addComponent(txtNganHang)
                                    .addComponent(cbbBangCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbTinhoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbTongiao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtNgaySinh)
                                    .addComponent(txtDidong)
                                    .addComponent(txtMaso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addGap(15, 15, 15)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoten)
                                    .addComponent(txtDTNha)
                                    .addComponent(txtNoiSinh)
                                    .addComponent(txtNgaycapCMND))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(employeePanelLayout.createSequentialGroup()
                                        .addComponent(txtBidanh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbNu)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbGiadinh))
                                    .addComponent(txtEmail)
                                    .addComponent(cbbTinh, 0, 335, Short.MAX_VALUE)
                                    .addComponent(txtNoiCap)))
                            .addComponent(txtTamtru)
                            .addComponent(txtDiaChi)
                            .addComponent(txtQuequan))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtMaso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBidanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbNu)
                        .addComponent(cbGiadinh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDidong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtDTNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(txtNgaycapCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNoiCap)
                        .addComponent(jLabel14))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQuequan)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTamtru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbbLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31)
                    .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(cbbPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbbCongviec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(cbbChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLuongCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel30)
                        .addComponent(jLabel32)
                        .addComponent(jLabel33)
                        .addComponent(txtHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41)
                        .addComponent(txtPhucap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtSoLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtNgayCapLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(txtNoiCapLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTKNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txtNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbbHocvan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(cbbBangCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbbNgoaiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(cbbTinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cbbDantoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(cbbQuoctich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(cbbTongiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(employeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(employeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected boolean validateInput(){
        String maNV = txtMaso.getText();
        String hoTen = txtHoten.getText();
        String biDanh = txtBidanh.getText();
        Boolean gtNu = false;
        if(cbNu.isSelected()){
            gtNu = true;
        }
        Boolean honNhan = false;
        if(cbGiadinh.isSelected()){
            honNhan = true;
        }
        String diDong = txtDidong.getText();
        String dtNha = txtDTNha.getText();
        String email = txtEmail.getText();
        String ngaySinh = txtNgaySinh.getText();
        String noiSinh = txtNoiSinh.getText();
        Tinhthanh tinhThanh = (Tinhthanh) cbbTinh.getSelectedItem();
        String maTinhThanh = tinhThanh.getMaTinhThanh();
        String CMND = txtCMND.getText();
        String ngayCapCMND = txtNgaycapCMND.getText();
        String noiCapCMND = txtNoiCap.getText();
        String queQuan = txtQuequan.getText();
        String diaChi = txtDiaChi.getText();
        String tamTru = txtTamtru.getText();
        Loainhanvien loaiNV = (Loainhanvien) cbbLoaiNV.getSelectedItem();
        String maLoaiNV = loaiNV.getMaLoaiNv();
        String ngayVaoLam = txtNgayVaoLam.getText();
        Phongban phongBan = (Phongban) cbbPhongBan.getSelectedItem();
        String maPhongBan = phongBan.getMaPhongBan();
        Congviec congViec = (Congviec) cbbCongviec.getSelectedItem();
        String maCongviec = congViec.getMaCongViec();
        Chucvu chucVu = (Chucvu) cbbChucvu.getSelectedItem();
        String maChucVu = chucVu.getMaChucVu();
        String luongCB = txtLuongCB.getText();
        String heSo = txtHeSo.getText();
        String luong = txtLuong.getText();
        String phuCap = txtPhucap.getText();
        String soLD = txtSoLD.getText();
        String ngayCapLD = txtNgayCapLD.getText();
        String noiCapLD = txtNoiCapLD.getText();
        String tkNganHang = txtTKNH.getText();
        String nganHang = txtNganHang.getText();
        Hocvan hocVan = (Hocvan) cbbHocvan.getSelectedItem();
        String maHocVan = hocVan.getMaHocVan();
        Bangcap bangCap = (Bangcap) cbbBangCap.getSelectedItem();
        String maBangCap = bangCap.getMaBangCap();
        Ngoaingu ngoaiNgu = (Ngoaingu) cbbNgoaiNgu.getSelectedItem();
        String maNgoaiNgu = ngoaiNgu.getMaNgoaiNgu();
        Tinhoc tinHoc = (Tinhoc) cbbTinhoc.getSelectedItem();
        String maTinHoc = tinHoc.getMaTinHoc();
        Dantoc danToc = (Dantoc) cbbDantoc.getSelectedItem();
        String maDanToc = danToc.getMaDanToc();
        Quoctich quocTich = (Quoctich) cbbQuoctich.getSelectedItem();
        String maQuocTich = quocTich.getMaQuocTich();
        Tongiao tonGiao = (Tongiao) cbbTongiao.getSelectedItem();
        String maTonGiao = tonGiao.getMaTonGiao();
        Date NS = null;
        Date NCCMND = null;
        Date NVL = null;
        Date NCLD = null;
        long LCB = Long.parseLong(luongCB);
        float HS = Float.parseFloat(heSo);
        long Lg = (long) (LCB * HS);
        long PC = Long.parseLong(phuCap);
        
        if (maNV.equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập mã nhân viên!");
            txtMaso.requestFocus();
            return false;
        } else if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập tên nhân viên!");
            txtHoten.requestFocus();
            return false;			

        } else if (loaiNV == null) {
            JOptionPane.showMessageDialog(this, "Loại nhân viên không được bỏ trống!");
            return false;
        } else if (ngayVaoLam.equals("")){
            JOptionPane.showMessageDialog(this, "Nhập ngày vào làm!");
            txtNgayVaoLam.requestFocus();
            return false;
        } else if (phongBan == null){
            JOptionPane.showMessageDialog(this, "Phòng ban không được bỏ trống!");
            return false;
        } else if (congViec == null){
            JOptionPane.showMessageDialog(this, "Công việc không được bỏ trống!");
            return false;
        } else if (chucVu == null){
            JOptionPane.showMessageDialog(this, "Chức vụ không được bỏ trống!");
            return false;
        } else if (luongCB.equals("")){
            JOptionPane.showMessageDialog(this, "Nhập mức lương cơ bản!");
            txtLuongCB.requestFocus();
            return false;
        } else if (heSo.equals("")){
            JOptionPane.showMessageDialog(this, "Nhập hệ số lương!");
            txtHeSo.requestFocus();
            return false;
        }
        try {
            NS = new SimpleDateFormat("yyyy-mm-dd").parse(ngaySinh);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Chưa đúng định dạng ngày (yyyy-MM-dd)!");
            txtNgaySinh.requestFocus();
            return false;
        }
        try {
            NCCMND = new SimpleDateFormat("yyyy-mm-dd").parse(ngayCapCMND);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Chưa đúng định dạng ngày (yyyy-MM-dd)!");
            txtNgaycapCMND.requestFocus();
            return false;
        }
        try {
            NVL = new SimpleDateFormat("yyyy-mm-dd").parse(ngayVaoLam);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Chưa đúng định dạng ngày (yyyy-MM-dd)!");
            txtNgayVaoLam.requestFocus();
            return false;
        }
        try {
            NCLD = new SimpleDateFormat("yyyy-mm-dd").parse(ngayCapLD);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Chưa đúng định dạng ngày (yyyy-MM-dd)!");
            txtNgayCapLD.requestFocus();
            return false;
        }			
        

        if (nhanvien == null) {		
                nhanvien = new Nhanvien();
        }
        
        nhanvien.setHoTen(hoTen);
        nhanvien.setBiDanh(biDanh);
        nhanvien.setGioiTinh(gtNu);
        nhanvien.setHonNhan(honNhan);
        nhanvien.setDiDong(diDong);
        nhanvien.setDienThoaiNha(dtNha);
        nhanvien.setEmail(email);
        nhanvien.setNgaySinh(NS);
        nhanvien.setNoiSinh(noiSinh);
        nhanvien.setTinhthanh(tinhThanh);
        nhanvien.setCmnd(CMND);
        nhanvien.setNgayCap(NCCMND);
        nhanvien.setNoiCap(noiCapCMND);
        nhanvien.setQueQuan(queQuan);
        nhanvien.setDiaChi(diaChi);
        nhanvien.setTamTru(tamTru);
        nhanvien.setLoainhanvien(loaiNV);
        nhanvien.setNgayVaoLam(NVL);
        nhanvien.setPhongban(phongBan);
        nhanvien.setCongviec(congViec);
        nhanvien.setChucvu(chucVu);
        nhanvien.setMucLuongCb(LCB);
        nhanvien.setMucLuong(Lg);
        nhanvien.setHeSoLuong(HS);
        nhanvien.setPhuCapLuong(PC);
        nhanvien.setSoLaoDong(soLD);
        nhanvien.setNgayCapLd(NCLD);
        nhanvien.setNoiCapLd(noiCapLD);
        nhanvien.setTknganHang(tkNganHang);
        nhanvien.setNganHang(nganHang);
        nhanvien.setHocvan(hocVan);
        nhanvien.setBangcap(bangCap);
        nhanvien.setNgoaingu(ngoaiNgu);
        nhanvien.setTinhoc(tinHoc);
        nhanvien.setDantoc(danToc);
        nhanvien.setQuoctich(quocTich);
        nhanvien.setTongiao(tonGiao);
        return true;    
    }
    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        stateButton(true);
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        
        if(validateInput()){
            if(flag.equals("Add")){
                nhanvien.setMaNhanVien(txtMaso.getText());
                emList = new EmployeeList();
                emList.addNhanvien(nhanvien);
            } else if(flag.equals("Edit")){
                emList = new EmployeeList();
                emList.editNhanvien(nhanvien);
            }
            dispose();
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        stateButton(true);
    }//GEN-LAST:event_btEditActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
         // TODO add your handling code here:
         this.dispose();
         new EmployeeList().setVisible(true);
    }//GEN-LAST:event_btCancelActionPerformed

    private void cbGiadinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGiadinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGiadinhActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        
    }//GEN-LAST:event_btCloseActionPerformed

    public void loadComboBox(JComboBox comboBox, List<?> listData){
        Vector items = new Vector();
        for(int i = 0; i< listData.size(); i++){
            Object object = listData.get(i);
            items.addElement(object);
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        comboBox.setModel(model);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btSave;
    private javax.swing.JCheckBox cbGiadinh;
    private javax.swing.JCheckBox cbNu;
    private javax.swing.JComboBox<String> cbbBangCap;
    private javax.swing.JComboBox<String> cbbChucvu;
    private javax.swing.JComboBox<String> cbbCongviec;
    private javax.swing.JComboBox<String> cbbDantoc;
    private javax.swing.JComboBox<String> cbbHocvan;
    private javax.swing.JComboBox<String> cbbLoaiNV;
    private javax.swing.JComboBox<String> cbbNgoaiNgu;
    private javax.swing.JComboBox<String> cbbPhongBan;
    private javax.swing.JComboBox<String> cbbQuoctich;
    private javax.swing.JComboBox<String> cbbTinh;
    private javax.swing.JComboBox<String> cbbTinhoc;
    private javax.swing.JComboBox<String> cbbTongiao;
    private javax.swing.JPanel employeePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JTextField txtBidanh;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDTNha;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDidong;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHeSo;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtLuongCB;
    private javax.swing.JTextField txtMaso;
    private javax.swing.JTextField txtNganHang;
    private javax.swing.JTextField txtNgayCapLD;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JTextField txtNgaycapCMND;
    private javax.swing.JTextField txtNoiCap;
    private javax.swing.JTextField txtNoiCapLD;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtPhucap;
    private javax.swing.JTextField txtQuequan;
    private javax.swing.JTextField txtSoLD;
    private javax.swing.JTextField txtTKNH;
    private javax.swing.JTextField txtTamtru;
    // End of variables declaration//GEN-END:variables
}
