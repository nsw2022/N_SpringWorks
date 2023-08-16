package beantt.com.sub1;

import org.springframework.stereotype.Component;

@Component
public class Price {
	int price = 1700;
	
	public Price() {
		// TODO Auto-generated constructor stub
	}

	public Price(int price) {
		super();
		this.price = price;
	}

	@Override
	public String toString() {
		return "Price [price=" + price + "]";
	}
	
	
	
}
