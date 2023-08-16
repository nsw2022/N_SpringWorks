package beantt.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import beantt.com.sub1.Bean2;
import beantt.com.sub1.Caramel;
import beantt.com.sub1.Price;
import beantt.com.sub1.Water;

@Configuration("Macchiato")
public class Macchiato {

	@Bean
	Bean2 bean3() {
		return new Bean2("마끼야또 원두입니다");
	}
	
	@Bean
	Caramel caramel3() {
		return new Caramel("달달해요");
	}
	
	@Bean
	Price price3() {
		return new Price(6000);
	}
	@Bean
	Water water3() {
		return new Water("물업습니다.");
	}

	@Override
	public String toString() {
		return "Macchiato [원두=" + bean3() + ", 카라멜=" + caramel3() + ", 가격=" + price3() + ", 물="
				+ water3() + "]";
	}

	
	
	
}
