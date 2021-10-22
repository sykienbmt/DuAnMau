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
public class DonViTinh extends AbsTable{
    private Integer idDonVi;
    private String tenDonVi;

    public DonViTinh() {
    }

    public DonViTinh(Integer idDonVi, String tenDonVi) {
        this.idDonVi = idDonVi;
        this.tenDonVi = tenDonVi;
    }

    public Integer getIdDonVi() {
        return idDonVi;
    }

    public void setIdDonVi(Integer idDonVi) {
        this.idDonVi = idDonVi;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    @Override
    public int getId() {
        return idDonVi;
    }
    
    @Override
    public String toString() {
        return tenDonVi; 
    }
}
