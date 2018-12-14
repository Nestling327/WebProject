package javademo.DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
    private static final String URL ="jdbc:mysql://localhost:3306/cztongxun";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection con = null;
    private static final String User ="root";
    private static final String password = "weareking5752";
    static {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL,User,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        return con;
    }
}
