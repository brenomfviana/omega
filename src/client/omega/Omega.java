/*
 * GLP-3.0 License.
 */
package client.omega;

import client.omega.services.ChatGUI;

/**
 *
 * @author Breno Viana
 * @author Murilo Bento
 */
public class Omega {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ChatGUI cgui = new ChatGUI();
        cgui.run();
    }
}