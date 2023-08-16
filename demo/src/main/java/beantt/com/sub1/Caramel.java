package beantt.com.sub1;

import org.springframework.stereotype.Component;

@Component
public class Caramel {
	String name="";
	public Caramel() {
		// TODO Auto-generated constructor stub
	}
	public Caramel(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Caramel [name=" + name + "]";
	}
	
	
}
