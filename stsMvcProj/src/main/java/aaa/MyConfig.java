package aaa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aaa.model.Battry;

@Configuration
public class MyConfig {
	
	@Bean
	Battry bat1() {
		return new Battry("로케트바테리", 500);
	}
	@Bean
	Battry bat2() {
		return new Battry("사랑의바테리", 300);
	}
	
}
