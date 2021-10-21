///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package helper;
//
//import DAO.NhanVienDAO;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.Period;
//import java.time.ZoneId;
//import java.util.Date;
//
///**
// *
// * @author Dongnguyen
// */
//public class DataValidate {
//    static NhanVienDAO nhanVienDAO = new NhanVienDAO();
//    static SimpleDateFormat sql = new SimpleDateFormat("yyyy-MM-dd");
//    
//      public static void checkEmpty(String field,StringBuilder sb,String errMess){
//        if(field.equals("")){
//            sb.append(errMess).append("\n");
//        }
//    }
//    
//    public static void checkEmailForm(String email,StringBuilder sb){
//        if(checkEmail(email)==false){
//            sb.append("Email không đúng định dạng! \n");
//        }
//    }
//    
//    public static void checkEmailExist(String email,StringBuilder sb){
//        System.out.println("CheckMail");
//        if(nhanVienDAO.checkEmailExist(email)){
//            sb.append("Email đã tồn tại! \n");
//        }
//    }
//    
//    public static void checkSdtForm(String sdt,StringBuilder sb){
//        try {
//            Double checksdt = Double.parseDouble(sdt);
//            if (sdt.length() != 10) {
//                sb.append("Số điện thoại phải đúng 10 chữ số\n");
//            }
//            if (checkPhone(sdt) == false) {
//                sb.append("Số điện thoại không hợp lệ\n");
//            }
//        } catch (Exception e) {
//            sb.append("Số điện thoại Phải là chữ số \n");
//        }
//    }
//    
//    public static void checkPhoneExist(String sdt, StringBuilder sb){
//        if(nhanVienDAO.checkPhoneExist(sdt)){
//            sb.append("Số đt đã tồn tại! \n");
//        }
//    }
//    
//    public static void checkNgayThang(Date nSinh,Date nVao,StringBuilder sb){
//        String today = sql.format(new Date());
//        String nSinh1 = sql.format(nSinh);
//        String nVao1 = sql.format(nVao);
//        
//        try {
//            Date d1 = sql.parse(nSinh1);
//            Date d2 = sql.parse(today);
//            Date d3 = sql.parse(nVao1);
//            LocalDate localDate = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            Period period = Period.between(localDate, LocalDate.now());
//            int age = period.getYears();
//            if (d1.after(d2)) {
//                sb.append("Ngày Sinh phải nhỏ hơn ngày hiện tại \n");
//            }
//            if (d1.after(d3)) {
//                sb.append("Ngày sinh phải nhỏ hơn ngày vào \n");
//            }
//            if (d3.before(d2) == true || d3.equals(d2) == true) {
//            } else {
//                sb.append("Ngày vào phải nhỏ hơn hoặc bằng ngày hiện tại! \n");
//            }
//            if (!(age >= 18 && age <= 65)) {
//                sb.append("Tuổi của nv phải trong khoảng 18-65! \n");
//            }
//        } catch (Exception e) {
//        }
//    }
//    
//    public static boolean checkEmail(String email) {
//        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//        return email.matches(regex);
//    }
//    
//    public static boolean checkPhone(String num) {
//        String[] dauSoDienThoai = {"09", "03", "08", "02", "07", "05"};
//        String dauSo = num.substring(0, 2);
//        for (int i = 0; i < dauSoDienThoai.length; i++) {
//            if (dauSo.equals(dauSoDienThoai[i])) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public static void checkCMND(String cmnd,StringBuilder sb){
//        try {
//            Double checksdt = Double.parseDouble(cmnd);
//            if (cmnd.length() != 9) {
//                sb.append("Số CMND phải đúng 9 chữ số\n");
//            }
//        } catch (Exception e) {
//            sb.append("Số CMND Phải là chữ số \n");
//        }
//    }
//    
//    public static void checkSoHoChieu(String shc,StringBuilder sb){
//        if (shc.length() != 7) {
//            sb.append("Số CMND phải đúng 7 ký tự\n");
//        }
//    }
//    
//    
//}
