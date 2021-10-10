package model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbsTable {
    public String getTableName() {
        return this.getClass().getSimpleName();
    }
    public String getIdName(){
        return this.getClass().getDeclaredFields()[0].getName();
    }
    
    public abstract int getId();
    
    public String[] getColumnNames() {
        Field[] fields = this.getClass().getDeclaredFields();
        String[] columnNames = new String[fields.length - 1];
        for (int i = 0; i < fields.length; i++) {
            if (i == 0) {
                continue;
            }
            columnNames[i -1] = fields[i].getName();
        }
        return columnNames;
    }
    
    public Object[] getValues() {
        Field[] fields = this.getClass().getDeclaredFields();
        Object[] values = new Object[fields.length - 1];
        for (int i = 0; i < fields.length; i++) {
            try {
                if (i == 0) {
                    continue;
                }
                // gán chữ get + tên feild
                
                // lấy feild name
                String methodName = fields[i].getName();
                
                // ví dụ tenDanhMuc chạy cái này ra Chữ "T" in hoa đầu
                String upperChuDau = (methodName.charAt(0) + "").toUpperCase();
                
                methodName = "get" + upperChuDau + methodName.substring(1);
                Method getMethod = this.getClass().getMethod(methodName, null);
                values[i - 1] = getMethod.invoke(this, null);
                
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return values;
    }
    
    // lấy toàn bộ dữ liệu của table interface
    public Object[] getAllValues() {
        List<Object> objects = new ArrayList<>();
        // lấy id
        objects.add(this.getId());
        // lấy values
        // chuyển value thành list
        List<Object> values = Arrays.asList(this.getValues());
        // thêm vào mảng dữ liệu trả về
        objects.addAll(values);
        return objects.toArray();
    }
    
    // Tạo hàm tạo đối tượng và lưu giá trị vào đối tượng
    public void setValue(Object ...objs) {
        String fieldName = null;
        Object value = null;
        try {
            // duyệt qua các feild và gán giá trị cho nó vào đối tượng
            Field[] feilds = this.getClass().getDeclaredFields();
            Method[] methods = this.getClass().getMethods();
            for (int i = 0; i < feilds.length; i++) {
                fieldName = feilds[i].getName();
                fieldName = (fieldName.charAt(0) + "").toUpperCase()
                        + fieldName.substring(1, fieldName.length());
                String setMethodName  = "set" + fieldName;
                Method method = Arrays.stream(methods).filter(q -> q.getName().equals(setMethodName)).findFirst().orElse(null);
                value = objs[i];
                if (method != null) method.invoke(this, objs[i]);
            }
        } catch (SecurityException ex) {
            Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            System.err.println("Lỗi khi set giá trị cho trường " + fieldName + " giá trị " + value);
            //Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AbsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
