/*
 * GLP-3.0 License.
 */
package omega.domain;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import omega.contracts.ClientInterface;
import omega.contracts.GUI;
import omega.contracts.ServerInterface;

/**
 *
 * @author Breno Viana
 * @author Murilo Bento
 */
public class Client extends UnicastRemoteObject implements ClientInterface {

    private ClientCredentials credentials;
    private ServerInterface server;
    private GUI ui;

    public Client(String nickname, String username, Language language, GUI ui) throws RemoteException {
        this.ui = ui;
        credentials = new ClientCredentials(nickname, username, language);
    }

    @Override
    public ClientCredentials getCredentials() throws RemoteException {
        return this.credentials;
    }

    @Override
    public void setLocalMessage(String localMessage) throws RemoteException {
        ui.showMessage(localMessage);
    }

    @Override
    public void setSharedMessage(Message message) throws RemoteException {
        ui.showMessage(message);
    }

    @Override
    public void setServer(ServerInterface server) throws RemoteException {
        this.server = server;
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        server.sendMessageToServer(new Message(this, message, this.getCredentials().getLanguage()));
    }
}
