package DAO;

import helper.DBConnection;
import java.util.List;
import model.Phong;

public class PhongDAO extends AbsDAO<Phong>{      
    public List<Object[]> getListAllLoaiPhong() {
        return getRawValues("select idPhong,a.idLoaiPhong,tenPhong,soKhachMax,ngayDat,trangThai,tenLoaiPhong from Phong a join LoaiPhong b "
                            + "on a.idLoaiPhong = b.idLoaiPhong");
    }
    
    public List<Object[]> getListLoaiPhong(int idLoaiPhong) {
        return getRawValues("select idPhong,a.idLoaiPhong,tenPhong,soKhachMax,ngayDat,trangThai,tenLoaiPhong from Phong a join LoaiPhong b "
                            + "on a.idLoaiPhong = b.idLoaiPhong where b.idLoaiPhong = N'"+idLoaiPhong+"'");
    }
    
    public List<Object[]> getPhongDangDung() {
        return getRawValues("select idPhong,tenPhong,a.idLoaiPhong,tenLoaiPhong from Phong a join LoaiPhong b "
                            + "on a.idLoaiPhong = b.idLoaiPhong where trangThai = N'Đang sử dụng'");
    }
    
    public List<Object[]> getPhongTrong(int idLoaiPhong) {
        return getRawValues("select idPhong,tenPhong,a.idLoaiPhong,tenLoaiPhong from Phong a join LoaiPhong b "
                            + "on a.idLoaiPhong = b.idLoaiPhong where trangThai = N'Phòng trống' and a.idLoaiPhong = "+idLoaiPhong+"");
    }
    
    public List<Object[]> setThongTinPhong(int idPhong) {
        return getRawValues("select a.soCMND,soNguoi,a.ngayDat,ngayDi,hinhThucThue,tenKhach,diaChi,soDT,hoChieu from phieuThuePhong a \n" +
                            "join KhachHang b on a.soCMND = b.soCMND join Phong c on c.idPhong = a.idPhong where a.idPhong = "+idPhong+" and a.ngayDi is null");
    }
    
    public List<Object[]> getDataPhong() {
        return getRawValues("select a.idPhong,b.tenLoaiPhong,a.tenPhong,a.soKhachMax,a.ngayDat,a.trangThai from Phong a join LoaiPhong b "
                            + "on a.idLoaiPhong = b.idLoaiPhong");
    }
    
    public List<Object[]> getThongTinPhong(int idPhong) {
        return getRawValues("select idPhieuThue,ptp.ngayDat,ngayDi,ptp.soCMND soCMND,kh.diaChi diaChi,hoChieu,soDT,tenKhach,ten tenNv,soNguoi,p.idloaiphong,hinhThucThue,p.tenPhong from phieuThuePhong ptp \n" +
                            "join KhachHang kh on kh.soCMND=ptp.soCMND \n" +
                            "join NhanVien nv on nv.idNhanVien=ptp.idNhanVien \n" +
                            "join phong p on p.idphong=ptp.idphong where ptp.idPhong="+idPhong+" and ngayDi is null");
    }
    
    public void updateTinhTrangPhong(String trangThai,int idPhong) {
        String query = "update Phong set trangThai = ? where idPhong = ?";
        DBConnection.executeUpdate(query,trangThai, idPhong);
    }
    
    public void updateTinhTrangPhong2(String trangThai,int idPhong, int idLoaiPhong) {
        String query = "update Phong set trangThai = ? where idPhong = ? and idLoaiPhong = ?";
        DBConnection.executeUpdate(query,trangThai, idPhong, idLoaiPhong);
    }   

    public List<Object[]> getHinhThuc(int idLoaiPhong){
        return getRawValues("select giaGio,giaNgay from loaiPhong where idloaiPhong ="+idLoaiPhong+"");
    }
    
    public List<Object[]> idHinhThucThue(int idPhong){
        return getRawValues("select idLoaiPhong from phong where idPhong = "+idPhong+"");
    }
    
    public List<Object[]> getGiaPhong(int idPhong){
        return getRawValues("select idLoaiPhong from phong p join loaiphong lp on  where idPhong = "+idPhong+"");
    }

    public List<Object[]> getTenPhong(int idPhong){
        return getRawValues("select tenPhong,tenLoaiPhong from Phong p join LoaiPhong lp on p.idLoaiPhong=lp.idLoaiPhong\n" +
                                "where idPhong="+idPhong+"");
    }
}
