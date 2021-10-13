/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class phieuThuePhong extends AbsTable{
    private Integer idPhieuThue ;
    private java.sql.Timestamp ngayDat ;
    private java.sql.Timestamp ngayDi ;
    private String soCMND;
    private String diaChi;
    private String hoChieu;
    private String soDT;
    private String tenKhach ;
    private String tenNv ;
    private Integer soNguoi ;
    private String hinhThucThue ;

    public phieuThuePhong() {
    }

    public phieuThuePhong(Integer idPhieuThue, Timestamp ngayDat, Timestamp ngayDi, String soCMND, String diaChi, String hoChieu, String soDT, String tenKhach, String tenNv, Integer soNguoi, String hinhThucThue) {
        this.idPhieuThue = idPhieuThue;
        this.ngayDat = ngayDat;
        this.ngayDi = ngayDi;
        this.soCMND = soCMND;
        this.diaChi = diaChi;
        this.hoChieu = hoChieu;
        this.soDT = soDT;
        this.tenKhach = tenKhach;
        this.tenNv = tenNv;
        this.soNguoi = soNguoi;
        this.hinhThucThue = hinhThucThue;
    }

    public Integer getIdPhieuThue() {
        return idPhieuThue;
    }

    public void setIdPhieuThue(Integer idPhieuThue) {
        this.idPhieuThue = idPhieuThue;
    }

    public Timestamp getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Timestamp ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Timestamp getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Timestamp ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoChieu() {
        return hoChieu;
    }

    public void setHoChieu(String hoChieu) {
        this.hoChieu = hoChieu;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public Integer getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(Integer soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getHinhThucThue() {
        return hinhThucThue;
    }

    public void setHinhThucThue(String hinhThucThue) {
        this.hinhThucThue = hinhThucThue;
    }

    @Override
    public int getId() {
        return this.idPhieuThue;
    }
    
    
    

    
    
}
