/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import omega.contracts.ServerInterface;

/**
 *
 * @author breno
 */
public class OmegaServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String address = (args.length < 1) ? "127.0.0.1" : args[0];
            System.setProperty("java.rmi.server.hostname", address);
            ServerInterface server = new Server(address);

            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://" + address + ":1099/server", server);

            System.err.println("Server ready");

        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(OmegaServer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

}
