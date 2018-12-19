
package giaoDien.Sever.Client;

import RMI.serverimpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server_RMI {
public void RunServer(){
        try {
            Registry r = LocateRegistry.createRegistry(1010);
            serverimpl se = new serverimpl();
            r.rebind("RMI", se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
