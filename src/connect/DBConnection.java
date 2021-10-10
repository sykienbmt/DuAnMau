package connect;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class DBConnection {
    private static String driver = ("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
    private static String connectionUrl = "jdbc:sqlserver://localhost;database=Java;";
    private static String username = "sa";
    private static String password = "123456";
    
    static{
        try {
            Class.forName(driver);
        } 
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static PreparedStatement prepareStatement(String sql, Object...args) throws SQLException{
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        PreparedStatement pstmt = null;
        if(sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);
        }
        else{
            pstmt = connection.prepareStatement(sql);
            System.out.println(pstmt.toString());
        }
        for(int i=0;i<args.length;i++){
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }
    
    public static void executeUpdate(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            System.out.println(stmt.toString());
            try {
                stmt.executeUpdate();
            } 
            finally{
                stmt.getConnection().close();
            }
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet executeQuery(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
