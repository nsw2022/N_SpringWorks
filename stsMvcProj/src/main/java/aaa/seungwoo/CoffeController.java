package aaa.seungwoo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/seung")
public class CoffeController {
	
	@RequestMapping("coffeEx")
	String coffeEx(	) {
		
		return "seung/coffeEx";
	}
	
	@RequestMapping("coffeResult")
	String coffeResult(
			@RequestParam(value = "bean") String bean,
			@RequestParam(value = "bcount", defaultValue = "1") int bcount,
			Model model
			) {

		int result = 0;
		if (bean.startsWith("아메리카노")) {
			result = 2200 * bcount;
		}else if (bean.startsWith("아프리카노")) {
			result = 2300 * bcount;
		}else if (bean.startsWith("아시아노")) {
			result = 2500 * bcount;
		}else {
			System.out.println("이벤트 췍");
			result = 0;
			bean = "원두 안고르면 바보에요";
		}
	
		model.addAttribute("bean",bean);
		model.addAttribute("bcount",bcount);
		model.addAttribute("result",result);
		
		System.out.println(bean+","+bcount+","+result);
		return "seung/coffeResult";
	}

}
