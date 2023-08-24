package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.PathData;

/* 
 
 localhost/board/notice/list/1
 localhost/board/fav/list/3
 localhost/board/qua/list/2
 
  /board/{cate}/list/{pNo}
  
 */

@Controller
@RequestMapping("path/{cate}")
public class PathController {
	
	@RequestMapping("aaa")
	String mm1(@PathVariable String cate) {
		System.out.println("mm1() 실행"+cate);
		
		return "path/view";
	}
	
	@RequestMapping("{ser}")
	String mm2(@PathVariable String cate,@PathVariable String ser) {
		// String mm1(@PathVariable String cate,@PathVariable String ser,@PathVariable PathData pd)
		// System.out.println("mm2() 실행"+cate+", "+ser+", "+pd); 에러
		System.out.println("mm2() 실행"+cate+", "+ser);
		return "path/view";
	}
	
	@RequestMapping("list/{pNo}")
	String mm3(@PathVariable String cate, @PathVariable int pNo) {
		System.out.println("mm3() 실행"+cate+","+pNo);
		return "path/view"; 
	}
	@RequestMapping("{ser}/{pNo}")
	String mm4(@PathVariable String cate, @PathVariable int pNo,@PathVariable String ser) {
		System.out.println("mm4() 실행"+cate+", "+pNo+", "+ser);
		return "path/view"; 
	}
	
}
