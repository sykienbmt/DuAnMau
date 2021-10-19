package controller;

import DAO.ChucVuDAO;
import DAO.NhanVienDAO;
import model.ChucVu;
import model.NhanVien;
import panel.NhanVienPnl;
import java.util.List;

public class NhanVienController {
    NhanVienPnl view;
    
    public NhanVienController(NhanVienPnl view) {
        this.view = view;
        loadList();
        view.setController(this);
    }
    
    ChucVuDAO cvDAO = new ChucVuDAO();
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    
    public void loadList() {     
        List<Object[]> nhanViens = nhanVienDAO.getDataStaff();
        view.viewTableStaff(nhanViens);
    }
    
    public List<Object[]> searchNhanVien(String tenNhanVien) {
        List<Object[]> nhanViens = nhanVienDAO.searchNhanVien(tenNhanVien);
        return nhanViens;
    }
    
    public void insert(String ten, String email, String sdt, String sex, Double luong, int chucVu, String diaChi, java.sql.Date ngaySinh, java.sql.Date ngayVao, String trangThai) {
            NhanVien nhanVien = new NhanVien(0, ten, email, sdt, sex, luong, chucVu, diaChi, ngaySinh, ngayVao, trangThai);
            nhanVienDAO.insert(nhanVien);
            loadList();
    }
     
    public void update(int idNhanVien,String ten, String email, String sdt, String sex, Double luong, int chucVu, String diaChi, java.sql.Date ngaySinh, java.sql.Date ngayVao, String trangThai) {
            NhanVien nhanVien = new NhanVien(idNhanVien, ten, email, sdt, sex, luong, chucVu, diaChi, ngaySinh, ngayVao, trangThai);
            nhanVienDAO.edit(nhanVien);
            loadList();
    }  
    
    public void delete(List<Integer> MaNhanVien) {
        for (Integer integer : MaNhanVien) {
            nhanVienDAO.delete(MaNhanVien);
        }        
        loadList();
    }
    
    public NhanVien getByIdNhanVien (Integer id) {
        return nhanVienDAO.getById(id);
    }
    
    public List<ChucVu> getChucVu() {
        List<ChucVu> chucVus = cvDAO.getAll();
        return chucVus;
    }
}
