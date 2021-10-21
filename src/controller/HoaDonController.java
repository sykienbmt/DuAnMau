/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.HoaDonDAO;
import model.HoaDon;

/**
 *
 * @author Administrator
 */
public class HoaDonController {
    
    private HoaDonDAO hoaDonDAO;
    
    public void insert(Integer idHoaDon , Integer idPhieuThue , Integer idHoaDonDichVu , Double tienPhong , Double tienDichVu){
        HoaDon hd = new HoaDon(idHoaDon,idPhieuThue,idHoaDonDichVu,tienPhong,tienDichVu);
        hoaDonDAO.insert(hd);
    }
}
