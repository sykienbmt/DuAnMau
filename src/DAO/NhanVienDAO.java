package DAO;

import model.NhanVien;
import java.util.List;

public class NhanVienDAO extends AbsDAO<NhanVien>{
    public List<Object[]> getDataStaff() {
        return getRawValues("select idNhanVien,ten,email,sdt,sex,format(luong,'#,#') as luong,b.tenChucVu,diaChi,CONVERT(nvarchar,NgaySinh,105) as ngaySinh,\n" +
                            "CONVERT(nvarchar,NgayVaoLam,105) as ngayVaoLam,trangThai from NhanVien a join ChucVu b on a.idChucVu = b.idChucVu ");
    }
    
    public List<Object[]> searchNhanVien(String tenNhanVien) {
        return getRawValues("select idNhanVien,ten,email,sdt,sex,format(luong,'#,#') as luong,tenChucVu,diaChi,CONVERT(nvarchar,NgaySinh,105) as ngaySinh,"
                + "CONVERT(nvarchar,NgayVaoLam,105) as ngayVaoLam,trangThai from NhanVien a "
                            + "join ChucVu b on a.idChucVu = b.idChucVu where ten like N'%"+tenNhanVien+"%'");
    }
    
    public List<Object[]> searchLuongNhanVien(int luongNhanVien) {
        return getRawValues("select idNhanVien,ten,email,sdt,sex,format(luong,'#,#') as luong,tenChucVu,diaChi,CONVERT(nvarchar,NgaySinh,105) as ngaySinh,"
                + "CONVERT(nvarchar,NgayVaoLam,105)as ngayVaoLam,trangThai from NhanVien a "
                            + "join ChucVu b on a.idChucVu = b.idChucVu where luong <= "+luongNhanVien+"");
    }
       
    public boolean checkEmailExist(String email){
        List<Object[]> data=getRawValues("select count(*) from NhanVien where email = ?", email);
        Integer count =(Integer) data.get(0)[0];
        return count >0;
    }
    
    public boolean checkPhoneExist(String phone){
        List<Object[]> data=getRawValues("Select count(*) from NhanVien where sdt=?", phone);
        Integer count =(Integer) data.get(0)[0];
        return count >0;
    }
}
