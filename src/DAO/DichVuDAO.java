package DAO;

import helper.DBConnection;
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
    
    public List<Object[]> layChiTietDichVu(int idPhong) {
        return getRawValues("select hd.idHoaDonDichVu,dv.tenDichVu,dvt.tenDonVi,FORMAT(ctdv.ngaySuDung ,'dd/MM/yyyy HH:mm:ss') ngaySuDung,ctdv.soLanSuDung,format(ctdv.thanhTien,'#,#')thanhTien from HoaDonDichVu hd \n" +
            "join ChiTietDichVu ctdv on hd.idHoaDonDichVu=ctdv.idHoaDonDichVu  \n" +
            "join DichVu dv on ctdv.idDichVu=dv.idDichVu \n" +
            "join donViTinh dvt on dvt.idDonVi=dv.idDonVi\n" +
            "where idphong="+idPhong+" and trangThai=1");
    }
    
        public void updateTienDichVu(Double tongTien,int idHoaDonDichVu){
        String query = "update HoaDonDichVu set tongTien = ? where idHoaDonDichVu =?";
        DBConnection.executeUpdate(query,tongTien,idHoaDonDichVu);
    }
}
