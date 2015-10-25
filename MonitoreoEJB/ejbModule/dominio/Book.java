package dominio;

import java.io.Serializable;

import javax.persistence.*;
 

@Entity
@Table(name="bohoks")
public class Book implements Serializable{
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
   private String name;

   public Book(){        
   }

   public Book(String name2) {
	name=name2;
}

//mark id as primary key with autogenerated value
   //map database column id with id field
   @Id @GeneratedValue(strategy=GenerationType.AUTO)
   public int getId() {
      return id;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public void setId(int id) {
	this.id = id;
}
}