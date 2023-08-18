package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	//@ResponseBody
	String homeGo() {
		System.out.println("홈이다");
		//return "homehome";
		return "home"; // views/home.html
		
/*

application.yaml 의 설정 덕에 가능
server :
  port : 80
spring : 
  thymeleaf:
    prefix : views/
    suffix : .html
    cache : false
     



 * */
	}
}
