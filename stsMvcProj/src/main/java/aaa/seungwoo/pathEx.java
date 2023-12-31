package aaa.seungwoo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.MenuData;
import aaa.model.SeasonMain;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/seung/{t}")
public class pathEx {
	
	
	
	@Resource
	SeasonMain sMain;
	
	@ModelAttribute("hNav")
	Object headerNav() {
		ArrayList<MenuData> res = new ArrayList<>();
		res.add(new MenuData("spring", "봄"));
		res.add(new MenuData("summer", "여름"));
		res.add(new MenuData("fall", "가을"));
		res.add(new MenuData("winter", "겨울"));

		return res;
	}
	
	@ModelAttribute("fTxt")
	Object footerTxt() {
		
		return "바닥글입니다.";
	}
	
	@ModelAttribute("mainCt")
	Object mainContent(@PathVariable String t, @PathVariable String q) {
		return sMain.getPicture(q);
	}

	@RequestMapping("{q}")
	String template(@PathVariable String t) {
		
		return "seung/pathVal";
	}
	
	
	


}
