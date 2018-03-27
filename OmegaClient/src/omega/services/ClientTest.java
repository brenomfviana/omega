/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.services;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import omega.contracts.DullServer;

/**
 *
 * @author mourilo
 */
public class ClientTest {
    public static void main(String[] args){
        try {
            DullServer dullserv;
            Registry registry = LocateRegistry.getRegistry("192.168.0.21", 1099);
            
            String address = "rmi://192.168.0.21:1099/dull";
            
            /*this.server = (ServerInterface) Naming.lookup("rmi://"
            + host + ":" + port + "/server");*/
            
            System.out.println("Chegou aqui");
            
            dullserv = (DullServer) registry.lookup(address);
            
            System.out.println("Não chegou aqui");
            
            dullserv.sayHello();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
