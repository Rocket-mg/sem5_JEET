/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author student
 */
public class dataBean implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String przykladowaDana;
    
    private PropertyChangeSupport propertySupport;
    
    public dataBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getPrzykladowaDana() {
        return przykladowaDana;
    }
    
    public void setPrzykladowaDana(String value) {
        String oldValue = przykladowaDana;
        przykladowaDana = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, przykladowaDana);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public String Dopisz(String argument) {
        return przykladowaDana + argument;
    }

    
}
