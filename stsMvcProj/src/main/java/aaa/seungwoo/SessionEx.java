package aaa.seungwoo;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.Person;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("session")
public class SessionEx {
	
	//넘기는쪽
	@RequestMapping("ex_session_main")
	String sessionMain() {
	
		return "session/exSessionMain";
	}
	
	// 받는쪽
	@RequestMapping("ex_session_reg")
	String sessionReg(
			String id, String pw,
			HttpSession session) {
		HashMap<String, Person> map = new HashMap<>();
		
		map.put("aaa", new Person("aaa", "장동건" , "1111"));
		map.put("bbb", new Person("bbb", "장서건", "222"));
		map.put("ccc", new Person("ccc", "장동건", "3333"));
		map.put("ddd", new Person("ddd", "장남건", "1111"));
		map.put("eee", new Person("eee", "북두신건", "3333"));
		
		
		String msg ="로그인 실패";
		if (map.containsKey(id) && map.get(id).getPw().equals(pw)) {
			msg = map.get(id).getPname()+"로그인 성공";
			session.setAttribute("mem", map.get(id));
			session.setAttribute("msg", msg);
		}else {
			session.setAttribute("msg", msg);
		}
	
		return "session/exSessionReg";
	}
	
	@RequestMapping("ex_session_delete")
	String sessinDelete(HttpSession session) {
		String msg = "로그아웃 성공!";

		session.setAttribute("msg", msg);
		session.removeAttribute("mem");
		
		return "session/exSessionReg";
	}
	
	
	
	
}
