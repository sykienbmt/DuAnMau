package controller;

import DAO.KhachHangDAO;
import java.util.List;
import model.KhachHang;
import panel.PhongPnl;

/**
 *
 * @author tuanl
 */
public class KhacHangController {
    PhongPnl view;
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    
    public KhacHangController(PhongPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    public void insert(int idKhachHang,String CMND, String tenKhach, String diaChi, String hoChieu, String SDT) {
        KhachHang khachHang = new KhachHang(0,CMND, tenKhach, diaChi, hoChieu, SDT);
        khachHangDAO.insert(khachHang);
    }
    
    public List<Object[]> getCMND(String CMND) {
        List<Object[]> lists = khachHangDAO.getCMND(CMND);
        return lists;
    }
}
