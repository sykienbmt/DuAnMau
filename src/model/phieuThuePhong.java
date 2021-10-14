package model;

import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class PhieuThuePhong extends AbsTable{
    private Integer idPhieuThue ;
    private Integer idPhong;
    private Integer idNhanVien;
    private String soCMND;
    private Integer soNguoi ;
    private java.sql.Timestamp ngayDat ;
    private java.sql.Timestamp ngayDi ;
    private String hinhThucThue ;

    public PhieuThuePhong() {
    }

    public PhieuThuePhong(Integer idPhieuThue, Integer idPhong, Integer idNhanVien, String soCMND, Integer soNguoi, Timestamp ngayDat, Timestamp ngayDi, String hinhThucThue) {
        this.idPhieuThue = idPhieuThue;
        this.idPhong = idPhong;
        this.idNhanVien = idNhanVien;
        this.soCMND = soCMND;
        this.soNguoi = soNguoi;
        this.ngayDat = ngayDat;
        this.ngayDi = ngayDi;
        this.hinhThucThue = hinhThucThue;
    }

    public Integer getIdPhieuThue() {
        return idPhieuThue;
    }

    public void setIdPhieuThue(Integer idPhieuThue) {
        this.idPhieuThue = idPhieuThue;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public Integer getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(Integer soNguoi) {
        this.soNguoi = soNguoi;
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
