package aop_p_ex.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p_ex.fish.Recode;

public class RecodeMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/recode.xml");
		
		Recode record =(Recode) context.getBean("recode");
		record.jopClass(80, 80);
		record.normalClass(40, 40, 40);
		record.artClass(50, 60, 70, 100);
		record.avgList();
		
		context.close();
		
	}
	
}
