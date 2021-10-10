package controller;

import DAO.LoaiPhongDAO;
import DAO.PhongDAO;
import java.util.List;
import model.LoaiPhong;
import model.Phong;
import panel.PhongPnl;

public class PhongController {
    PhongPnl view;
    
    public PhongController(PhongPnl view) {
        this.view = view;
        loadList();
        loadListBtnPhong();
        view.setController(this);
    }
    
    LoaiPhongDAO loaiPhongDAO = new LoaiPhongDAO();
    PhongDAO phongDAO = new PhongDAO();
    
    public void loadList() {     
        List<Object[]> phongs = phongDAO.getDataPhong();
        view.viewTablePhong(phongs);
    }
    
    public void loadListBtnPhong() {
        List<Phong> phongs = phongDAO.getAll();
        view.viewBtnPhong(phongs);
    }
    
//    public void insert(int idLoaiPhong,String tenPhong, String soKhach, java.sql.Date ngayDat, String trangThai) {
//            Phong phong = new Phong(0, idLoaiPhong, tenPhong, soKhach, ngayDat, trangThai);
//            phongDAO.insert(phong);
//            loadList();
//    }
//     
    public void update(int idPhong,int idLoaiPhong,String tenPhong, String soKhach, java.sql.Date ngayDat, String trangThai) {
            Phong phong = new Phong(idPhong, idLoaiPhong, tenPhong, soKhach, ngayDat, trangThai);
            phongDAO.edit(phong);
            loadList();
    }  
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
        return phongDAO.getById(id);
    }
    
    public List<LoaiPhong> getLoaiPhong() {
        List<LoaiPhong> loaiPhongs = loaiPhongDAO.getAll();
        return loaiPhongs;
    }
}
