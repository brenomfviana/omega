/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import omega.contracts.ClientInterface;
import omega.contracts.ServerInterface;
import omega.domain.GoogleTranslator;
import omega.domain.Message;

/**
 *
 * @author breno
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

    private ArrayList<ClientInterface> users;
    private GoogleTranslator googleTranslator;

    public Server(String address) throws RemoteException {
        super();
        users = new ArrayList<>();
        googleTranslator = new GoogleTranslator();
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
    public boolean disconnect(ClientInterface clientInterface) throws RemoteException {
        return users.remove(clientInterface);
    }

    @Override
    public void sendMessageToServer(Message message) throws RemoteException {
        for (ClientInterface oneUser : users) {
            Message messageToSend = new Message(message);

            if (!message.getLanguage().equals(oneUser.getCredentials()
                    .getLanguage())) {
                try {
                    messageToSend.setContent(googleTranslator
                            .translateMessage(message, oneUser
                                    .getCredentials().getLanguage()));
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }

            oneUser.setSharedMessage(messageToSend);
        }
    }

    @Override
    public ArrayList<ClientInterface> getConnectedUsers() throws RemoteException {
        return this.users;
    }

}
