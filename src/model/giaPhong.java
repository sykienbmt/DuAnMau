/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class giaPhong extends AbsTable{
    private String hinhThucThue;
    private String gia;

    public giaPhong() {
    }

    public giaPhong(String hinhThucThue, String gia) {
        this.hinhThucThue = hinhThucThue;
        this.gia = gia;
    }

    public String getHinhThucThue() {
        return hinhThucThue;
    }

    public void setHinhThucThue(String hinhThucThue) {
        this.hinhThucThue = hinhThucThue;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    
    
    
    @Override
    public String toString() {
        return this.hinhThucThue;
    }

    @Override
    public int getId() {
        return 0;
    }
    
    public String tenHinhThuc(){
        return this.gia;
    }    
    //Hàm lấy value kiểu String
    public String MaString(){
        return gia.toString();
    }
}
