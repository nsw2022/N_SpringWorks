package beantt.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import beantt.com.sub1.Bean2;
import beantt.com.sub1.Price;
import beantt.com.sub1.Water;
import jakarta.annotation.Resource;


@Configuration("Americano")
public class Americano {
	
	@Bean
	Bean2 bean2() {
		return new Bean2("아메리카용 원두입니다");
	}
	
	@Bean
	Water water() {
		return new Water("아메리카노 물입니다.");
	}
	@Bean
	Price price() {
		return new Price(1700);
	}

	@Override
	public String toString() {
		return "Americano [원두=" + bean2() + ", 물=" + water() + ", 가격=" + price() + "]";
	}
	
	/*
	@Resource
	Bean bean;
	@Resource
	Water water;
	@Resource
	Price price;
	@Override
	public String toString() {
		return "Americano [bean=" + bean + ", water=" + water + ", price=" + price + "]";
	}
	public Americano(Bean bean, Water water, Price price) {
		super();
		this.bean = bean;
		this.water = water;
		this.price = price;
	}
	public Americano() {
		super();
	}
	*/

	
}
