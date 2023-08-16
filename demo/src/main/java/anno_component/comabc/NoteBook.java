package anno_component.comabc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import jakarta.annotation.Resource;

@Component
public class NoteBook {

	
	anno_component.com.Bonche bc;
	@Resource
	anno_component.com.sub1.Mouse mouse;
	
	String name = "삼보그램";
	
	@Autowired
	public void setBc(anno_component.com.Bonche bc) {
		System.out.println(name+" setBC()실행:"+bc);
		this.bc = bc;
	}


	public void setMouse(anno_component.com.sub1.Mouse mouse) {
		this.mouse = mouse;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "NoteBook [bc=" + bc + ", mouse=" + mouse + ", name=" + name + "]";
	}
	
	
}
