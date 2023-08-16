package beanComponent;

import org.springframework.stereotype.Component;

import di_p.Coffee;
import jakarta.annotation.Resource;

@Component
public class Macchiato extends Americano {

	String beanName="고오급 원두", water="안넣을거에요..",caramel="아이달아";
	int price=5000;
	
	
	public String show(String beanName, String water,String caramel, int price) {
		this.beanName=beanName;
		this.water=water;
		this.caramel=caramel;
		this.price=price;
		return("원두이름 : " + beanName + " 물: " + water +" 카라멜:" +caramel + " 가격: " + price);
	}

	@Override
	public String toString() {
		
		return show(beanName, water, caramel, price);
	}
	
	

}
