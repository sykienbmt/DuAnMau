package model;

/**
 *
 * @author tuanl
 */
public class DanhMuc extends AbsTable{
    private Integer idDanhMuc;
    private String tenDanhMuc;

    public DanhMuc() {
    }

    public DanhMuc(Integer idDanhMuc, String tenDanhMuc) {
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    @Override
    public int getId() {
        return idDanhMuc;
    }
    
    @Override
    public String toString() {
        return tenDanhMuc;
    }
    
}
