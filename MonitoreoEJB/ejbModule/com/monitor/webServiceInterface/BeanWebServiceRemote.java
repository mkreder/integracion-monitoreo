package com.monitor.webServiceInterface;

import java.util.List;

import dominio.Book;

public interface BeanWebServiceRemote {

	List<Book> getBooks();

	void addBook(Book book);

}
