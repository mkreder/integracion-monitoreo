package com.monitor.business;

import java.util.List;

import javax.ejb.Remote;

import vos.VoBook;

@Remote
public interface LibraryPersistentBeanRemote {

	void addBook(VoBook book);

	List<VoBook> getBooks();

}
