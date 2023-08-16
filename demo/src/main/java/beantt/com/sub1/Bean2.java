package beantt.com.sub1;

import org.springframework.stereotype.Component;

@Component
public class Bean2 {
	String beanName = "기본 원두입니다.";
	
	public Bean2() {
		// TODO Auto-generated constructor stub
	}

	public Bean2(String beanName) {
		super();
		this.beanName = beanName;
	}

	@Override
	public String toString() {
		return "Bean [beanName=" + beanName + "]";
	}
	
	
	
}
