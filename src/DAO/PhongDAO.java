package DAO;

import helper.DBConnection;
import java.util.Date;
import java.util.List;
import model.Phong;
import java.sql.Timestamp;

public class PhongDAO extends AbsDAO<Phong>{
    public List<Object[]> setThongTinPhong(int idPhong) {
        return getRawValues("select a.soCMND,soNguoi,a.ngayDat,ngayDi,hinhThucThue,tenKhach,diaChi,soDT,hoChieu from phieuThuePhong a \n" +
                            "join KhachHang b on a.soCMND = b.soCMND join Phong c on c.idPhong = a.idPhong where a.idPhong = "+idPhong+" and a.ngayDi is null");
    }
    
    public List<Object[]> getDataPhong() {
        return getRawValues("select a.idPhong,b.tenLoaiPhong,a.tenPhong,a.soKhachMax,a.ngayDat,a.trangThai from Phong a join LoaiPhong b on a.idLoaiPhong = b.idLoaiPhong");
    }
    
    public List<Object[]> getThongTinPhong(int idPhong) {
        return getRawValues("select idPhieuThue,ptp.ngayDat,ngayDi,ptp.soCMND soCMND,kh.diaChi diaChi,hoChieu,soDT,tenKhach,ten tenNv,soNguoi,p.idloaiphong,hinhThucThue,p.tenPhong from phieuThuePhong ptp \n" +
                            "join KhachHang kh on kh.soCMND=ptp.soCMND \n" +
                            "join NhanVien nv on nv.idNhanVien=ptp.idNhanVien \n" +
                            "join phong p on p.idphong=ptp.idphong where ptp.idPhong="+idPhong+"");
    }
    
    public void updateTinhTrangPhong(String trangThai,int idPhong) {
        String query = "update Phong set trangThai = ? where idPhong = ?";
        DBConnection.executeUpdate(query,trangThai, idPhong);
    }
   
    public List<Object[]> checkHoaDonPhong(int idPhong){
        return getRawValues("select count(*) from HoaDonDichVu where idPhong="+idPhong+" and trangThai=1");
    }
    
    public void taoHoaDonDichVu(int idPhong){
        String query = "insert into HoaDonDichVu values (?,?,?,?,?)";
        Timestamp timeNow = new Timestamp(new Date().getTime());
        DBConnection.executeUpdate(query,idPhong,0,timeNow,"khong",1);
    }
    
    public List<Object[]> layIdHoaDonDichVu(int idPhong){
        String  query = "select idHoaDonDichVu from hoaDonDichVu where idPhong ="+idPhong+" and trangthai=1";
        return getRawValues(query);
    }
    
    public List<Object[]> layChiTietDichVu(int idPhong) {
        return getRawValues("select hd.idHoaDonDichVu,dv.tenDichVu,dvt.tenDonVi,ctdv.ngaySuDung,ctdv.soLanSuDung,ctdv.thanhTien from HoaDonDichVu hd \n" +
            "join ChiTietDichVu ctdv on hd.idHoaDonDichVu=ctdv.idHoaDonDichVu  \n" +
            "join DichVu dv on ctdv.idDichVu=dv.idDichVu \n" +
            "join donViTinh dvt on dvt.idDonVi=dv.idDonVi\n" +
            "where idphong="+idPhong+" and trangThai=1");
    }
    
    public void themChiTietHoaDonDV(int idHoaDonDichVu,int idDichVu,int soLan){
        String query2="insert into chiTietDichVu values (?,?,?,?,(select gia from DichVu where idDichVu=?)*?)";
        Timestamp timeNow = new Timestamp(new Date().getTime());
        DBConnection.executeUpdate(query2,idHoaDonDichVu,idDichVu,soLan,timeNow,idDichVu,soLan);
    }
    
    public List<Object[]> getHinhThuc(int idLoaiPhong){
        return getRawValues("select giaGio,giaNgay,giaThang,giaquy from loaiPhong where idloaiPhong ="+idLoaiPhong+"");
    }
    
    public List<Object[]> idHinhThucThue(int idPhong){
        return getRawValues("select idLoaiPhong from phong where idPhong = "+idPhong+"");
    }
    
    public List<Object[]> getGiaPhong(int idPhong){
        return getRawValues("select idLoaiPhong from phong p join loaiphong lp on  where idPhong = "+idPhong+"");
    }
    
    
    public List<Object[]> getIdPhieuThue(int idPhong){
        return getRawValues("select idPhieuThue from phieuThuePhong where idPhong = "+idPhong+" and ngayDi is null");
    }

    //lấy id hoá đơn
    public List<Object[]> getIdHoaDon(int idPhieuThue,int idHoaDonDv){
        return getRawValues("select idHoaDon from HoaDon where idPhieuThue="+idPhieuThue+" and idHoaDonDichVu="+idHoaDonDv+"");
    }
    
    //set trang thai phong tra tien
    public void offPhieuThuePhong(int idPhieuThue){
        Timestamp timeNow = new Timestamp(new Date().getTime());
        String query = "update phieuThuePhong set ngayDi=? where idPhieuThue =?";
        DBConnection.executeUpdate(query, timeNow,idPhieuThue);
    }
    
    //set tiền dịch vụ vào phiếu dịch vụ
    public void updateTienDichVu(Double tongTien,int idHoaDonDichVu){
        String query = "update HoaDonDichVu set tongTien = ? where idHoaDonDichVu =?";
        DBConnection.executeUpdate(query,tongTien,idHoaDonDichVu);
    }
    
    //off hoá đơn dịch vụ
    public void offHoaDonDichVu(int idPhong){
        String query = "update HoaDonDichVu set trangThai=0 where idPhong=? and trangthai=1";
        DBConnection.executeUpdate(query,idPhong);
    }
}
