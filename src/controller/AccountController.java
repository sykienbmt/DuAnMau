package controller;

import DAO.AccountDAO;
import model.Account;

/**
 *
 * @author tuanl
 */
public class AccountController {
    AccountDAO accDAO = new AccountDAO();
    
    public void insert(String ten, String email, String pass, String verifyCode) {
        Account account = new Account(0, ten, email, pass,verifyCode);
        accDAO.insert(account);
    }
}
