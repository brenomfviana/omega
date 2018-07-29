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
 * Interface that represents the server. It uses Java RMI.
 * 
 * @author murilobnt
 */
public interface ServerInterface extends Remote {
	/**
	 * Logs the client into the server.
	 * 
	 * @param clientInterface The client to be logged in.
	 * @return The status of the operation.
	 * @throws RemoteException An exception about Java RMI.
	 */
    public boolean login(ClientInterface clientInterface) throws RemoteException;
    
    /**
     * Disconnects a client from the server.
     * 
     * @param clientInterface The client to be disconnected.
     * @return The status of the operation.
     * @throws RemoteException An exception about Java RMI.
     */
    public boolean disconnect(ClientInterface clientInterface) throws RemoteException;
    
    /**
     * Sends a message to the server.
     * 
     * @param message The message to be sent.
     * @throws RemoteException An exception about Java RMI.
     */
    public void sendMessageToServer(Message message) throws RemoteException;
    
    /**
     * Gets the connected users in the server.
     * 
     * @return The ArrayList containing every connected users.
     * @throws RemoteException An exception about Java RMI.
     */
    public ArrayList<ClientInterface> getConnectedUsers() throws RemoteException;
}
