/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.ServerInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mourilo
 */
public class ServerStarter {
    public static void main(String[] args){
        try{
            String address = "10.7.124.11";
            System.setProperty("java.rmi.server.hostname", address);
            ServerInterface server = new Server(address);
            
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://" + address + ":1099/server", server);

            System.err.println("Server ready");
            
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(ServerStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
