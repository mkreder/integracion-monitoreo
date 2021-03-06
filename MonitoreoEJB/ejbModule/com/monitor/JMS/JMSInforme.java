package com.monitor.JMS;

import java.io.IOException;
import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.monitor.Fachada.IFachada;

import dominio.InformeDeAuditoria;
import vos.LogDTO;
 

/**
 * Message-Driven Bean implementation class for: JMSInforme
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "queue/BookQueue")
		}, 
		mappedName = "colaInformeAuditoria")
public class JMSInforme implements MessageListener {

	@EJB
	IFachada fachada;
	
    public JMSInforme() {
    }
	
    public void onMessage(Message message) {
    	System.out.println("----------- Se recibio un mensaje de nuevo informe de auditoria -----------");
        try {
        	
        	ObjectMessage objectMessage = (ObjectMessage) message;

        	ClassLoader originalTCCL = Thread.currentThread().getContextClassLoader();
        	try
        	{
        		// temporarily change TCCL, just for testing
        		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        		// now get the message from ObjectMessage
        		String voInformeAuditoria =String.valueOf(objectMessage.getObject());
        		LogDTO informeAuditoria = new LogDTO();
        		String[] i =voInformeAuditoria.split("_");
        		informeAuditoria.setIdModulo(i[0]);
        		informeAuditoria.setMensaje(i[1]);
        	
        		System.out.println("LA FECHA EN LA QUE SE RECIBIO ES:"+new Date());
    			fachada.generarInformeAuditoria(informeAuditoria);
    			System.out.println("----------- Se realiz� el informe correctamente -----------");
        	}
        	finally
        	{
        		// set back the original TCCL
        		Thread.currentThread().setContextClassLoader(originalTCCL);
        	}
        	
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------- Error al realizar el informe de auditor�a -----------");
			System.out.println(e.getMessage());
		}
    }
    
      

}
