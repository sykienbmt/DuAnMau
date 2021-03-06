/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ThongKeDAO extends AbsDAO{
    public List<Object[]> thongKeTheoKhoang(String tu,String den) {
        return getRawValues("select idhoaDon,p.tenPhong,ten,FORMAT(ptp.ngayDi ,'dd/MM/yyyy') ngayDi,\n" +
                            "format(tienGio,'#,#') tienGio,format(tienDichVu,'#,#') tienDichVu,format(phuThu,'#,#') phuThu,format(tienGio+tienDichVu+phuThu,'#,#') total\n" +
                            "from HoaDon hd \n" +
                            "join phieuThuePhong ptp on hd.idPhieuThue=ptp.idPhieuThue\n" +
                            "join HoaDonDichVu hddv on hddv.idHoaDonDichVu=hd.idHoaDonDichVu\n" +
                            "join Phong p on p.idPhong=ptp.idPhong\n" +
                            "join LoaiPhong lp on p.idLoaiPhong=lp.idLoaiPhong\n" +
                            "join NhanVien nv on nv.idNhanVien=ptp.idNhanVien \n" +
                            "where ptp.ngayDi between '"+tu+"' and '"+den+"'");
    }
    
    public List<Object[]> thongKeDefault() {
        return getRawValues("select idhoaDon,p.tenPhong,ten,FORMAT(ptp.ngayDi ,'dd/MM/yyyy') ngayDi,\n" +
                            "format(tienGio,'#,#') tienGio,format(tienDichVu,'#,#') tienDichVu,format(phuThu,'#,#') phuThu,format(tienGio+tienDichVu+phuThu,'#,#') total "
                            + ",CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121),convert(date,getdate())\n" +
                            "from HoaDon hd join phieuThuePhong ptp on hd.idPhieuThue=ptp.idPhieuThue\n" +
                            "join HoaDonDichVu hddv on hddv.idHoaDonDichVu=hd.idHoaDonDichVu\n" +
                            "join Phong p on p.idPhong=ptp.idPhong\n" +
                            "join LoaiPhong lp on p.idLoaiPhong=lp.idLoaiPhong\n" +
                            "join NhanVien nv on nv.idNhanVien=ptp.idNhanVien \n" +
                            "where ptp.ngayDi between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE()");
    }
    
    public List<Object[]> bieuDoDefault() {
        return getRawValues("select MONTH(ngayDi) th??ng,sum(tienGio),sum(tienDichVu),sum(phuThu),YEAR(ngayDi) from HoaDon a join phieuThuePhong b "
                            + "on a.idPhieuThue = b.idPhieuThue where ngayDi between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01),"
                            + " 121) and GETDATE() group by MONTH(ngayDi),YEAR(ngayDi)");
    }
    
    public List<Object[]> thongKeBieuDo(String tu,String den) {
        return getRawValues("select MONTH(ngayDi) th??ng,sum(tienGio),sum(tienDichVu),sum(phuThu),YEAR(ngayDi) from HoaDon a join phieuThuePhong b on a.idPhieuThue = b.idPhieuThue\n" +
                            "where ngayDi between '"+tu+"' and '"+den+"' group by MONTH(ngayDi),YEAR(ngayDi)");
    }
}
