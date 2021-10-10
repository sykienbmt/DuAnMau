package controller;

import DAO.DichVuDAO;
import java.util.List;
import model.Phong;
import panel.PhongPnl;

public class DichVuController {
    PhongPnl view;
    
    public DichVuController(PhongPnl view) {
        this.view = view;
        loadListDichVu();
//        view.setController(this);
    }
    
    DichVuDAO dichVuDAO = new DichVuDAO();
    
//    public void loadListBtnPhong() {
//        List<Phong> tp = phongDAO.getListPhong();
//        view.viewBtnPhong(tp);
//    }
    
    public void loadListDichVu() {
        List<Object[]> dichVu = dichVuDAO.getTableData();
//        view.viewTableDichVu(dichVu);
    }
    
//    public void insert(String ten, String email, String sdt, String sex, Double luong, int chucVu, String diaChi, java.sql.Date ngaySinh, java.sql.Date ngayVao, String trangThai) {
//            NhanVien nhanVien = new NhanVien(0, ten, email, sdt, sex, luong, chucVu, diaChi, ngaySinh, ngayVao, trangThai);
//            nhanVienDAO.insert(nhanVien);
//            loadList();
//    }
//     
//    public void update(int idNhanVien,String ten, String email, String sdt, String sex, Double luong, int chucVu, String diaChi, java.sql.Date ngaySinh, java.sql.Date ngayVao, String trangThai) {
//            NhanVien nhanVien = new NhanVien(idNhanVien, ten, email, sdt, sex, luong, chucVu, diaChi, ngaySinh, ngayVao, trangThai);
//            nhanVienDAO.edit(nhanVien);
//            loadList();
//    }  
//    
//    public void delete(List<Integer> MaNhanVien) {
//        for (Integer integer : MaNhanVien) {
//            nhanVienDAO.delete(MaNhanVien);
//        }
//        
//        loadList();
//    }
//    
//    public void search(String name){
//        List<Object[]> staffs =staffDAO.searchByName(name);
//        view.viewTableStaff(staffs);
//    }
    
    public Phong getByIdPhong (Integer id) {
        return dichVuDAO.getById(id);
    }
}
