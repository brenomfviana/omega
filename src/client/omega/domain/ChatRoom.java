/*
 * GLP-3.0 License.
 */
package client.omega.domain;

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
    private Client owner;
    // List of users
    private List<Client> users;

    public ChatRoom(String className, Client owner) {
        this.className = className;
        this.owner = owner;
    }

    public ChatRoom(String className, Client owner, List<Client> users) {
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

    public Client getOwner() {
        return owner;
    }

    public List<Client> getUsers() {
        return users;
    }

    public void addUser(Client client) {
        this.users.add(client);
    }

    public void removeUser(Client client) {
        this.users.add(client);
    }
}
