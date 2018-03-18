/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.omega.domain.Message;
import interfaces.ServerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import interfaces.ClientInterface;

/**
 *
 * @author breno
 */
public class Server extends UnicastRemoteObject implements ServerInterface{
    
    private ArrayList<ClientInterface> users;
    private String address;
    
    public Server(String address) throws RemoteException{
        super();
        users = new ArrayList<>();
        this.address = address;
    }
    
    @Override
    public boolean login(ClientInterface clientInterface) throws RemoteException {
        // Auth goes here.
        // Message of "You're connected" goes here.
        users.add(clientInterface);
        clientInterface.setServer(this);
        return true;
    }
    
    @Override
    public void sendMessageToServer(Message message) throws RemoteException {
        for(ClientInterface oneUser : users){
            Message messageToSend = message;
            
            if(message.getLanguage() != oneUser.getCredentials().getLanguage()){
                // Translation here. Only modify messageToSend's content, not its original language.
                // Example: messageToSend.setContent(translatedMessage);
            }
                
            oneUser.setSharedMessage(messageToSend);
        }
    }
    
    @Override
    public ArrayList<ClientInterface> getConnectedUsers() throws RemoteException {
        return this.users;
    }
    
}
