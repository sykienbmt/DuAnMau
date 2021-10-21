package DAO;

import model.NhanVien;
import java.util.List;

public class NhanVienDAO extends AbsDAO<NhanVien>{
    public List<Object[]> getDataStaff() {
        return getRawValues("select idNhanVien,ten,email,sdt,sex,CAST(Luong as decimal(15,0)) as luong,b.tenChucVu,diaChi,CONVERT(nvarchar,NgaySinh,105) as ngaySinh,\n" +
                            "CONVERT(nvarchar,NgayVaoLam,105)as ngayVaoLam,trangThai from NhanVien a join ChucVu b on a.idChucVu = b.idChucVu ");
    }
    
    public List<Object[]> searchNhanVien(String tenNhanVien) {
        return getRawValues("select idNhanVien,ten,email,sdt,sex,luong,tenChucVu,diaChi,ngaySinh,ngayVaoLam,trangThai from NhanVien a "
                            + "join ChucVu b on a.idChucVu = b.idChucVu where ten like N'%"+tenNhanVien+"%'");
    }
    
    public List<Object[]> searchLuongNhanVien(int luongNhanVien) {
        return getRawValues("select idNhanVien,ten,email,sdt,sex,luong,tenChucVu,diaChi,ngaySinh,ngayVaoLam,trangThai from NhanVien a "
                            + "join ChucVu b on a.idChucVu = b.idChucVu where luong <= "+luongNhanVien+"");
    }
    
//    public List<Object[]> updateDataStaff() {
//        return getRawValues("update NhanVien set TenNhanVien=?,DiaChi=?,SoDienThoai=?,GioiTinh=?,ChucVu=?,NgaySinh=?,"
//                            + "NgayVaoLam=?,Luong=?,HinhAnh=?,Email where MaNhanVien=?");
//    }
//    
//    public List<Object[]> deleteStaff() {
//        return getRawValues("delete from NhanVien where MaNhanVien = ?");
//    }
//    
//    public List<Object[]> searchByName(String name){
//        String query = "%" + name + "%";
//        return getRawValues("select MaNhanVien,TenNhanVien,DiaChi,SoDienThoai,GioiTinh,b.TenChucVu, CONVERT(nvarchar,NgaySinh,105) as ngaySinh,"
//                + "CONVERT(nvarchar,NgayVaoLam,105)as ngayVaoLam, CAST(Luong as decimal(15,0)),HinhAnh, Email from NhanVien a join ChucVu b "
//                + "on a.ChucVu = b.IDChucVu where TenNhanVien like ?",query);
//    }
}
