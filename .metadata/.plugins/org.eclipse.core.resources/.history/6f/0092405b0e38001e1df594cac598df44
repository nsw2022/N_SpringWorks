package Taluga;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BycycleMain {

	public static void main(String[] args) {
		Bycycle b1 = new Bycycle(3,"핸들"); // 세발이
		Bycycle b2 = new Bycycle(2, "핸들"); // MTB
		Bycycle b3 = new Bycycle(2, "핸들","바구니"); // 포카리
		
		b1.go();
		b1.fix();
		b1.fall();
		System.out.println();
		
		b2.go();
		b2.fix();
		b2.fall();
		System.out.println();
		
		b3.go();
		b3.fix();
		b3.fall();
		System.out.println("===================");
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/bycycle.xml");
		Bycycle xb = (Bycycle) context.getBean("xb");
		xb.setBa(3);
		xb.setHandel("핸들");
		xb.go();
		
		Bycycle xb2 = (Bycycle) context.getBean("xb2");
		xb2.setBa(2);
		xb2.setHandel("핸들");
		xb2.go();

	}

}
