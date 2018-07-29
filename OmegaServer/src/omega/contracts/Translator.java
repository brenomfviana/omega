/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.contracts;

import java.io.IOException;
import omega.domain.Language;
import omega.domain.Message;

/**
 * Interface that represents a translator.
 * 
 * @author mourilo
 */
public interface Translator {
	/**
	 * Translates a message.
	 * 
	 * @param message The source message.
	 * @param translateTo The destination language.
	 * @return A string containing the translated message.
	 * @throws IOException
	 */
    public String translateMessage(Message message, Language translateTo) throws IOException;
}