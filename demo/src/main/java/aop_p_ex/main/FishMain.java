package aop_p_ex.main;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p_ex.fish.FishDesign;

public class FishMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/fish.xml");
		

	    //System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		
		FishDesign fi = (FishDesign) context.getBean("fishDesign");
		System.out.println(fi.catchFish("지렁이"));
		System.out.println("------------------------------");
		System.out.println(fi.catchFish());
		System.out.println("------------------------------");
		System.out.println(fi.fishSize(10, "방어"));
		System.out.println("------------------------------");
		System.out.println(fi.fishSize(30, "방어"));
		
		context.close();
	}

}
