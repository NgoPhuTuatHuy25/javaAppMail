
package RMI;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import jdk.nashorn.internal.ir.BreakNode;



public class serverimpl extends UnicastRemoteObject implements rmiClient{
    private Connection con;
   // private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public  serverimpl() throws RemoteException{
    }   
    

    public boolean login(String user, String pass) throws RemoteException {
        boolean f =false;
        String query = "SELECT * FROM dangnhap WHERE user = ? AND pass=?";
        try {
            
            pstmt = MyConnection.getConnection().prepareStatement(query);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();

            if(rs.next()){
                   return f =true;
            }else{
                    return f=false;
                    
            }
           
          } catch (Exception e) {
              e.printStackTrace();
          }        
          return f;
    }
   public boolean dangki(String tendangnhap, String matkhau, String xnmk) throws  RemoteException{
   //   boolean f =false;
    String query ="insert into dangnhap values(?, ?, ?)";
       try {
            pstmt = MyConnection.getConnection().prepareStatement(query);
            
            pstmt.setString(1, tendangnhap);
            pstmt.setString(2, matkhau);
            pstmt.setString(3, xnmk);
            pstmt.execute();
            pstmt.close();
       }catch(Exception ex){
           ex.printStackTrace();
       }
//       return f;
        return false;
   }
}
