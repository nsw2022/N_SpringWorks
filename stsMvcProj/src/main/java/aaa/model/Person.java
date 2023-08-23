package aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	String pname, gender;
	boolean mil;
	
	public String id, pw;
	public int age;
	public boolean marriage;

	

	public Person(String pname, String gender, boolean mil) {
		super();
		this.pname = pname;
		this.gender = gender;
		this.mil = mil;
	}



	public Person( String id,String pname, String pw) {
		super();
		this.pname = pname;
		this.id = id;
		this.pw = pw;
	}
	
}
