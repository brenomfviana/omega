/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import client.omega.domain.Message;
import client.omega.domain.ClientCredentials;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author mourilo
 */
public interface ClientInterface extends Remote {
    public void setLocalMessage(String message) throws RemoteException;
    public void setSharedMessage(Message message) throws RemoteException;
    public void setServer(ServerInterface server) throws RemoteException;
    public void sendMessage(String message) throws RemoteException;
    public ClientCredentials getCredentials() throws RemoteException;
}
