/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ThongKeDAO extends AbsDAO{
    public List<Object[]> thongKeTheoKhoang(String tu,String den) {
        return getRawValues("select idhoaDon,p.tenPhong,ten,FORMAT(ptp.ngayDi ,'dd/MM/yyyy HH:mm:ss') ngayDi,\n" +
                            "format(tienGio,'#,#') tienGio,format(tienDichVu,'#,#') tienDichVu,format(phuThu,'#,#') phuThu,format(tienGio+tienDichVu+phuThu,'#,#') total\n" +
                            "from HoaDon hd \n" +
                            "join phieuThuePhong ptp on hd.idPhieuThue=ptp.idPhieuThue\n" +
                            "join HoaDonDichVu hddv on hddv.idHoaDonDichVu=hd.idHoaDonDichVu\n" +
                            "join Phong p on p.idPhong=ptp.idPhong\n" +
                            "join LoaiPhong lp on p.idLoaiPhong=lp.idLoaiPhong\n" +
                            "join NhanVien nv on nv.idNhanVien=ptp.idNhanVien \n" +
                            "where ptp.ngayDi between '"+tu+"' and '"+den+"'");
    }
}
