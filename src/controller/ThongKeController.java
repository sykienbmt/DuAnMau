/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ThongKeDAO;
import helper.ChuyenDoi;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//        loadListBtnPhong();
//        getListAllLoaiPhong();
        loadTableThongKe();
        view.setController(this);
    }
    
    
    public void loadTableThongKe(){
        Date now = new Date();
        List<Object[]> homNay =thongKeDAO.thongKeTheoKhoang(sdf.format(now), sdf.format(now));
        view.viewTableThongKe(homNay);
    }
    
    public void thongKeTheoKhoang(String tu , String den){
        List<Object[]> khoang = thongKeDAO.thongKeTheoKhoang(tu, den);
        Double tienPhong = 0.0,tienDichVu=0.0 ,phuThu=0.0 ,Tong=0.0;
        
        for(int i=0 ;i<=khoang.size()-1;i++){
            tienPhong+=ChuyenDoi.SoDouble(khoang.get(i)[4].toString());
            tienDichVu+=ChuyenDoi.SoDouble(khoang.get(i)[5].toString());
            phuThu+=ChuyenDoi.SoDouble(khoang.get(i)[6].toString());
            Tong+=ChuyenDoi.SoDouble(khoang.get(i)[7].toString());
        }
        
        view.viewTableThongKe(khoang);
        view.setValueSum(tienPhong,tienDichVu,phuThu,Tong);
    }
}
