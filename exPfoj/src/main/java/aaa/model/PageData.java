package aaa.model;



import org.springframework.stereotype.Component;

import aaa.service.BoardMapper;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
@Component
@Data
public class PageData {
	
	@Resource
	BoardMapper mapper;
	
	String msg, goUrl;
	// 파라미터의 페이지
	int page;
	// 총개수 (mapper에 select count(*) from board로 개수 추출
	int total;
	
	// 한번에 보여질 게시글수
	int limit = 5;
	
	// 한번에 보여질 페이징 수
	int pageLimit = 4;
	
	// 페이징 개수
	int pageTotal;
	
	// 시작값
	int start;
	
	// 현재번째 page의 시작값 끝값
	int pageStart, pageEnd;
	
	public void testPage(HttpServletRequest request){
		// 생성될때 받아옴(현재번째 값이라고보면됨)
		page = 1;
		if (request.getParameter("page")!=null) {
			page = Integer.parseInt( request.getParameter("page") );
		}
		calc();
	}

	//연산부
	public void calc() {
		//System.out.println(mapper.totalCnt() + "내가 확인하고 싶은 시점" );
		
		// 총값 얻어옴
		this.total = mapper.totalCnt();
		
		// 총개수 나누기 보여질 게시글 수 = 페이징의 개수
		pageTotal = total / limit;
		
		// 만약 그 나머지가 0보다 크면? 하나더해줌
		if (total%limit>0) {
			pageTotal++;
		}
		
		start = (page-1)*limit;
		/*
		    1 페이지: start = (1 - 1) * 3 = 0
			2 페이지: start = (2 - 1) * 3 = 3
			3 페이지: start = (3 - 1) * 3 = 6
			4 페이지: start = (4 - 1) * 3 = 9
		  
		 * */
		
		pageStart = (page-1)/pageLimit*pageLimit+1;
		// 1페이지는 (1-1)/4*4+1 = 0
		// 2페이지는 (2-1)/4*4+1 = 0
		
		pageEnd = pageStart + pageLimit -1;
		// 끝페이지 공식
		
		if (pageEnd > pageTotal) {
			pageEnd = pageTotal;
		}
		
		//System.out.println("총 페이지"+pageTotal + ", " + "현재끝값"+pageEnd);
		
	}
	
}
