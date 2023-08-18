package aaa.controll;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.Person;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("request")
public class RequestController {
	
	
	@RequestMapping("attr1")
	ModelAndView attr1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("req/attr");
		mav.addObject("age",26);
		mav.addObject("pname","노승우");
		mav.addObject("jum",new int[] {78,89,80});
		mav.addObject("now",new Date());
		mav.addObject("per",new Person("노승우", "남자", true));
		return mav;
	}
	@RequestMapping("attr2")
	String attr2(HttpServletRequest request) {
		request.setAttribute("age",28);
		request.setAttribute("pname","장희성");
		request.setAttribute("jum",new int[] {11,22,33});
		request.setAttribute("now",new Date());
		request.setAttribute("per",new Person("북두신건", "it", false));
		return "req/attr";
	}
	
	@RequestMapping("attr3")
	String attr3(Model mm) {
		mm.addAttribute("age",28);
		mm.addAttribute("pname","적북성");
		mm.addAttribute("jum",new int[] {99,77});
		mm.addAttribute("now",new Date());
		mm.addAttribute("per",new Person("적북성", "여자", true));
		return "req/attr";
	}
	@RequestMapping("attr4")
	String attr4(Model mm, 
			@ModelAttribute("age") int age, 
			@ModelAttribute("nick") String nick,
			@ModelAttribute("jum") int[] jum) {
		System.out.println("age= "+age);
		System.out.println("nick= "+nick);
		System.out.println("jum= "+Arrays.toString( jum ));
		
		
		mm.addAttribute("now",new Date());
		mm.addAttribute("per",new Person("적북성", "여자", true));
		return "req/attr";
	}
	@RequestMapping("attForm")
	String attForm() { 
		
		return "req/attForm";
	}
	
	@RequestMapping("attrReg")
	String attrReg( 
			@ModelAttribute("age") int age,
			@ModelAttribute("pname") String pname,
			@ModelAttribute("jum") int [] jum,
			String gender,
			boolean mil,
			Person per) {
		
		System.out.println("age:"+age);
		System.out.println("pname:"+pname);
		System.out.println("jum:"+Arrays.toString(jum));
		System.out.println("gender:"+gender);
		System.out.println("mil:"+mil);
		System.out.println("per:"+per);
		return "req/attrReg";
	}
}
