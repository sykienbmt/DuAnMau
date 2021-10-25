package DAO;

import helper.DBConnection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import model.HoaDon;

/**
 *
 * @author Administrator
 */
public class HoaDonDAO extends AbsDAO<HoaDon>{
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
    
    public List<Object[]> getIdHoaDon(int idPhieuThue){
        return getRawValues("select idHoaDon from HoaDon where idPhieuThue="+idPhieuThue+"");
    }
    
    public void themChiTietHoaDonDV(int idHoaDonDichVu,int idDichVu,int soLan){
        String query2="insert into chiTietDichVu values (?,?,?,?,(select gia from DichVu where idDichVu=?)*?)";
        Timestamp timeNow = new Timestamp(new Date().getTime());
        DBConnection.executeUpdate(query2,idHoaDonDichVu,idDichVu,soLan,timeNow,idDichVu,soLan);
    }
    
    public void offHoaDonDichVu(int idPhong){
        String query = "update HoaDonDichVu set trangThai=0 where idPhong=? and trangthai=1";
        DBConnection.executeUpdate(query,idPhong);
    }
    
    public void chuyenHoaDonDichVuPhong(int idPhong, int idPhongCanDoi) {
        String query = "update HoaDonDichVu set idPhong = ? where idPhong = ? and trangThai = 1";
        DBConnection.executeUpdate(query, idPhong, idPhongCanDoi);
    }
}
