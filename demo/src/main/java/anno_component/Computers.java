package anno_component;

import org.springframework.context.annotation.Bean;


import anno_p.comabc.NoteBook;

public class Computers {

	@Bean
	anno_component.com.sub1.Mouse hp920() {
		return new anno_component.com.sub1.Mouse("HP920","버티컬");
	}
	
	@Bean
	NoteBook gm1() {
		return new NoteBook();
	}
	
	@Bean(name = "nb")
	NoteBook gm2(anno_component.com.Bonche LG) {
		NoteBook res = new NoteBook();
		res.setName("기가바이트");
		res.setBc(LG);
		return res;
	}
	
	@Bean
	anno_component.com.WorkStation ws1() {
		//return new WorkStation("델1",  asus(), null, null, hp920());
		return new anno_component.com.WorkStation("델1",  null, null, null, hp920());
	}
	
	@Bean
	anno_component.com.WorkStation ws2(anno_component.com.Bonche LG, anno_component.com.sub1.Mouse hp920) {  //매개변수로 bean 호출
		return new anno_component.com.WorkStation("델2", LG, null, null, hp920);
	}
}
