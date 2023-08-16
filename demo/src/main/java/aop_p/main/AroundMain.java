package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;

public class AroundMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/around.xml");
		
		JoSuk jsk = context.getBean("joSuk",JoSuk.class);
		
		KangBada kbd = context.getBean("kbd",KangBada.class);
		System.out.println("jsk.dog1:"+jsk.dog1(12,"아기상어"));
		System.out.println("---------------");
		System.out.println("jsk.wife:"+jsk.wife());
		System.out.println("---------------");
		System.out.println("jsk.papa:"+jsk.popo(33));
		System.out.println("==============================");
		System.out.println("kbd.fishing(지렁이):"+kbd.fishing("지렁이"));
		System.out.println("---------------");
		System.out.println("kbd.fishing():"+kbd.fishing());
		System.out.println("---------------");
		System.out.println("kbd.fishing(새우):"+kbd.fishing("새우"));
		System.out.println("---------------");
		System.out.println("kbd.fishing(떡밥):"+kbd.fishing("떡밥"));
		System.out.println("---------------");
		System.out.println("kbd.fishing(오징어):"+kbd.fishing("오징어"));
		System.out.println("---------------");
		
		context.close();

	}

}
