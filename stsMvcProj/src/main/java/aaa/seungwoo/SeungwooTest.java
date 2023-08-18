package aaa.seungwoo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.Sform;

@Controller
@RequestMapping("seung")
public class SeungwooTest {
	
	
	
	@RequestMapping("userform")
	String userform() {

		return "seung/userform";
	}
	
	
	@RequestMapping("seungwoo")
	String seungwoo(
		@ModelAttribute("sform")  Sform sform
		
			) {
	
				/*
				 * 파라미터로 하는법(받는쪽에서 [[${param.id}]]
				 * String id,
				 * 
				 * 속성으로 넘김
				 * @ModelAttribute("pw") String pw
				 * [[${pr}]]
				 * 
				 * 속성으로 객체를 넘김
				 * @ModelAttribute("sform")  Sform sform
				 * $[[${sform}]]
				 */
		
		System.out.println(sform);
		
		
		return "seung/gogo";
	}

}
