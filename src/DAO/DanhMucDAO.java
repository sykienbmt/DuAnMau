package DAO;

import java.util.List;
import model.DanhMuc;

/**
 *
 * @author tuanl
 */
public class DanhMucDAO extends AbsDAO<DanhMuc>{
    public List<Object[]> loadDichVu(int idDanhMuc) {
        return getRawValues("select idDichVu,tenDichVu,tenDonVi,format(gia,'#,#') gia from DichVu a join DanhMuc b on a.idDanhMuc = b.idDanhMuc "
                            + "join donViTinh c on c.idDonVi = a.idDonVi where b.idDanhMuc ="+idDanhMuc+"");
    }
    
    public List<Object[]> loadAllDichVu() {
        return getRawValues("select idDichVu,tenDichVu,tenDonVi,gia from DichVu a join DanhMuc b on a.idDanhMuc = b.idDanhMuc "
                            + "join donViTinh c on c.idDonVi = a.idDonVi");
    }
}
