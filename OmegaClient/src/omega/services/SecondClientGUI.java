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
public class SecondClientGUI {

    private Client client;
    private ServerInterface server;

    public void doConnect(String host, String port) {
        try {
            System.setProperty("java.rmi.server.hostname", host);

            this.server = (ServerInterface) Naming.lookup("rmi://" + host + ":" + port + "/server");
            
            this.client = new Client("brenov", "BReno", Language.BRAZILIAN_PORTUGUESE, new TestGUI());

            System.out.println("Connected: " + server.login(client));
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }

    public void sendText(String text) {
        try {
            server.sendMessageToServer(new Message(client, text));
        } catch (RemoteException ex) {
            Logger.getLogger(SecondClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        SecondClientGUI u = new SecondClientGUI();
        u.doConnect("192.168.0.26", "1099");
        u.sendText("Olá, seu lixo!");
    }
}

