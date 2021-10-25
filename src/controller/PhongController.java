package controller;

import DAO.DichVuDAO;
import DAO.HoaDonDAO;
import DAO.LoaiPhongDAO;
import DAO.PhieuThuePhongDAO;
import DAO.PhongDAO;
import java.util.List;
import model.LoaiPhong;
import model.Phong;
import panel.PhongPnl;

public class PhongController {
    PhongPnl view;
    PhieuThuePhongDAO phieuThueDAO = new PhieuThuePhongDAO();
    DichVuDAO dichVuDAO = new DichVuDAO();
    HoaDonDAO hoaDonDAO = new HoaDonDAO();
    LoaiPhongDAO loaiPhongDAO = new LoaiPhongDAO();
    PhongDAO phongDAO = new PhongDAO();
    
    public PhongController(PhongPnl view) {
        this.view = view;
        loadListBtnPhong();
        getListAllLoaiPhong();
        view.setController(this);
    }
    
    public List<Object[]> loadDataPhong(int idPhong){
        List<Object[]> phongs = phongDAO.getThongTinPhong(idPhong);
        return phongs;
    }
    
    public List<Object[]> setThongTinPhong(int idPhong){
        List<Object[]> phongs = phongDAO.setThongTinPhong(idPhong);
        return phongs;
    }
    
    public void loadListBtnPhong() {
        List<Phong> phongs = phongDAO.getAll();
        view.viewBtnPhong(phongs);
    }  

    public List<Phong> loadPhongHienTai() {
        List<Phong> phongs = phongDAO.getAll();
        return phongs;
    }
    
    public List<Object[]> checkHoaDonPhong(int idPhong){
        List<Object[]> phongs = hoaDonDAO.checkHoaDonPhong(idPhong);
        return phongs;
    }
    
    public List<Object[]> layChiTietDichVu(int idPhong) {
        List<Object[]> phongs = dichVuDAO.layChiTietDichVu(idPhong);
        return phongs; 
    }
    
    public void taoHoaDonDichVu (int idPhong){
        hoaDonDAO.taoHoaDonDichVu(idPhong);
    }
    
    public List<Object[]> layIdHoaDonDichVu(int idPhong){
        List<Object[]> phongs = hoaDonDAO.layIdHoaDonDichVu(idPhong);
        return phongs;
    }
    
    public void themChiTietDichVu(int idHoaDon,int idDichVu,int soLan){
        hoaDonDAO.themChiTietHoaDonDV(idHoaDon, idDichVu, soLan);
    }
    
    public List<Object[]> getHinhThuc(int idLoaiPhong){
        return phongDAO.getHinhThuc(idLoaiPhong);
    }
   
    public List<Object[]> getGiaPhong(int idPhong){
        return phongDAO.getGiaPhong(idPhong);
    }
    public void updateTinhTrangPhong2(String trangThai,int idPhong, int idLoaiPhong) {
        phongDAO.updateTinhTrangPhong2(trangThai,idPhong, idLoaiPhong);
    }
    
    public void updateTinhTrangPhong(String trangThai,int idPhong) {
        phongDAO.updateTinhTrangPhong(trangThai,idPhong);
    }
    
    public void update(int idPhong,int idLoaiPhong,String tenPhong, String soKhach, java.sql.Date ngayDat, String trangThai) {
        Phong phong = new Phong(idPhong, idLoaiPhong, tenPhong, soKhach, ngayDat, trangThai);
        phongDAO.edit(phong);
    }  
    
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
    
    //Lấy id Phiếu Thuê Phòng
    public List<Object[]> getIdPhieuThue(int idPhong){
        return phieuThueDAO.getIdPhieuThue(idPhong);
    }    
    
    //off phieu thue phong
    public void offPhieuThuePhong(int idPhieuThue){
        phieuThueDAO.offPhieuThuePhong(idPhieuThue);
    }
    
    //update tienDichVu
    public void updateTienHoaDonDV(Double tien , int idHoaDon){
        dichVuDAO.updateTienDichVu(tien, idHoaDon);
    }
    
    //lấy id hoá đơn
    public List<Object[]> getIdHoaDon(int idPhieuThue){
        return hoaDonDAO.getIdHoaDon(idPhieuThue);
    }
    
    //off Hoá đơn dịch vụ
    public void offHoaDonDichVu(int idPhong){
        hoaDonDAO.offHoaDonDichVu(idPhong);
    }
    
    //chuyển hóa đơn dịch vụ phòng
    public void chuyenHoaDonDichVuPhong(int idPhong, int idPhongCanDoi) {
        hoaDonDAO.chuyenHoaDonDichVuPhong(idPhong, idPhongCanDoi);
    }
    
    //chuyển phiếu thuê phòng
    public void chuyenPhieuThuePhong(int idPhong, int idPhongCanDoi) {
        phieuThueDAO.chuyenPhieuThuePhong(idPhong, idPhongCanDoi);
    }
    
    public List<Object[]> getPhongDangDung(){
        return phongDAO.getPhongDangDung();
    }
    
    public List<Object[]> getPhongTrong(int idLoaiPhong){
        return phongDAO.getPhongTrong(idLoaiPhong);
    }
    
    public List<Object[]> getListAllLoaiPhong(){
        return phongDAO.getListAllLoaiPhong();
    }
    
    public List<Object[]> getTenPhong(int idPhong){
        return phongDAO.getTenPhong(idPhong);
    }
}
