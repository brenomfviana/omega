/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import client.omega.domain.Message;

/**
 *
 * @author mourilo
 */
public interface GUI {
    void showMessage(Message message);
    void showMessage(String message);
}
