/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebj;

import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author student
 */
@Stateless
public class DataAccessBean implements DataAccessBeanRemote {
    private String OstatnieDane;
    private Date  OstatniDostep;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getOstatnieDane() {
       return OstatniDostep + "\n" + OstatnieDane;
    }

    @Override
    public void setOstatnieDane(String dane, Date data) {
        OstatnieDane = dane;        
        OstatniDostep = data;
    }
    
}
