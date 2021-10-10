package DAO;

import connect.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Phong;

public class PhongDAO extends AbsDAO<Phong>{
    public List<Object[]> getDataPhong() {
        return getRawValues("select a.idPhong,b.tenLoaiPhong,a.tenPhong,a.soKhachMax,a.ngayDat,a.trangThai from Phong a join LoaiPhong b on a.idLoaiPhong = b.idLoaiPhong");
    }
    
//    public List<Object[]> getListPhong() {
//        return getRawValues("select * from Phong");
//    }
    
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
