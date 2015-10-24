package com.monitor.businesslogic;

import com.monitor.business.PrimerBeanRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PrimerBean
 */
@Stateless
@LocalBean
public class PrimerBean implements PrimerBeanRemote {

    /**
     * Default constructor. 
     */
    public PrimerBean() {
        // TODO Auto-generated constructor stub
    }
    public String saludar() {
        return "Hello World !!!";
    }
}
