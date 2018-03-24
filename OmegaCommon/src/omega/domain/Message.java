/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.domain;

import java.io.Serializable;
import java.rmi.RemoteException;
import omega.contracts.ClientInterface;

/**
 *
 * @author mourilo
 */
public class Message implements Serializable {

    private ClientInterface sender;
    private String originalContent;
    private String content;
    private Language language;

    public Message(ClientInterface sender, String content) throws RemoteException {
        this.sender = sender;
        this.originalContent = content;
        this.content = content;
        this.language = sender.getCredentials().getLanguage();
    }
    
    public Message(Message message){
        this.sender = message.sender;
        this.content = message.content;
        this.language = message.language;
    }

    public ClientInterface getSender() {
        return sender;
    }

    public void setSender(ClientInterface sender) {
        this.sender = sender;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
