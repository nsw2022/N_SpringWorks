package anno_p_main.com.anno_pp;

import anno_p_main.com.sub1.Mouse;
import anno_p_main.com.sub2.Monitor;

public class WorkStation {
	
String name;
	
	Bonche bon;
	
	Monitor m1, m2;
	
	Mouse mm;

	public WorkStation(String name, Bonche bon, Monitor m1, Monitor m2, Mouse mm) {
		super();
		this.name = name;
		this.bon = bon;
		this.m1 = m1;
		this.m2 = m2;
		this.mm = mm;
	}

	@Override
	public String toString() {
		return "WorkStation [name=" + name + ", bon=" + bon + ", m1=" + m1 + ", m2=" + m2 + ", mm=" + mm + "]";
	}
	
	
	
	
	
}
