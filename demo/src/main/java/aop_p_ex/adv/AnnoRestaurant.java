package aop_p_ex.adv;

import org.springframework.stereotype.Component;

@Component
public class AnnoRestaurant {
	public void soup(String sname,int sprice) {
		int bb = 3_000;
		if (sprice<=10_000) {
			System.out.println( "국 이름: " + sname + " 결제금액"+(bb+sprice) );
		}else if (sprice>=10_001) {
			System.out.println( "국 이름: " + sname + " 결제금액" + +sprice );
		}
	}
	
	public void rice(String rname, int rprice) {
		int bb = 3_000;
		if (rprice<=10_000) {
			System.out.println( "덮밥 이름: " + rname + " 결제금액"+(bb+rprice) );
		}else if(rprice>=10_000) {
			System.out.println( "덮밥 이름: " + rname + " 결제금액" + +rprice );
		}
		
	}
}
