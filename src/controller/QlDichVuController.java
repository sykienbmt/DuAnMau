/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DanhMucDAO;
import DAO.DichVuDAO;
import DAO.DonViTinhDAO;
import java.util.List;
import model.DanhMuc;
import model.DichVu;
import model.DonViTinh;
import panel.ProductPnl;

/**
 *
 * @author Administrator
 */
public class QlDichVuController {
    ProductPnl view;
    DichVuDAO dichVuDAO = new DichVuDAO();
    DonViTinhDAO donViTinhDAO = new DonViTinhDAO();
    DanhMucDAO danhMucDAO = new DanhMucDAO();
    
    public QlDichVuController(ProductPnl view){
        this.view=view;
        loadDichVu();
        view.setController(this);
        view.setCbbDonViTinh();
        view.setCbbDanhMuc();
    }
    
    public void loadDichVu() {
        List<Object[]> dichVus = dichVuDAO.getDataDichVu();
        List<DichVu> dichVuss = dichVuDAO.getAll();
        view.viewDichVu(dichVus,dichVuss);
    }
    
    public DichVu getDichVu(int idDichVu){
        DichVu dv = dichVuDAO.getById(idDichVu);
        return dv;
    }
    
    public void insert(DichVu dv){
        dichVuDAO.insert(dv);
    }
    
    public void edit(DichVu dv){
        dichVuDAO.edit(dv);
    }
    
    public List<DonViTinh> getDonViTinh(){
        List<DonViTinh> chucVus = donViTinhDAO.getAll();
        return chucVus;
    }
    
    public List<DanhMuc> getDanhMuc(){
        List<DanhMuc> danhMucs = danhMucDAO.getAll();
        return danhMucs;
    }
    
    public void delele(int idDichVu){
        dichVuDAO.deleteOne(idDichVu);
    }
}
