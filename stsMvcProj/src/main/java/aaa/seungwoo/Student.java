package aaa.seungwoo;

import java.util.Comparator;

import lombok.Data;

@Data
public class Student implements Comparable<Student> {
	 int ban;
	 String gender, grade, name;
	 int kor;
	 int eng;
     int math;
     int rank;
     int total;
     int avg;
     
     
     
    public String getGrade() {
    	grade = "가가가가가가양미우수수".charAt(avg / 10) + "";
		return grade ;
	}

	public int getTotal() {
		total = kor + eng + math;
		return total;
	}


	public int getAvg() {
		avg = total/3;
		return avg;
	}
	

	

	
	public Student(int ban, String gender, int kor, int eng, int math, String name) {
		super();
		this.ban = ban;
		this.gender = gender;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	
     }
	
	public Student() {
		super();
	}

	@Override
	public int compareTo(Student o) {
		
		// 성적별
		int compare = Integer.compare(total, o.total);
		
		// 성적이 같으면? 여기로 들어와서
		if (compare==0) {// 사라지기전에 반별 비교
			compare = Integer.compare(ban, o.ban); 
			return compare; 
		}else if (compare==0) {// 성적과 반이 같으면? 성별비교
			compare = gender.compareTo(o.gender);
		}
		 
	
		return compare*-1;
	}
         
}
