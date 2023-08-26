package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.JoinData;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class ValidController {
	
	@GetMapping("validForm")
	String vaildForm(JoinData jd) {
		
		return "form/validForm";
	}
	
	@PostMapping("validForm")
	String vaildReg(@Valid JoinData jd, BindingResult br) {
		System.out.println("vaildReg : " + br.hasErrors());
		if (br.hasErrors()) { // 에러가 잇다면
			return "form/validForm";
		}
		
		
		if (!jd.getPw1().equals(jd.getPw2())) {
			br.rejectValue("pw2", null, "암호적인 문제여");
			return "form/validForm";
		}
		
		if (jd.getNeverID().contains(jd.getPid())) {
			br.rejectValue("pid", null, "겹치면 안되는 아이디여");
			//System.out.println("이벤트 체크");
			return "form/validForm";
		}
		
		// 성적을 입력받아 처리하세요
		// 이름 - 한글만 2-5
		// 국영수 숫자 0-100
		
		// 에러가 없으면
		return "form/validReg";
	}

}
