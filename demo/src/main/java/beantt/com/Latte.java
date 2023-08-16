package beantt.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import beantt.com.sub1.Bean2;
import beantt.com.sub1.Milk;
import beantt.com.sub1.Price;
import beantt.com.sub1.Water;

@Configuration("Latte")
public class Latte {
	
	@Bean
	Bean2 bean5() {
		return new Bean2("라떼용 원두입니다");
	}
	
	@Bean
	Price price5() {
		return new Price(4500);
	}
	
	@Bean
	Milk milk5() {
		return new Milk("고오급 우유");
	}
	
	@Bean
	Water water5() {
		return new Water("물은 없습니다.");
	}

	@Override
	public String toString() {
		return "Latte [원두=" + bean5() + ", 가격=" + price5() + ", 우유=" + milk5() + ", 물=" + water5() + "]";
	}

	
}
