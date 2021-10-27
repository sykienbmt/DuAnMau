package DAO;

import helper.DBConnection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import model.PhieuThuePhong;

/**
 *
 * @author tuanl
 */
public class PhieuThuePhongDAO extends AbsDAO<PhieuThuePhong>{
    public void offPhieuThuePhong(int idPhieuThue){
        Timestamp timeNow = new Timestamp(new Date().getTime());
        String query = "update phieuThuePhong set ngayDi=? where idPhieuThue =?";
        System.out.println("update phieuThuePhong set ngayDi='"+timeNow+"' where idPhieuThue ="+idPhieuThue+"");
        DBConnection.executeUpdate(query, timeNow,idPhieuThue);
    }
    
    public List<Object[]> getIdPhieuThue(int idPhong){
        return getRawValues("select idPhieuThue from phieuThuePhong where idPhong = "+idPhong+" and ngayDi is null");
    }
    
    public void chuyenPhieuThuePhong(int idPhong, int idPhongCanDoi) {
        String query = "update phieuThuePhong set idPhong = ? where idPhong = ? and ngayDi is null";
        DBConnection.executeUpdate(query, idPhong, idPhongCanDoi);
    }
}
