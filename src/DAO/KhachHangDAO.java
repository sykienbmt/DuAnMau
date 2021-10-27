package DAO;

import helper.DBConnection;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author tuanl
 */
public class KhachHangDAO extends AbsDAO<KhachHang>{
    public List<Object[]> getCMND(String CMND) {
        return getRawValues("select tenKhach,diaChi,hoChieu,soDT,soCMND from KhachHang where soCMND like '%"+CMND+"%' ");
    }
}
