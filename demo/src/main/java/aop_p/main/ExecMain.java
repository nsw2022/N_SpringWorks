package aop_p.main;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;
import aop_p.webToon.KangSan;

public class ExecMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/exec.xml");
		
		//System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		JoSuk jsk = context.getBean("joSuk",JoSuk.class);
		KangBada kbd = context.getBean("kbd",KangBada.class);
		KangSan kangSan = context.getBean("kangSan",KangSan.class);
		System.out.println("jsk.dog1:"+jsk.dog1(12,"아기상어"));
		System.out.println("---------------");
		System.out.println("jsk.wife:"+jsk.wife());
		System.out.println("---------------");
		System.out.println("jsk.popo:"+jsk.popo(44));
		System.out.println("---------------");
		kbd.dogdo();
		System.out.println("---------------");
		kangSan.yunFish();
		System.out.println("---------------");
		kangSan.ra9yo();
		System.out.println("---------------");
		context.close();
		
		
		/*
		 	도형 클래스를 구현하세요 PI = Math.PI
		 			넓이		둘래
	 	  원       r*r*PI   r*2*PI
		 직사각형    가로*세로  (가로+세로)*2
		 직각삼각형  가로*세로/2 가로+세로+빗변
		 aop를 이용하여 계산 할 때마다 
		 각 도형의 넓이, 둘레의 합계, 평균을 계산하세요
		  
		 * */
		
	}

}
