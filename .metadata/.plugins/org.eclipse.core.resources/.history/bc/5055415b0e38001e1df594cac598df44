package di_p_main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoCarMain {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("di_xml/autocar.xml","di_xml/autoParts.xml");
		
		System.out.println("car1 : " + context.getBean("car1"));
		System.out.println("car2 : " + context.getBean("car2"));
		System.out.println("car3 : " + context.getBean("car3"));
		System.out.println("car4 : " + context.getBean("car4"));
		
	}
	
}
