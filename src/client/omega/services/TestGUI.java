/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.omega.services;

import client.omega.domain.Message;
import interfaces.GUI;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author mourilo
 */
public class TestGUI implements GUI, Serializable{

    @Override
    public void showMessage(Message message) {
        try {
            System.out.println(message.getSender().getCredentials().getNickname() + " says: " + message.getContent());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
    
}