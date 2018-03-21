/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import omega.contracts.ClientInterface;
import omega.contracts.ServerInterface;
import omega.domain.Message;

/**
 *
 * @author breno
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

    private ArrayList<ClientInterface> users;

    public Server(String address) throws RemoteException {
        super();
        users = new ArrayList<>();
        System.setProperty("java.rmi.server.hostname", address);
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
        for (ClientInterface oneUser : users) {
            Message messageToSend = message;

            if (message.getLanguage() != oneUser.getCredentials().getLanguage()) {
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
