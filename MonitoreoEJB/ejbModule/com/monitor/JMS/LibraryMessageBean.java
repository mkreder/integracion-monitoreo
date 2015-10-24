package com.monitor.JMS;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.monitor.business.LibraryPersistentBeanRemote;

import dominio.Book;
import vos.VoBook;

@MessageDriven(
		   name = "BookMessageHandler",
		   activationConfig = {
		      @ActivationConfigProperty( propertyName = "destinationType", 
		                                 propertyValue = "javax.jms.Queue"),
		      @ActivationConfigProperty( propertyName = "destination", 
		                                 propertyValue ="/queue/BookQueue222")
		   }
		)
		public class LibraryMessageBean implements MessageListener {
		 
		   @Resource
		   private MessageDrivenContext mdctx;  
		 
		   @EJB
		   LibraryPersistentBeanRemote libraryBean;
		 
		   public LibraryMessageBean(){        
		   }
		 

		   public void onMessage(Message message) {
			   ObjectMessage objectMessage = (ObjectMessage)message;
			   String a;
			try {
				a = (String) objectMessage.getObject();
				System.out.println("PEPEPEPEPPEPEPEPPEPEPEPEPEPEPPPPPPPPPPPPPPPPPPPPPP: "+ a);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
		 /*     ObjectMessage objectMessage = null;
		      try {
		         objectMessage = (ObjectMessage) message;
		         VoBook book = (VoBook) objectMessage.getObject(); 
		         libraryBean.addBook(book);
		 
		      } catch (JMSException ex) {
		         mdctx.setRollbackOnly();
		      }   */    
		   }  
		}
