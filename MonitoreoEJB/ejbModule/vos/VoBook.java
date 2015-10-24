package vos;

import java.io.Serializable;

public class VoBook implements Serializable{
 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
   private String name;
 

	public VoBook(String string) {
	name=string;
}

	public VoBook() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
