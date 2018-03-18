/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.omega.domain;

/**
 *
 * @author mourilo
 */
public class ClientCredentials {
    // Nickname
    private String nickname;
    // Username
    private String username;
    // Language
    private Language language;
    
    public ClientCredentials(String nickname, String username, Language language){
        this.nickname = nickname;
        this.username = username;
        this.language = language;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
