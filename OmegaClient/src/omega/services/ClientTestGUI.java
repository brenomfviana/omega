/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.services;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import omega.domain.Client;
import omega.domain.Language;
import omega.domain.Message;
import omega.contracts.ServerInterface;

/**
 *
 * @author mourilo
 */
public class ClientTestGUI {

    private Client client;
    private ServerInterface server;

    public void doConnect(String host, String port) {
        try {
            System.setProperty("java.rmi.server.hostname", host);

            this.server = (ServerInterface) Naming.lookup("rmi://" + host + ":" + port + "/server");
            
            this.client = new Client("mourilo", "murilao", Language.ENGLISH, new TestGUI());

            System.out.println("Connected: " + server.login(client));
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }

    public void sendText(String text) {
        try {
            server.sendMessageToServer(new Message(client, text, Language.BRAZILIAN_PORTUGUESE));
        } catch (RemoteException ex) {
            Logger.getLogger(ClientTestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ClientTestGUI u = new ClientTestGUI();
        u.doConnect("10.7.124.37", "1099");
        u.sendText("Hello world!");
    }
}
