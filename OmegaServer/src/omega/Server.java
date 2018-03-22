/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            try {
                String encodeMessage = URLEncoder.encode(message.getContent(),
                        "UTF-8");
                String surl = "https://translate.googleapis.com/"
                        + "translate_a/single?client=gtx&sl="
                        + oneUser.getCredentials().getLanguage().getId()
                        + "&tl=" + message.getLanguage().getId()
                        + "&dt=t&q=" + encodeMessage;
                URL url = new URL(surl);
                URLConnection uc;
                uc = url.openConnection();
                uc.addRequestProperty("User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11"
                        + " (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                uc.connect();
                // Get translated message
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        uc.getInputStream()));
                String m = in.readLine();
                m = m.substring(m.indexOf("\"") + 1);
                m = m.substring(0, m.indexOf("\""));
                messageToSend.setContent(m);

            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

            oneUser.setSharedMessage(messageToSend);
        }
    }

    @Override
    public ArrayList<ClientInterface> getConnectedUsers() throws RemoteException {
        return this.users;
    }

}
