package bycycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TEST {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("di_xml/BBTEST.xml");
		/*
		MTBBycycle mb = (MTBBycycle) context.getBean("byB");
		PokaBycycle pb = (PokaBycycle) context.getBean("byP");
		ThreeBycycle tb = (ThreeBycycle) context.getBean("byT");
		mb.go();
		pb.go();
		tb.go();
		*/
		

	
		String[] arr = {"byB","byP","byT"};
		for (String s1 : arr) {
			
			BycycleCategory bb = (BycycleCategory) context.getBean(s1);
			bb.go();
			bb.fall();
			bb.fix();
			System.out.println();
			
		}
	}

}
