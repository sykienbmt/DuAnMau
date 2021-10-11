package model;

public class DichVu extends AbsTable{
    private Integer idDichVu;
    private String tenDichVu;
    private Double gia;
    private Integer idDonVi;

    public DichVu() {
    }

    public DichVu(Integer idDichVu, String tenDichVu, Double gia, Integer idDonVi) {
        this.idDichVu = idDichVu;
        this.tenDichVu = tenDichVu;
        this.gia = gia;
        this.idDonVi = idDonVi;
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

    @Override
    public int getId() {
        return idDichVu;
    }
    
    
}
