package aaa.model;

import lombok.Data;

@Data
public class CookieTest {
	String id, name, pw;

	public CookieTest(String id, String name, String pw) {
		super();
		this.id=id;
		this.name = name;
		this.pw = pw;
	}
	
}
