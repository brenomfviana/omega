/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega;

import omega.services.ChatGUI;

/**
 *
 * @author breno
 */
public class OmegaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChatGUI cgui = new ChatGUI();
        cgui.run();
    }

}
