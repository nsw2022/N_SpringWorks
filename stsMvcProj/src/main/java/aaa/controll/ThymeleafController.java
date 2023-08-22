package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
	
	@RequestMapping("calc")
	String calc() {
		return "thymeleaf/calc";
	}
	@RequestMapping("controll")
	String control(Model mm) {
		
		mm.addAttribute("arr",new int[] {83,11,55,88,55,77});
		mm.addAttribute("pname" , "장서건");
		mm.addAttribute("pid" , "qqq");
		
		return "thymeleaf/controll";
	}
	
	
	
}
