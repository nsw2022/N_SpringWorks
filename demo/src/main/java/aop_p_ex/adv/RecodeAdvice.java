package aop_p_ex.adv;

import java.util.ArrayList;
import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class RecodeAdvice {
	ArrayList<Integer> avglist = new ArrayList<>();
	// 보완점 1. 직종별로 ArrayList를 만들면 직종별 평균 가능
	// 보완점 2. HashMap<String, Record> map; 을사용해서 
	// key의 앞에 두개따서 ~별 평균도 될꺼같음
	
	int jopClass(JoinPoint joinPoint, int kor, int math) {
		int total = kor + math;
		int avg = total / 2;
		this.avglist.add(avg);
		System.out.println("직업반 "+avg);
		return avg;
	}
	int artClass(JoinPoint joinPoint, int kor, int math, int eng, int skil) {
		int total = kor + math + eng + skil;
		int avg = total / 4;
		this.avglist.add(avg);
		System.out.println("예체능반 "+avg);
		return avg;
	}
	
	int normalClass(JoinPoint joinPoint, int kor, int math, int eng) {
		int total = kor + math;
		int avg = total / 2;
		this.avglist.add(avg);
		System.out.println("직업반 "+avg);
		
		return avg;
	}

	
	 int avgList() {
		int total=0;
		for (Integer i : this.avglist) {
			total+=i;
		}
		total = total / avglist.size();
		System.out.println("평균의 평균" + total);
		return total; 
	}
	
	
	
}
