package DAO;

import connect.DBConnection;
import model.AbsTable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbsDAO<T extends AbsTable> {
    
    public void insert(T obj) {
        /*
        insert into table {DanhMuc, BanAn} values (?,?,?)
        */
        String query = "insert into " + obj.getTableName();
        query += " values (";
        for (String column : obj.getColumnNames()) {
            query += "?,";
        }
        //"insert into DanhMuc values (?,"
        query = query.substring(0, query.length() - 1);
        //"insert into DanhMuc values (?"
        query += ")";
        //"insert into DanhMuc values (?)
        System.out.println("Chạy lệnh sql: " + query);
        DBConnection.executeUpdate(query, obj.getValues());
    }
    
    public void edit(T dto) {
        // câu lệnh edit
        // update {tableName} set {column1} = ?, {column2} = ?, {column3} = ? where {idColumn} = ?
        String query = "update " + dto.getTableName() + " set ";
        // tạo đoạn {column1} = ?, {column2} = ?, {column3} = ?
        for (String column : dto.getColumnNames()) {
            query += column + "=?,";
        }
        // xóa dấu , cuối cùng
        query = query.substring(0, query.length() - 1);
        // thêm doạn where {idColumn} = ?
        query += " where " + dto.getIdName() + " = ?";
        // tạo danh sách giá trị thêm vào câu query
        Object[] values = new Object[dto.getValues().length + 1];
        // copy dữ liệu từ object qua values
        System.arraycopy(dto.getValues(), 0, values, 0, dto.getValues().length);
        // thêm id vào cuối dữ liệu
        values[values.length - 1] = dto.getId();
        // chạy câu query
        System.out.println("Chạy lệnh sql: " + query);
        DBConnection.executeUpdate(query, values);
    }
    
    public void delete(List<Integer> id) {
        T dto = this.createDto();
        // câu lệnh delete
        // delete {tableName} where {idColumn} = ?
        for (Integer integer : id) {
            String query = "delete " + dto.getTableName() + " where " + dto.getIdName() + "=?";
            // chạy câu query
            System.out.println("Chạy lệnh sql: " + query);
            DBConnection.executeUpdate(query, integer);
        }
        
        
    }
    
    public List<T> getAll() {
        return getWithWhereClause(null);
    }
    
    public T getById(int id) {
        T dto = createDto();
        List<T> dtos = getWithWhereClause( dto.getIdName() + " = ?", id);
        if (dtos.isEmpty()) {
            return null;
        }
        return dtos.get(0);
    }
    
    public List<T> getWithWhereClause(String whereClause, Object ...parameters) {
        try {
            T tempDto = createDto();
            String query = "Select * from %s";
            if (whereClause != null) {
                query += " where " + whereClause;
            }
            query = String.format(query, tempDto.getTableName());
            ResultSet rs = DBConnection.executeQuery(query, parameters);
            
            // mảng dữ liệu trả về
            List<T> returnData = new ArrayList<>();
            while(rs.next()) {
                returnData.add(getDtoFromResultSet(rs));
            }
            return returnData;
        } catch (SQLException ex) {
            Logger.getLogger(AbsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Object[]> getRawValues(String sql, Object ...parameters) {
        try {
            List<Object[]> data = new ArrayList<>();
            ResultSet rs = DBConnection.executeQuery(sql, parameters);
            
            while(rs.next()) {
                List<Object> values = new ArrayList<>();
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    values.add(rs.getObject(i + 1));
                }
                data.add(values.toArray());
            }
            return data;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private T getDtoFromResultSet(ResultSet rs) {
        try {
            // lấy đối tượng dto
            T tempDto = createDto();
            // lấy danh sách cột
            String[] columns = tempDto.getColumnNames();
            // Chứa dữ liệu
            Object[] values = new Object[columns.length + 1];
            
            values[0] = rs.getObject(tempDto.getIdName());
            // duyệt qua danh cột
            for (int i = 0; i < columns.length; i++) {
                values[i + 1] = rs.getObject(columns[i]);
            }
            tempDto.setValue(values);
            return tempDto;
        } catch (SQLException ex) {
            Logger.getLogger(AbsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public T createDto() {
        try {
            // lấy class dto từ generic type T
            Class dtoType = ((Class) ((ParameterizedType) getClass()
                    .getGenericSuperclass())
                    .getActualTypeArguments()[0]);
            // ví dụ ở đây lớp DanhMucDao sẽ là DanhMuc
            // Lấy contructor (phuong thức khởi tạo) không có tham số
            Constructor constructor = dtoType.getConstructor();
            // tạo đối tượng từ contructor đã tạo
            T dto = (T) constructor.newInstance();
            return dto;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(AbsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
