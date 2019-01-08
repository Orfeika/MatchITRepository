package bst;
import bst.Person;

public class Student extends Person{
	private String name;
	private int id;
	private String subject;

	public Student(String name, int id, String subject) {
		super(name, id);
		this.subject = subject;
		// TODO Auto-generated constructor stub
	}

}
