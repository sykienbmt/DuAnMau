package model;

/**
 *
 * @author tuanl
 */
public class KhachHang extends AbsTable{
    private Integer idKhachHang;
    private String CMND;
    private String tenKhach;
    private String diaChi;
    private String hoChieu;
    private String SDT;

    public KhachHang() {
    }

    public KhachHang(Integer idKhachHang, String CMND, String tenKhach, String diaChi, String hoChieu, String SDT) {
        this.idKhachHang = idKhachHang;
        this.CMND = CMND;
        this.tenKhach = tenKhach;
        this.diaChi = diaChi;
        this.hoChieu = hoChieu;
        this.SDT = SDT;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoChieu() {
        return hoChieu;
    }

    public void setHoChieu(String hoChieu) {
        this.hoChieu = hoChieu;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public int getId() {      
        return idKhachHang;   
    } 
}
