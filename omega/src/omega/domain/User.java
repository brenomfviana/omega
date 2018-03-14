/*
 * GLP-3.0 License.
 */
package omega.domain;

/**
 *
 * @author Breno Viana
 * @author Murilo Bento
 */
public class User {

    // Nickname
    private String nickname;
    // Username
    private String username;
    // Language
    private Language language;

    public User(String nickname, String username, Language language) {
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
