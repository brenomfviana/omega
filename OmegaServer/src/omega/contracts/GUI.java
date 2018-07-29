/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.contracts;

import omega.domain.Message;

/**
 * An interface representing the GUI of some user.
 * The user will have a reference to an implementation
 * of this interface, so it can be called remotely.
 * 
 * @author murilobnt
 */
public interface GUI {
	/**
	 * Display a message.
	 * 
	 * @param message The message sent.
	 */
    void showMessage(Message message);
    
    /**
     * Display a text-only message.
     * @param message The text-only message sent.
     */
    void showMessage(String message);
}
