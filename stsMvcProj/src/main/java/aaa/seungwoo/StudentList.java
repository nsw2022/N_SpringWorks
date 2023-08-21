package aaa.seungwoo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StudentList {
  private List<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }
    
    

    public void setStudents(List<Student> students) {
        this.students = students;
    }
   
	public void rankCal(StudentList st ) {
		for (Student first : this.students) {
			first.rank=1;
			for (Student ours : st.getStudents()) {
				if (first.getAvg() < ours.getAvg()) {
					
					first.rank++;
				}
			}
		}
	}
	
}
