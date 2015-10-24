package com.monitor.prueba;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.rpc.ServiceException;

import com.monitor.webService.BeanWebService;
import com.monitor.webService.Book;
import com.monitor.webService.VoInformeDeAuditoria;
import com.monitor.webService.VoVenta;
import com.monitor.webService.WSInformeAuditoriaBean;
import com.monitor.webService.WSProcVentaBean;

public class TestTPO {

	public static void main(String[] args) throws NamingException, JMSException {
		// TODO Auto-generated method stub
		metodoJMS2();
try {
	metodoWebService();
} catch (RemoteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ServiceException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	

	private static void metodoWebService() throws ServiceException, RemoteException {
		 
		     
	    	 System.out.println("Iniciando Web Service Venta");
	  
	    	com.monitor.webService.WSProcVentaBeanService service=new com.monitor.webService.WSProcVentaBeanServiceLocator()   ;
	    	      WSProcVentaBean port = 
	    	         service.getWSProcVentaBeanPort();
	    	     port.procesarVenta(new VoVenta());

	    	      System.out.println("Terminando Web Service");
	    			 
	 		     
	 	    	 System.out.println("Iniciando Web Service Auditoria");
	 	  
	 	    	com.monitor.webService.WSInformeAuditoriaBeanService service2=new com.monitor.webService.WSInformeAuditoriaBeanServiceLocator()   ;
	 	    	      WSInformeAuditoriaBean port2 = 
	 	    	         service2.getWSInformeAuditoriaBeanPort();
	 	    	     VoInformeDeAuditoria ej= new VoInformeDeAuditoria();
	 	    	     ej.setDescripcion("Prueba2");
	 	    	     ej.setFechaYHora(14);
	 	    	     ej.setModulo("modulo2");
	 	    	     port2.agregarInforme(ej);
	 	    	      System.out.println("Terminando Web Service");
	    	      
	    	}
	 private static void metodoJMS2() throws NamingException, JMSException { 
	    	Properties props = new Properties();
	    props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");

	    // The URL below should point to the your instance of Server 1, if no
	    // port offset is used for Server 1 the port can remain at 4447
	    props.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");

	    // Credentials are required when the security is enabled (default behavior) on the HornetQ server 
	    //props.put(Context.SECURITY_PRINCIPAL, "user");
	    //props.put(Context.SECURITY_CREDENTIALS, "user");

	    InitialContext ic = new InitialContext(props);	
	    
	    ConnectionFactory remoteQueueCF = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
	    Queue remoteQueue = (Queue) ic.lookup("jms/queue/BookQueue");

	    // You would have to provide the same username/password combination to create a connection
	    // when the security is enabled on the HornetQ server
	    Connection remoteQueueConnection = remoteQueueCF.createConnection();
	    remoteQueueConnection.start();

	     
	    Session session = remoteQueueConnection.createSession(
	            false,
	            QueueSession.AUTO_ACKNOWLEDGE);
	 
	MessageProducer producer = session.createProducer(remoteQueue);
	

	         System.out.println("INICIANDO ingreso de Informes");
	         VoInformeDeAuditoria ej= new VoInformeDeAuditoria();
		     ej.setDescripcion("PruebaJMS");
		     ej.setFechaYHora(12);
		     ej.setModulo("moduloJMS");
	         ObjectMessage objectMessage = 
	                 session.createObjectMessage(ej);
	         producer.send(objectMessage);
	         System.out.println("Enviado");
	         remoteQueueConnection.close();
		}
		
	}

