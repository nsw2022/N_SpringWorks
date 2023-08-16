package anno_p_main.com.anno_pp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import anno_p_main.com.sub1.Mouse;
import anno_p_main.com.sub2.Monitor;
import jakarta.annotation.Resource;

@Component
public class DESKTop {
	@Autowired
	Bonche bc;
	@Resource
	Mouse mouse;
	
	@Resource(name = "mnntt")
	Monitor mon;
	String name = "오마이피씨";

	@Override
	public String toString() {
		return "DESKTop [bc=" + bc + ", mouse=" + mouse + ", mon=" + mon + ", name=" + name + "]";
	}
	
	
	

}
