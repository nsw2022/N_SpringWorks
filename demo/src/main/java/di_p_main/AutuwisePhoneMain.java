package di_p_main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutuwisePhoneMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("di_xml/autowisePhone.xml");
		
		System.out.println("ph1 : " + context.getBean("ph1"));
		System.out.println("ph2 : " + context.getBean("ph2"));
		System.out.println("ph3 : " + context.getBean("ph3"));
		
		/* System.out.println("ph2 : " + context.getBean("ph2")); */
		
		context.close();
	}
}
