
package Demo_App_Mail;


import RMI.serverimpl;
import giaoDien.Sever.Client.Client__Login_JFrame;
import giaoDien.Sever.Client.Server_RMI;
import giaoDien.Sever.Client.Server_RMI_Jframe;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Server_Loading_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Server_RMI_Jframe l = new Server_RMI_Jframe();
        Client__Login_JFrame cl = new Client__Login_JFrame();
        Server_RMI server_RMI = new Server_RMI();
        l.setVisible(true);
        l.setLocationRelativeTo(null);
        l.setDefaultCloseOperation(l.EXIT_ON_CLOSE);
 
        try{
            server_RMI.RunServer();
            l.jLabel3.setText("Đang chờ kết nối từ Client");
           
            for(int i=0; i<=100; i++){
                Thread.sleep(40);
                l.jLabel2.setText(Integer.toString(i)+"%");
                l.jProgressBar1.setValue(i);

            if(i==100){
                l.jLabel3.setText("Đã kết nối với Client");             
                new java.util.Timer().schedule(new TimerTask(){
                @Override
                public void run() {
                    l.dispose();
                    cl.show();
                }
                   
                },500*5);
              
            }
            
            }
        }catch(Exception ex){
            
           JOptionPane.showMessageDialog(null, "Error");
        }
    }
     
}
