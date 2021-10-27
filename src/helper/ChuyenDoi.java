/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class ChuyenDoi {
    //Chuyển đổi date--String
    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //chuyển Date -> String
    public static String LayNgayString(Date date){
        return dateFormat.format(date);
    }

    //chuyển String -> Date
    public static Date LayNgayDate(String ngay){
        try {
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển ngày");
            return null;
        }
    }

    //chuyển từ Double <-> String 10.000.000
    //chuyển Double -> String
    public static String SoString(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    
    //chuyển String -> Double
    public static double SoDouble(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).doubleValue();
        } catch (ParseException ex) {
            return 0;
        }
    }
    
    //chuyển đổi chữ đầu thành hoa
    public static String doiTen(String ten){
	//cắt string thành mảng qua các dấu Space
	String[] arr = ten.split(" ");
	//dùng vòng lặp duyệt các từ và thay thế từ đầu tiên!
	String stringfromclient1 = "";
	for (String x : arr) {
		stringfromclient1 = stringfromclient1 + (x.substring(0, 1).toUpperCase() + x.substring(1));
		stringfromclient1 = stringfromclient1 + " ";
	}
        return stringfromclient1;
    }
    
}
