package DAO;

import helper.DBConnection;
import java.sql.Timestamp;
import java.util.Date;
import model.PhieuThuePhong;

/**
 *
 * @author tuanl
 */
public class PhieuThuePhongDAO extends AbsDAO<PhieuThuePhong>{
    public void offPhieuThuePhong(int idPhieuThue){
        Timestamp timeNow = new Timestamp(new Date().getTime());
        String query = "update phieuThuePhong set ngayDi=? where idPhieuThue =?";
        DBConnection.executeQuery(query, timeNow,idPhieuThue);
    }
}
