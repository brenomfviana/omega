/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omega.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import omega.contracts.Translator;

/**
 *
 * @author mourilo
 */
public class GoogleTranslator implements Serializable, Translator {
    private String encodeMessage;
    private String surl;
    private URL url;
    private URLConnection uc;
    private BufferedReader in;
    
    @Override
    public String translateMessage(Message message, Language translateTo) throws IOException {
        encodeMessage = URLEncoder.encode(message.getContent(),
                "UTF-8");
        surl = "https://translate.googleapis.com/"
                + "translate_a/single?client=gtx&sl="
                + message.getLanguage().getId()
                + "&tl=" + translateTo.getId()
                + "&dt=t&q=" + encodeMessage;
        url = new URL(surl);
        uc = url.openConnection();
        uc.addRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11"
                + " (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        uc.connect();
        // Get translated message
        in = new BufferedReader(new InputStreamReader(
                uc.getInputStream()));
        
        String m = in.readLine();
        String fullMessage = "";
        int index;
        
        m = m.substring(m.indexOf("\"") + 1);
        fullMessage = fullMessage.concat(m.substring(0, m.indexOf("\"")));
        
        while((index = m.indexOf("[")) != -1){
            m = m.substring(index + 2);
            fullMessage = fullMessage.concat(m.substring(0, m.indexOf("\"")));
        }
        
        return fullMessage;
    }
    
}
