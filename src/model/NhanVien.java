package model;

import java.sql.Date;

public class NhanVien extends AbsTable{
    private Integer idNhanVien;
    private String ten;
    private String email;
    private String sdt;
    private String sex;
    private Double luong;
    private Integer idChucVu;
    private String diaChi;
    private java.sql.Date ngaySinh;
    private java.sql.Date ngayVaoLam;
    private String trangThai;
    private byte[] hinhAnh;
    private String pass ;
    private String code ;

    public NhanVien() {
    }

    public NhanVien(Integer idNhanVien, String ten, String email, String sdt, String sex, Double luong, Integer idChucVu, String diaChi, Date ngaySinh, Date ngayVaoLam, String trangThai, byte[] hinhAnh, String pass, String code) {
        this.idNhanVien = idNhanVien;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.sex = sex;
        this.luong = luong;
        this.idChucVu = idChucVu;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
        this.pass = pass;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    

    @Override
    public int getId() {
        return idNhanVien;
    }
}
