package anno_p_main.com.sub2;

import org.springframework.stereotype.Component;

@Component
public class Mnntt extends Monitor{
	String name = "오성 모니터";
	int size = 17;
	@Override
	public String toString() {
		return "Monitor [name=" + name + ", size=" + size + "]";
	}
}
