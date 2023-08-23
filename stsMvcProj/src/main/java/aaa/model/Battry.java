package aaa.model;

import lombok.Data;

@Data
public class Battry {
	String name;
	int size;
	public Battry(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}
	
}
