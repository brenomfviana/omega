package omega;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import omega.contracts.ServerInterface;

/**
 * Class that contains the main method.
 * 
 * @author murilobnt
 * @author brenov
 */
public class OmegaServer {

    /**
     * Main method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        	// Set the address. If nothing is passed, it will use 127.0.0.1 (not recommended).
        	String address = (args.length < 1) ? "127.0.0.1" : args[0];
        	
        	// Create an instance of the Server and bind it to a registry.
        	String bindingAddress = "rmi://" + address + ":1099/server";
            ServerInterface server = new Server(address);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind(bindingAddress, server);
            
            // Print the status on err.
            System.err.println("Server ready");

        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(OmegaServer.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

}