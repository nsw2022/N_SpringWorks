package aaa.controll;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.CookieList;
import aaa.model.CookieTest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cookie")
public class CookieController {

	//@RequestMapping("make1")
	//@ResponseBody
	String make1(HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid","ccc"));
		response.addCookie(new Cookie("age","27"));
		return "쿠키생성1";
	}
	
	
	//@RequestMapping("make2")
	//@ResponseBody
	String make2(HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid","ddd"));
		response.addCookie(new Cookie("marriage","true"));
		return "쿠키생성2";
	}
	
	//@RequestMapping("delete")
	@ResponseBody
	String delete(HttpServletResponse response) {
		Cookie coo = new Cookie("pid","");
		coo.setMaxAge(0);
		response.addCookie(coo);
		
		coo = new Cookie("age","5");
		coo.setMaxAge(5);
		response.addCookie(coo);
		
		return "쿠키삭제";
	}
	
	@RequestMapping("view")
	ModelAndView view(
			@CookieValue(value="pid", defaultValue = "없음" )String pid,
			@CookieValue(value="age", defaultValue = "0" )int age,
			@CookieValue(value="marriage", defaultValue = "false" )boolean marriage) {
		
		ModelAndView mav = new ModelAndView("cookie/view");
		mav.addObject("pid",pid);
		mav.addObject("age",age);
		mav.addObject("marriage",marriage);
		return mav;
	}
	
	/*연습================================================================*/
	
	@RequestMapping("ex_make")
	String cook_ex(HttpServletResponse response,
		@RequestParam(value = "id",required = false) String id,
		@RequestParam(value = "name",required = false) String name,
		@RequestParam(value = "pw",required = false) String pw) {
		
		CookieTest cookieTest1 = new CookieTest("aaa", "장동건", "1234");
		CookieTest cookieTest2 = new CookieTest("bbb", "이", "2222");
		CookieTest cookieTest3 = new CookieTest("ccc", "삼", "3333");
		CookieTest cookieTest4 = new CookieTest("ddd", "사", "4444");
		CookieTest cookieTest5 = new CookieTest("eee", "오", "5555");
		
		CookieList cookieList = new CookieList();
		Map<String, CookieTest> map =new HashMap<String, CookieTest>();
		
		map.put("aaa", cookieTest1);
		map.put("bbb", cookieTest2);
		map.put("ccc", cookieTest3);
		map.put("ddd", cookieTest4);
		map.put("eee", cookieTest5);
		
		cookieList.setMap(map);
		
		
		if (id!=null) {
			System.out.println(id);
			if (cookieList.getMap().containsKey(id)&&cookieList.getMap().get(id).getPw().equals(pw)) {
				
				response.addCookie(new Cookie("id",id));
				response.addCookie(new Cookie("name",cookieList.getMap().get(id).getName()));
				return "redirect:ex_view"; 
			}

		}	
		return "cookie/ex_make";
			
	}
	
	@RequestMapping("ex_view")
	ModelAndView ex_view(
			@CookieValue(value = "id", defaultValue = "없음", required = false) String id,
			@CookieValue(value = "name", defaultValue = "0",required = false) String name
			) {
		ModelAndView mav = new ModelAndView("cookie/ex_view");
		mav.addObject("id",id);
		mav.addObject("name",name);
		if(id.equals("없음")) {
			mav.setViewName("redirect:ex_alert");
		}
		return mav;
	}
	
	@RequestMapping("ex_delete")
	@ResponseBody
	String ex_delete(HttpServletResponse response) {
		Cookie coo = new Cookie("id", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		
		coo = new Cookie("name", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		return "쿠키삭제";
	}
	
	
}
