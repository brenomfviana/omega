/*
 * GLP-3.0 License.
 */
package omega.domain;

import java.util.List;

/**
 *
 * @author Breno Viana
 * @author Murilo Bento
 */
public class ChatRoom {
    
    // Class name
    private String className;
    // Chat room owner
    private User owner;
    // List of users
    private List<User> users;

    public ChatRoom(String className, User owner) {
        this.className = className;
        this.owner = owner;
    }

    public ChatRoom(String className, User owner, List<User> users) {
        this.className = className;
        this.owner = owner;
        this.users = users;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public User getOwner() {
        return owner;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.add(user);
    }
}
