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
	 
	 ModelStu.html에서 input요소를 하나 추가한것을 
	 상태변수라 가정 (~별 정렬 할때 넘긴 파라미터에 따라 출력을 다르게).. 넘복잡할거같음.. 다른방안추진
	 
	 일단 출력까지 진행 - 성공
	 
	 중간 정리 
	 MStu는 원시데이터 받는 클래스
	 MStuReg에서 TreeSet 등 가공
	 ModelStuEx에서 컨트롤러 반응
	 
	 1안
	 MStu는 현재 성적순보기로 설정이 되어있음
	 MStuMain이라는 클래스안에
	 HashMap<String, MStu> mtest
	 
	 기본생성자안에
	 해쉬맵 선언후 mtest.put("성적순보기", 흠.. 비슷한느낌인거같은데 갈피가 잘안잡히네요.. 
	 안에 들어갈 조건을 바꾼 다른클래스(다른compareTo를 구현한) 를 넣어야할지..
	 혹은, 가공 작업을 하는 MStuReg에서 다른 트리셋을 끌고다니는 해쉬맵 구현
	 
	 2안 
	 MStu 데이터를 받을때 int state 를 하나 더 받는다는 가정
	 state의 값에 따라 compareTo를 다르게 반응하도록 테스트
	 
	 구현하는데 생각보다 시간이 많이먹었네요.. 일단 2안 1안순으로 테스트 해보겠습니다 ㅠㅜ
	 
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
