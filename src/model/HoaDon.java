/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class HoaDon extends AbsTable{
    private Integer idHoaDon ;
    private Integer idPhieuThue ;
    private Integer idHoaDonDichVu ;
    private Double tienGio ;
    private Double tienDichVu ;

    public HoaDon() {
    }

    public HoaDon(Integer idHoaDon, Integer idPhieuThue, Integer idHoaDonDichVu, Double tienGio, Double tienDichVu) {
        this.idHoaDon = idHoaDon;
        this.idPhieuThue = idPhieuThue;
        this.idHoaDonDichVu = idHoaDonDichVu;
        this.tienGio = tienGio;
        this.tienDichVu = tienDichVu;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdPhieuThue() {
        return idPhieuThue;
    }

    public void setIdPhieuThue(Integer idPhieuThue) {
        this.idPhieuThue = idPhieuThue;
    }

    public Integer getIdHoaDonDichVu() {
        return idHoaDonDichVu;
    }

    public void setIdHoaDonDichVu(Integer idHoaDonDichVu) {
        this.idHoaDonDichVu = idHoaDonDichVu;
    }

    public Double getTienGio() {
        return tienGio;
    }

    public void setTienGio(Double tienGio) {
        this.tienGio = tienGio;
    }

    public Double getTienDichVu() {
        return tienDichVu;
    }

    public void setTienDichVu(Double tienDichVu) {
        this.tienDichVu = tienDichVu;
    }

    @Override
    public int getId() {
        return idHoaDon;
    }
    
    
    
}
