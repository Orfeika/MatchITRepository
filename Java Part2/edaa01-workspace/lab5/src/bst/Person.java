package bst;

public class Person implements Comparable<Person> {
private String name; 
private int id;

public Person(String name, int id) {
	super();
	this.name = name;
	this.id = id;
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



@Override
public int compareTo(Person o) {
	return Integer.compare(this.id, o.id);
} 



@Override
public String toString() {
	return   name + " " + id ;
}

	
}
