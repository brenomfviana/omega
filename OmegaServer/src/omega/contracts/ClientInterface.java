/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.contracts;

import java.rmi.Remote;
import java.rmi.RemoteException;
import omega.domain.ClientCredentials;
import omega.domain.Message;

/**
 * Interface that represents some user. It uses Java RMI.
 * 
 * @author murilobnt
 */
public interface ClientInterface extends Remote {
	
	/**
	 * Sets a message in user's chat window that only themselves can see.
	 * 
	 * @param message The message to be shown.
	 * @throws RemoteException An exception about Java RMI.
	 */
    public void setLocalMessage(String message) throws RemoteException;
    
    /**
     * Sets a message in every users' chat windows.
     * 
     * @param message The message to be shown.
     * @throws RemoteException An exception about Java RMI.
     */
    public void setSharedMessage(Message message) throws RemoteException;
    
    /**
     * Sets the server for this chat.
     * 
     * @param server The server the chat will be calling.
     * @throws RemoteException An exception about Java RMI.
     */
    public void setServer(ServerInterface server) throws RemoteException;
    
    /**
     * Sends a message to everyone.
     * 
     * @param message The message to be sent.
     * @throws RemoteException An exception about Java RMI.
     */
    public void sendMessage(String message) throws RemoteException;
    
    /**
     * Returns the client credentials.
     * @return The client credentials.
     * @throws RemoteException An exception about Java RMI.
     */
    public ClientCredentials getCredentials() throws RemoteException;
}
