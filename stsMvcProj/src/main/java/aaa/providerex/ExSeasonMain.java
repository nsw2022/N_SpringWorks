package aaa.providerex;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class ExSeasonMain {
	
	HashMap<String, String[]> data;
	
	public ExSeasonMain() {
		data = new HashMap<>();
		
		data.put("spring","sa.jpg,sa1.jpg,sa2.jpg,".split(","));
		data.put("summer","sua.png,sub.png".split(","));
		data.put("fall","at_1.jpg,at_2.jpg,at_3.jpg".split(","));
		data.put("winter","ww.jpg,ee.jpg,sp1.jpg".split(","));
	}
	
	public String[] getPicture(String title) {
		return data.get(title);
	}
}
