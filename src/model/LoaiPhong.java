package model;

public class LoaiPhong extends AbsTable{
    private Integer idLoaiPhong;
    private String tenLoaiPhong;
    private Double giaPhong;

    public LoaiPhong() {
    }

    public LoaiPhong(Integer idLoaiPhong, String tenLoaiPhong, Double giaPhong) {
        this.idLoaiPhong = idLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.giaPhong = giaPhong;
    }

    public Integer getIdLoaiPhong() {
        return idLoaiPhong;
    }

    public void setIdLoaiPhong(Integer idLoaiPhong) {
        this.idLoaiPhong = idLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public Double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(Double giaPhong) {
        this.giaPhong = giaPhong;
    }
    
    @Override
    public int getId() {
        return idLoaiPhong;
    }
    
    @Override
    public String toString() {
        return tenLoaiPhong;
    }
}
