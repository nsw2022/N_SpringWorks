package aaa.seungwoo;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentRanck {
	ArrayList<Student> arrCal= new ArrayList<>();
	ArrayList<Integer> arrAvg = new ArrayList<>();
	
	public void getRnak(Student student) {
		arrCal.add(student);
		arrAvg.add(student.avg);
		
		// 버블 정렬 실행
		for (int i = 0; i < arrAvg.size(); i++) {
			for (int j = 0; j < arrAvg.size() - i - 1; j++) {
				if (arrAvg.get(j) < arrAvg.get(j+1)) {
					// 평균 값 비교하여 정렬 순서를 바꿈
					int temp = arrAvg.get(j);//바꿔치기할 친구
					
					arrAvg.set(j, arrAvg.get(j + 1));
					arrAvg.set(j + 1,  temp);
					
					// 학생도 순서 바꿈
					Student temStudent = arrCal.get(j);
					arrCal.set(j, arrCal.get(j+1));
					arrCal.set(j + 1, temStudent);
					
				}
			}
		}// 버블끝
		
		for (int i = 0; i < arrCal.size(); i++) {
			Student st = arrCal.get(i);
			st.rank = i + 1;
		}
		
	}
	
}
