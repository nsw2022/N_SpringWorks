package beanComponent;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/coffecomponent.xml");
		
		System.out.println("아메리카노-> "+context.getBean("americano"));
		System.out.println("라떼에요-> "+context.getBean("latte"));
		System.out.println("마끼야또에요-> "+context.getBean("macchiato"));
		
		context.close();
		
	}
	
}
