
package RMI;
import java.rmi.*;

public interface rmiClient extends Remote {
    public boolean login(String user, String pass) throws RemoteException;
    public boolean dangki(String tendangnhap, String matkhau, String xnmk) throws RemoteException;
}
