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
 *
 * @author mourilo
 */
public interface Translator {
    public String translateMessage(Message message, Language translateTo) throws IOException;
}