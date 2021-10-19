package controller;

import DAO.DanhMucDAO;
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
        //loadListBtnPhong();
        view.setController(this);
    }
    
    LoaiPhongDAO loaiPhongDAO = new LoaiPhongDAO();
    PhongDAO phongDAO = new PhongDAO();
    
    public void loadList() {     
        List<Object[]> phongs = phongDAO.getDataPhong();
//        view.viewTablePhong(phongs);
    }
    
    public List<Object[]> loadDataPhong(int idPhong){
        List<Object[]> phongs = phongDAO.getThongTinPhong(idPhong);
        return phongs;
    }
    
//    public void loadListBtnPhong() {
//        List<Phong> phongs = phongDAO.getAll();
//        view.viewBtnPhong(phongs);
//    }
    
    
    public List<Object[]> checkHoaDonPhong(int idPhong){
        List<Object[]> phongs = phongDAO.checkHoaDonPhong(idPhong);
        return phongs;
    }
    
    public List<Object[]> layChiTietDichVu(int idPhong) {
        List<Object[]> phongs = phongDAO.layChiTietDichVu(idPhong);
        return phongs; 
    }
    
    public void taoHoaDonDichVu (int idPhong){
        phongDAO.taoHoaDonDichVu(idPhong);
    }
    
    public List<Object[]> layIdHoaDonDichVu(int idPhong){
        List<Object[]> phongs = phongDAO.layIdHoaDonDichVu(idPhong);
        return phongs;
    }
    
    public void themChiTietDichVu(int idHoaDon,int idDichVu,int soLan){
        phongDAO.themChiTietHoaDonDV(idHoaDon, idDichVu, soLan);
    }
    
    public List<Object[]> getHinhThuc(int idLoaiPhong){
        return phongDAO.getHinhThuc(idLoaiPhong);
    }
//    public void insert(int idLoaiPhong,String tenPhong, String soKhach, java.sql.Date ngayDat, String trangThai) {
//            Phong phong = new Phong(0, idLoaiPhong, tenPhong, soKhach, ngayDat, trangThai);
//            phongDAO.insert(phong);
//            loadList();
//    }
//     
    public List<Object[]> getGiaPhong(int idPhong){
        return phongDAO.getGiaPhong(idPhong);
    }
    public void updateTinhTrangPhong(int idPhong) {
        phongDAO.updateTinhTrangPhong(idPhong);
    }
    
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
    
    public List<Object[]> getIdHinhThucThue(int idPhong){
        return phongDAO.idHinhThucThue(idPhong);
    }
}
