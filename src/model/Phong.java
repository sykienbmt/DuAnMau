package model;

import java.sql.Date;

public class Phong extends AbsTable{
    private Integer idPhong;
    private Integer idLoaiPhong;
    private String tenPhong;
    private String soKhachMax;
    private java.sql.Date ngayDat;
    private String trangThai;

    public Phong() {
    }

    public Phong(Integer idPhong, Integer idLoaiPhong, String tenPhong, String soKhachMax, Date ngayDat, String trangThai) {
        this.idPhong = idPhong;
        this.idLoaiPhong = idLoaiPhong;
        this.tenPhong = tenPhong;
        this.soKhachMax = soKhachMax;
        this.ngayDat = ngayDat;
        this.trangThai = trangThai;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public Integer getIdLoaiPhong() {
        return idLoaiPhong;
    }

    public void setIdLoaiPhong(Integer idLoaiPhong) {
        this.idLoaiPhong = idLoaiPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getSoKhachMax() {
        return soKhachMax;
    }

    public void setSoKhachMax(String soKhachMax) {
        this.soKhachMax = soKhachMax;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    
    @Override
    public int getId() {
        return idPhong;
    }
    
    @Override
    public String toString() {
        return tenPhong;
    }
}
