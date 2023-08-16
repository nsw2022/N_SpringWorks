package anno_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Component_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/bean.xml");

		
		//System.out.println(context.getBean("Mouse"));
		System.out.println("mouse:"+context.getBean("mouse"));
		System.out.println("noteBook:"+context.getBean("noteBook"));
		System.out.println("bbcc:"+context.getBean("bbcc"));
		System.out.println("DESKTop:"+context.getBean("DESKTop"));
		context.close();
		
				
	}

}
