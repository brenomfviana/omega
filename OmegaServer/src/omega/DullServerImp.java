/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import omega.contracts.DullServer;

/**
 *
 * @author mourilo
 */
public class DullServerImp extends UnicastRemoteObject implements DullServer {
    
    public DullServerImp() throws RemoteException{
        super();
    }
    
    @Override
    public void sayHello() throws RemoteException {
        System.out.println("Hello");
    }
    
}
