package DAO;

import java.util.List;
import model.DichVu;

public class DichVuDAO extends AbsDAO<DichVu>{
    public List<Object[]> getTableData() {
        return getRawValues("select idDichVu,tenDichVu,tenDonVi,format(gia,'#,#') gia from DichVu a join donViTinh b on a.idDonVi = b.idDonVi");
    }
    
    public List<Object[]> getDataDichVu (){
        return getRawValues("select idDichVu,tenDichVu,tenDonVi,format(gia,'#,#') gia,b.idDonVi,idDanhMuc from DichVu a join donViTinh b on a.idDonVi = b.idDonVi");
    }
    
    public List<Object[]> searchDichVu(String tenDanhMuc) {
        return getRawValues("select idDichVu,tenDichVu,tenDonVi,format(gia,'#,#') gia from DichVu a join DanhMuc b on a.idDanhMuc = b.idDanhMuc "
                            + "join donViTinh c on c.idDonVi = a.idDonVi where tenDichVu like N'%"+tenDanhMuc+"%'");
    }
    
    public List<Object[]> showDichVu(){
        return getRawValues("select dv.idDichVu,tenDichVu,format(gia,'#,#') gia,tenDonVi,tenDanhMuc from DichVu dv join DanhMuc dm on dv.idDanhMuc=dm.idDanhMuc join donViTinh dvt on dv.idDonVi=dvt.idDonVi");
    }
    
    
    
//    public List<Phong> getListPhong() {
//        return getAll();
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
