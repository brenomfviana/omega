/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.omega.domain;

import interfaces.ClientInterface;
import java.io.Serializable;

/**
 *
 * @author mourilo
 */
public class Message implements Serializable{
    
    private ClientInterface sender;
    private String content;
    private Language language;
    
    public Message(ClientInterface sender, String content, Language language){
        this.sender = sender;
        this.content = content;
        this.language = language;
    }
    
    public ClientInterface getSender() {
        return sender;
    }

    public void setSender(ClientInterface sender) {
        this.sender = sender;
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
