package aaa.seungwoo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seung")
public class ModelStuEx {
	
	/*
	 
	 html을 파스칼표기법으로 만들어서
	 아래있는 String도 헷갈릴까봐 이름과 같게만들긴했는데 조금걸리네요 html도 카멜로 지었어야했을까요
	 
	 일단 출력까지 진행
	 
	 1안
	 ModelStu.html에서 input요소를 하나 추가한것을 
	 상태변수라 가정 (~별 정렬 할때 넘긴 파라미터에 따라 출력을 다르게)
	 
	 MStu는 현재 성적순보기로 설정이 되어있음
	 MStuMain이라는 클래스안에
	 HashMap<String, MStu> mtest
	 
	 기본생성자안에
	 해쉬맵 선언후 mtest.put("성적순보기", 흠.. 비슷한느낌인거같은데 갈피가 잘안잡히네요.. 
	 안에 들어갈 compareTo 의 조건을 바꿔야할지 아니면 조건을 바꿔서 다른클래스를 넣어야할지..
	 
	 */
	@RequestMapping("ModelStu")
	String ModelStu() {
		return "seung/ModelStu";
	}
	
	@RequestMapping("ModelStuReg")
	String ModelStuReg(MStuReg msReg) {
		System.out.println(msReg+"이벤트췍");
		
		msReg.rankCalc();
		msReg.geTreeSet();
		
		return "seung/ModelStuReg";
	}

	
	
}
