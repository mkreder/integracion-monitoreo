package com.monitor.businesslogic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.monitor.business.LibraryPersistentBeanRemote;

import dominio.Book;
import vos.VoBook;

/**
 * Session Bean implementation class LibraryPersistentBean
 */
@Stateless
@LocalBean
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

	  @PersistenceContext(unitName="CRM")
	   private EntityManager entityManager;         
	  @Override
	   public void addBook(VoBook book) {
		  Book b=new Book(book.getName());
	      entityManager.persist(b);
	   }    

	   @SuppressWarnings("unchecked")
	   @Override
	public List<VoBook> getBooks() {    
		   List<VoBook> lista =new ArrayList<VoBook>();
		   VoBook v=new VoBook();
		   List<Book> books=(List<Book>)entityManager.createQuery("From Book").getResultList();
	      for(Book b: books)
	      {
	    	  v=new VoBook(b.getName());
	    	  lista.add(v);
	      }
	      return lista;
	   }
	  
	}