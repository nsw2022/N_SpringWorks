package beanComponent;

import org.springframework.stereotype.Component;

@Component
public class Americano implements Coffee {
	
	String beanName="싸구려원두", water="조금";
	int price=1700;
	
	
	@Override
	public String show(String beanName, String water, int price) {
		this.beanName = beanName;
		this.water=water;
		this.price=price;
		return("원두이름 : " + beanName + " 물: " + water + "가격: " + price);
	}
	
	
	@Override
	public String toString() {
		return show(beanName, water, price);
	}

	

}
