package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import aaa.model.Battry;

import aaa.model.Carmera;
import aaa.model.Person;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/model")
public class ModelController {
	
	@ModelAttribute//이름은 person, 
	                //ppp1과 ppp2 중 나중 설정된 것이 무엇인지 알 수 없음
	Person ppp1() {
		return new Person("yzc", "유진초이", "1111");
	}
	
	@ModelAttribute//이름은 person
					//ppp1과 ppp2 중 나중 설정된 것이 무엇인지 알 수 없음
					//메소드 이름과 attribute 이름은 관계 없음
					// 이렇게 정의하지 말 것
	Person ppp2() {
		return new Person("bss", "백승수단장", "2222");
	}
	
	
	@ModelAttribute("per3")//이름은 per3
	Person ppp3(int no) {
		
		Person [] res = {
				new Person("gdm", "구동매", "3333"),
				new Person("khs", "김하성", "444"),
				new Person("gas", "고애신", "5555")
				
		};
		
		System.out.println("ppp3:"+no);
		return res[no];
	}
	
	@Resource
	//@ModelAttribute  //멤버변수에 직접 넣을 수 없다
	Carmera cam;
	
	@Resource
	Battry bat1;
	
	@ModelAttribute
	Carmera cc1() {
		return cam;
	}
	
	@ModelAttribute //battery 가 이름
	Battry bb1() {
		return bat1;
	}

	@RequestMapping("mm1")
	String mmm1(Model mm) {
		mm.addAttribute("pp","아이젠 소스케");
		return "model/mm1";
	}
	
	@RequestMapping("mm2")
	String mmm2(Model mm) {
		mm.addAttribute("pp2","내가 곧 하늘이다");
		return "model/mm2";
	}
}
