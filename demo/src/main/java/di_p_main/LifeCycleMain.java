package di_p_main;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleMain {

	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/LifeCylcle.xml");
		
		System.out.println(context.getBean("um1"));
		System.out.println();
		System.out.println(context.getBean("um2"));
		System.out.println();
		System.out.println(context.getBean("um3"));
		System.out.println(context.getBean("col1"));
		
		context.close();
		
	}

}
