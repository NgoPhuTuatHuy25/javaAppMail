package RMI;


import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
    
  
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://node23854-logindb.kilatiron.com/logindb", "root", "DXOdlc38707");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}
