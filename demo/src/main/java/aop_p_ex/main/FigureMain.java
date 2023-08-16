package aop_p_ex.main;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p_ex.fish.FigureCal;

public class FigureMain {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/fiuger_test.xml");
		
		
	    System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		
		//System.out.println(context.getBean("arFiTest"));
	    
	    FigureCal fi = (FigureCal) context.getBean("fi");
	    
		context.close();
	}

}
