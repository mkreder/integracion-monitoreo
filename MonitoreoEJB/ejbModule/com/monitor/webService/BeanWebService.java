package com.monitor.webService;

import java.util.List;

import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.*;

import com.monitor.webServiceInterface.BeanWebServiceRemote;

import dominio.Book;
 

@Stateless
@WebService(serviceName="BeanService")
public class BeanWebService implements  BeanWebServiceRemote {
	    
	   public BeanWebService(){
	   }

	   @PersistenceContext(unitName="CRM")
	   private EntityManager entityManager;         
	   @Override
	   public void addBook(Book book) {
	      entityManager.persist(book);
	   }    
	   @Override
	   @WebMethod(operationName="getBooks")
	   public List <Book> getBooks() {
	      return entityManager.createQuery("From Book").getResultList();
	   }
}
