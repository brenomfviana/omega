/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.omega.services;

import client.omega.domain.Client;
import client.omega.domain.Language;
import client.omega.domain.Message;
import interfaces.ServerInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mourilo
 */
public class ClientTestGUI {
    private Client client;
    private ServerInterface server;
    
    public void doConnect(String host, String port){
         try {
            System.setProperty("java.rmi.server.hostname", host);
            this.client = new Client("mourilo", "murilao", Language.BRAZILIAN_PORTUGUESE, new TestGUI());
            
            this.server = (ServerInterface)Naming.lookup("rmi://" + host + ":" + port + "/server");
            
            System.out.println("Connected: " + server.login(client));
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
    
    public void sendText(String text){
        try {
            server.sendMessageToServer(new Message(client, text, client.getCredentials().getLanguage()));
        } catch (RemoteException ex) {
            Logger.getLogger(ClientTestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        ClientTestGUI u = new ClientTestGUI();
        u.doConnect("10.7.124.11", "1099");
        u.sendText("Hello world!");
    }
}
