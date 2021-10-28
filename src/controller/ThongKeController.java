/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ThongKeDAO;
import helper.ChuyenDoi;
import java.text.SimpleDateFormat;
import java.util.List;
import panel.ThongKePnl;

/**
 *
 * @author Administrator
 */
public class ThongKeController {
    ThongKePnl view ;
    ThongKeDAO thongKeDAO= new ThongKeDAO();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    
    public ThongKeController(ThongKePnl view) {
        this.view = view;
        view.setController(this);
    }
    
    public List<Object[]> thongKeTheoKhoang(String tu , String den){
        List<Object[]> khoang = thongKeDAO.thongKeTheoKhoang(tu, den); 
        return khoang;
    }
    
    public List<Object[]> thongKeDefault(String tu , String den){
        List<Object[]> khoang = thongKeDAO.thongKeDefault(tu, den); 
        return khoang;
    }
       
    public List<Object[]> thongKeBieuDo(String tu, String den) {
        List<Object[]> bieuDos = thongKeDAO.thongKeBieuDo(tu, den);
        Double tienPhong = 0.0,tienDichVu=0.0 ,phuThu=0.0 ,Tong=0.0;
        
        for(int i=0 ;i<=bieuDos.size()-1;i++){
            tienPhong+=ChuyenDoi.SoDouble(bieuDos.get(i)[1].toString());
            tienDichVu+=ChuyenDoi.SoDouble(bieuDos.get(i)[2].toString());
            phuThu+=ChuyenDoi.SoDouble(bieuDos.get(i)[3].toString());
        }
        return bieuDos;
    }
}
