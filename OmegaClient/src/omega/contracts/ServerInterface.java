/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.contracts;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import omega.domain.Message;

/**
 *
 * @author mourilo
 */
public interface ServerInterface extends Remote {

    public boolean login(ClientInterface clientInterface) throws RemoteException;
    
    public boolean disconnect(ClientInterface clientInterface) throws RemoteException;

    public void sendMessageToServer(Message message) throws RemoteException;

    public ArrayList<ClientInterface> getConnectedUsers() throws RemoteException;
}
