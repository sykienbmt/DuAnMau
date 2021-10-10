package model;

public class ChucVu extends AbsTable{
    
    private Integer idChucVu;
    private String tenChucVu;

    public ChucVu() {
    }

    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    @Override
    public int getId() {
        return idChucVu;
    }

    @Override
    public String toString() {
        return tenChucVu;
    }   
}
