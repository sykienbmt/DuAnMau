package model;

public class TrangThai extends AbsTable{
    private Integer idTrangThai;
    private String tenTrangThai;

    public TrangThai() {
    }

    public Integer getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(Integer idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    @Override
    public int getId() {
        return idTrangThai;
    }
    
    @Override
    public String toString() {
        return tenTrangThai;
    }
}
