package anno_component.com.sub2;

import org.springframework.stereotype.Component;

import anno_p.comabc.Monitor;

@Component
public class Mnntt extends Monitor {

	String name = "오성모니터";
	int size = 25;
	@Override
	public String toString() {
		return "Monitor [name=" + name + ", size=" + size + "]";
	}
	
	
}
