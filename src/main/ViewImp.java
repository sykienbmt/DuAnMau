package main;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewImp {

    public static void viewList(List<Object[]> rows, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        // xóa tất cả các dòng khỏi bảng
        for (int rowIndex = tableModel.getRowCount() - 1; rowIndex >= 0; rowIndex--) {
            tableModel.removeRow(rowIndex);
        }

        // thêm các dòng vào bảng
        for (Object[] row : rows) {
            tableModel.addRow(row);
        }
    }

    public static void setColumnNames(String[] columnNames, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(columnNames);
    }

//    public static void showErros(List<ConstraintViolation> errorList, JLabel errorLb) {
//        String errors = "";
//        for (ConstraintViolation constraintViolation : errorList) {
//            errors += constraintViolation.getMessage() + " | ";
//        }
//        errorLb.setText(errors);
//    }
}
