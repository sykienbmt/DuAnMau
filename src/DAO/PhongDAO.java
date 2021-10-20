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
        return getRawValues("select idPhieuThue,ptp.ngayDat,ngayDi,ptp.soCMND soCMND,kh.diaChi diaChi,hoChieu,soDT,tenKhach,ten tenNv,soNguoi,p.idloaiphong,hinhThucThue from phieuThuePhong ptp \n" +
                            "join KhachHang kh on kh.soCMND=ptp.soCMND \n" +
                            "join NhanVien nv on nv.idNhanVien=ptp.idNhanVien \n" +
                            "join phong p on p.idphong=ptp.idphong where ptp.idPhong="+idPhong+"");
    }
    
    public void updateTinhTrangPhong(int idPhong) {
        String query = "update Phong set trangThai = N'Đang sử dụng' where idPhong = ?";
        DBConnection.executeUpdate(query, idPhong);
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
    
    
//    public phieuThuePhong getThongTinPhong(int idPhong){
//        String query = "select idPhieuThue,ptp.ngayDat,ptp.ngayDi,ptp.soCMND,kh.diaChi,kh.hoChieu,kh.soDT,kh.tenKhach,nv.ten,soNguoi from phieuThuePhong ptp "
//                + "join KhachHang kh on kh.soCMND=ptp.soCMND join NhanVien nv on nv.idNhanVien=ptp.idNhanVien where idPhong="+idPhong;
//        phieuThuePhong ptp = new phieuThuePhong();
//        
//        ResultSet rs = DBConnection.executeQuery(query);
//        String num ="";
//        try {
//            while (rs.next()) {
//                ptp.setIdPhieuThue(rs.getInt("idPhieuThue"));
//                ptp.setNgayDat(rs.getTimestamp("ngayDat"));
//                ptp.setNgayDi(rs.getTimestamp("ngayDi"));
//                ptp.setSoCMND(rs.getString("SoCMND"));
//                ptp.setDiaChi(rs.getString("diaChi"));
//                ptp.setHoChieu(rs.getString("hoChieu"));
//                ptp.setSoDT(rs.getString("SoDt"));
//                ptp.setTenKhach(rs.getString("tenKhach"));
//                ptp.setTenNv(rs.getString("tenNv"));
////                ptp.setSoNguoi(rs.getInt("soNguoi"));
//                num=rs.getString("soNguoi");
//            }
//        } catch (Exception e) {
//        }
//        System.out.println("số người "+num.toString());
//        return ptp;
//    }
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
