package anno_p_main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoCoffe_main {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/AnCoffe.xml");
		
		System.out.println(context.getBean("c1"));
		System.out.println(context.getBean("c2"));
		context.close();
	}
}
