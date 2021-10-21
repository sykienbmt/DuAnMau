/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.HoaDonDAO;
import model.HoaDon;
import panel.PhongPnl;

/**
 *
 * @author Administrator
 */
public class HoaDonController {
    PhongPnl view ;
    private HoaDonDAO hoaDonDAO=new HoaDonDAO();
    public HoaDonController(PhongPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    
    public void insert(HoaDon hd){
        hoaDonDAO.insert(hd);
    }
}
