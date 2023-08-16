package beantt.com.sub1;

import org.springframework.stereotype.Component;

@Component
public class Water {
	String water = "그냥 물";
	
	public Water() {
		// TODO Auto-generated constructor stub
	}

	public Water(String water) {
		super();
		this.water = water;
	}

	@Override
	public String toString() {
		return "Water [water=" + water + "]";
	}
	
	
	
}
