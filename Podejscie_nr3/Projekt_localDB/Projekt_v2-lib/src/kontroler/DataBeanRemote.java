/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import javax.ejb.Remote;

/**
 *
 * @author student
 */
@Remote
public interface DataBeanRemote {

    String calculateHash(String string);

    boolean addToDB(String Hashed);
    
}
