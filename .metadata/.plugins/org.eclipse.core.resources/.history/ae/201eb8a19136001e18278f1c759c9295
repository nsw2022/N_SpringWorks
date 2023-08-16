package di_p;

import java.util.Arrays;

public class School {
	// 학생을 참조로 받고
	// 학교에서 학생의 점수를 계산
	
	StudentTest[] students;
	
	public void rankTest() {

		for (StudentTest stu : students) {
			stu.setRank(1);
			for (StudentTest stucompare : students) {
				if (stu.total < stucompare.total) {
					stu.rank++;
				} 
			}
			
		}
	}

	public StudentTest[] getStudents() {
		return students;
	}

	public void setStudents(StudentTest[] students) {
		this.students = students;
	}

	public School(StudentTest[] students) {
		super();
		this.students = students;
		rankTest();
	}

	public School() {
		super();
	}

	@Override
	public String toString() {
		return "School [students=" + Arrays.toString(students) + "]";
	}

	
}
