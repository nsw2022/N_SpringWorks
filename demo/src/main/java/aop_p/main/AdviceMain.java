package aop_p.main;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;

public class AdviceMain {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/advice.xml");
		
		//System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		
		JoSuk jsk = context.getBean("joSuk",JoSuk.class);
		System.out.println("jsk.dog1:"+jsk.dog1(12,"아기상어"));
		jsk.nums(0);
		System.out.println("-----------------------");
		
		
		System.out.println("-----------------------");
		
		
	}

}
