/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author student
 */
@Stateless
public class DataBean implements DataBeanRemote {
    private String hash_string;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String calculateHash(String string) {
        //MessageDigest md = new MD6();
        byte[] bytesOfMessage;
        String calculated = null;
        try {
            bytesOfMessage = string.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5"); //niestety nie mogłam znaleźć implementacji md6, więc zrobiłam md5
            byte[] theMD6digest = md.digest(bytesOfMessage);
            String hashedOutput = DatatypeConverter.printHexBinary(theMD6digest);
            //calculated = new String(theMD6digest);
            calculated = hashedOutput;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DataBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DataBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calculated;
    }

    @Override
    public boolean addToDB(String Hashed) {
        
        return false;
    }
    
    
    
}
