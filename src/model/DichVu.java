package model;

public class DichVu extends AbsTable{
    private Integer idDichVu;
    private String tenDichVu;
    private Double gia;
    private Integer idDonVi;
    private byte[] anhSanPham ;
    private Integer idDanhMuc;

    public DichVu() {
    }

    public DichVu(Integer idDichVu, String tenDichVu, Double gia, Integer idDonVi, byte[] anhSanPham, Integer idDanhMuc) {
        this.idDichVu = idDichVu;
        this.tenDichVu = tenDichVu;
        this.gia = gia;
        this.idDonVi = idDonVi;
        this.anhSanPham = anhSanPham;
        this.idDanhMuc = idDanhMuc;
    }

    public Integer getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Integer idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Integer getIdDonVi() {
        return idDonVi;
    }

    public void setIdDonVi(Integer idDonVi) {
        this.idDonVi = idDonVi;
    }

    public byte[] getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(byte[] anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    

    @Override
    public int getId() {
        return idDichVu;
    }
    
    
}
