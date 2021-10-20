package controller;

import DAO.PhieuThuePhongDAO;
import model.PhieuThuePhong;
import panel.PhongPnl;

/**
 *
 * @author tuanl
 */
public class PhieuThuePhongController {
    PhongPnl view;
    PhieuThuePhongDAO ptpDAO = new PhieuThuePhongDAO();
    
    public PhieuThuePhongController(PhongPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    public void insert(int idPhieuThue, int idPhong, int idNhanVien, String soCMND, int soNguoi, java.sql.Timestamp ngayDat, java.sql.Timestamp ngayDi, String hinhThucThue) {
        PhieuThuePhong ptp = new PhieuThuePhong(idPhieuThue, idPhong, idNhanVien, soCMND, soNguoi, ngayDat, ngayDi, hinhThucThue);
        ptpDAO.insert(ptp);
    }
    
    
    
}
