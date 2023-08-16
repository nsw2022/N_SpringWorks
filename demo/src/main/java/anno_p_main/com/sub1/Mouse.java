package anno_p_main.com.sub1;

import org.springframework.stereotype.Component;

@Component
public class Mouse {
	
	public Mouse() {
		
	}

	
	public Mouse(String name, String type) {
		this.name = name;
		this.type = type;
		
	}

	String name = "매직마우스", type="블루투스";

	@Override
	public String toString() {
		return "Mouse [name=" + name + ", type=" + type + "]";
	}

}
