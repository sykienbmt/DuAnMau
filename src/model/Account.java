package model;

/**
 *
 * @author tuanl
 */
public class Account extends AbsTable{
    private Integer idAcc;
    private String ten;
    private String email;
    private String pass;
    private String verifyCode;

    public Account() {
    }

    public Account(Integer idAcc, String ten, String email, String pass, String verifyCode) {
        this.idAcc = idAcc;
        this.ten = ten;
        this.email = email;
        this.pass = pass;
        this.verifyCode = verifyCode;
    }
    
    public Account(Integer idAcc, String ten, String email, String pass) {
        this.idAcc = idAcc;
        this.ten = ten;
        this.email = email;
        this.pass = pass;
    }

    public Integer getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(Integer idAcc) {
        this.idAcc = idAcc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public int getId() {
        return idAcc;
    }
    
    
}
