/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import omega.contracts.DullServer;

/**
 *
 * @author breno
 */
public class OmegaServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AlreadyBoundException {
        try {
            /*String address = (args.length < 1) ? "192.168.0.10" : args[0];
            System.setProperty("java.rmi.server.hostname", address);
            ServerInterface server = new Server(address);

            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://" + address + ":1099/server", server);

            System.err.println("Server ready");*/
            
            String address = "rmi://192.168.0.10:1099/dull";

            //ServerInterface server = new Server(address);
            DullServer serv = new DullServerImp();

            System.setProperty("java.rmi.server.hostname", "192.168.0.10");

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            registry.bind(address, serv);
            
            System.err.println("Server ready.");

        } catch (RemoteException ex) {
            Logger.getLogger(OmegaServer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

}
