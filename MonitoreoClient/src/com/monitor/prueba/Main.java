package com.monitor.prueba;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.rpc.ServiceException;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.api.jms.JMSFactoryType;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.jboss.ejb.client.ContextSelector;
import org.jboss.ejb.client.EJBClientConfiguration;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

import com.monitor.business.LibraryPersistentBeanRemote;
import com.monitor.business.PrimerBeanRemote;
import com.monitor.businesslogic.PrimerBean;
 
import com.monitor.webService.BeanWebService;
import com.monitor.webService.BeanWebServiceProxy;
import com.monitor.webService.Book;

import vos.VoBook;
 
 
 
public class Main {
     
    public static void main(String[] args) throws NamingException, JMSException {
     
    	//metodoRemoto();
    	//metodoPersistencia();
    	//metodoWBService();
    	metodoJMS();
    	metodoJMS2();
    
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


         System.out.println("INICIANDO ingreso de libros");
         ObjectMessage objectMessage = 
                 session.createObjectMessage("2");
         producer.send(objectMessage);
         System.out.println("Enviado");
         remoteQueueConnection.close();
	}

	private static void metodoWBService() {
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

	private static void metodoJMS() throws NamingException, JMSException {
	    
		TransportConfiguration transportConfiguration = 
                new TransportConfiguration(
        NettyConnectorFactory.class.getName());  
               
ConnectionFactory factory = (ConnectionFactory)
    HornetQJMSClient.createConnectionFactoryWithoutHA(
        JMSFactoryType.CF,
        transportConfiguration);
 
//The queue name should match the jms-queue name in standalone.xml
Queue queue = HornetQJMSClient.createQueue("testQueue");
Connection connection;
 
    connection = factory.createConnection();
    //http://stackoverflow.com/questions/9540456/javax-jms-jmssecurityexception-unable-to-validate-user-null
    Session session = connection.createSession(
                false,
                QueueSession.AUTO_ACKNOWLEDGE);
     
    MessageProducer producer = session.createProducer(queue);
     connection.start();
 
  
             System.out.println("INICIANDO ingreso de libros");
             ObjectMessage objectMessage = 
                     session.createObjectMessage("1");
             producer.send(objectMessage);
                  /*     Book book = new Book();
                   book.setName("LibroPorJMS5");
                   ObjectMessage objectMessage = 
                      session.createObjectMessage(book);
                   producer.send(objectMessage); 
                 
                   book = new Book();
                   book.setName("LibroPorJMS6");
                  objectMessage = 
                      session.createObjectMessage(book);
                  producer.send(objectMessage); 
                 */
             System.out.println("Libros");
                   final String earName = "tear"; // Nombre del módulo EAR
       			final String ejbModuleName = "PruebaEjb"; // Nombre del módulo EJB
       			final String distinctName = ""; // Opcional para resolver repeticiones en nombres
       			final String statefulEjbClassName = "LibraryPersistentBean"; // Nombre corto del EJB
       			final String statefulFullInterfaceName = LibraryPersistentBeanRemote.class.getName();
        
       			// 3. Lookup and cast
       			  String lookupName = "ejb:" + earName + "/" + ejbModuleName + "/" + 
       			            distinctName    + "/" + statefulEjbClassName + "!" + statefulFullInterfaceName;
             LibraryPersistentBeanRemote libraryBean = 
             (LibraryPersistentBeanRemote)
             connectEJB(lookupName);
     
             List<VoBook> booksList = libraryBean.getBooks();
     
             System.out.println("Book(s) entered so far: " + booksList.size());
             int i = 0;
             for (VoBook b:booksList) {
                System.out.println((i+1)+". " + b.getName());
                i++;
                        
    		    }
        
             connection.close();
}
   



	private static void metodoWebService() throws ServiceException, RemoteException {
     
    	 System.out.println("Iniciando Web Service");
  
    	com.monitor.webService.BeanService service=new com.monitor.webService.BeanServiceLocator()   ;
    	      BeanWebService port = 
    	         service.getBeanWebServicePort();
    	      for(Book book:port.getBooks()){
    	          System.out.println(book.getName());
    	   }

    	      System.out.println("Terminando Web Service");
    	      
    	}
		


	public static void metodoRemoto(){
            // 2. Generate JNDI Lookup name
			final String earName = "tear"; // Nombre del módulo EAR
			final String ejbModuleName = "PruebaEjb"; // Nombre del módulo EJB
			final String distinctName = ""; // Opcional para resolver repeticiones en nombres
			final String statefulEjbClassName = "PrimerBean"; // Nombre corto del EJB
			final String statefulFullInterfaceName = PrimerBeanRemote.class.getName();
 
			// 3. Lookup and cast
			  String lookupName = "ejb:" + earName + "/" + ejbModuleName + "/" + 
			            distinctName    + "/" + statefulEjbClassName + "!" + statefulFullInterfaceName;
			System.out.println(lookupName);
            PrimerBeanRemote bean = null;
			
				try {
					bean = (PrimerBeanRemote) connectEJB(lookupName);
					System.out.println(bean.saludar());
				 
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 
    }
    public static void metodoPersistencia()
    {
        // 2. Generate JNDI Lookup name
    			final String earName = "tear"; // Nombre del módulo EAR
    			final String ejbModuleName = "PruebaEjb"; // Nombre del módulo EJB
    			final String distinctName = ""; // Opcional para resolver repeticiones en nombres
    			final String statefulEjbClassName = "LibraryPersistentBean"; // Nombre corto del EJB
    			final String statefulFullInterfaceName = LibraryPersistentBeanRemote.class.getName();
     
    			// 3. Lookup and cast
    			  String lookupName = "ejb:" + earName + "/" + ejbModuleName + "/" + 
    			            distinctName    + "/" + statefulEjbClassName + "!" + statefulFullInterfaceName;
    			System.out.println(lookupName);
    			LibraryPersistentBeanRemote bean = null;
    			
    				try {
    					bean = (LibraryPersistentBeanRemote) connectEJB(lookupName);
    					System.out.println("PEPEPEP");
    					 bean.addBook(new VoBook("PRIMERO"));
    					 bean.addBook(new VoBook("Segundo"));
    					 bean.addBook(new VoBook("Tercero"));
    					 bean.addBook(new VoBook("Cuarto"));
    					 bean.addBook(new VoBook("Quinto"));
    					 System.out.println("SE AGREGARON LOS LIBROS");
    					 for(VoBook v :bean.getBooks())
    					 {
    						 System.out.println(v.getName());
    					 }
    					 System.out.println("TERMINO");
    				 
    				} catch (NamingException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				 
    }
    
			
 
 
        
    
    public static <T> T connectEJB(String jndi) throws NamingException {
        Properties clientProperties = new Properties();
      
  	  clientProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
	  clientProperties.put("remote.connections", "default");
	  clientProperties.put("remote.connection.default.port", "8080");
	clientProperties.put("remote.connection.default.host", "localhost");
	   clientProperties.put("remote.connection.default.username", "user");
	  clientProperties.put("remote.connection.default.password", "user");
	  clientProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
	 
        EJBClientConfiguration ejbClientConfiguration = new PropertiesBasedEJBClientConfiguration(clientProperties);
        ContextSelector<EJBClientContext> contextSelector = new ConfigBasedEJBClientContextSelector(ejbClientConfiguration);
        EJBClientContext.setSelector(contextSelector);

        Properties properties = new Properties();
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(properties);
        return (T) context.lookup(jndi);
    }
   
}