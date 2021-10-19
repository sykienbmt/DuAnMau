/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DichVuDAO;
import java.util.List;
import panel.ProductPnl;

/**
 *
 * @author Administrator
 */
public class QlDichVuController {
    ProductPnl view;
    DichVuDAO dichVuDAO = new DichVuDAO();
    
    public QlDichVuController(ProductPnl view){
        this.view=view;
        view.setController(this);
    }
    
    public List<Object[]> showDichVu() {
        List<Object[]> dichVus = dichVuDAO.showDichVu();
        return dichVus;
    }
    
    
    
}
