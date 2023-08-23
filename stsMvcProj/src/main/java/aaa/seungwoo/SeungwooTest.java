package aaa.seungwoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.Sform;

@Controller
@RequestMapping("seung")
public class SeungwooTest {
	
	
	
	@RequestMapping("userform")
	String userform() {

		return "seung/userform";
	}
	
	
	@RequestMapping("seungwoo")
	String seungwoo(
		@ModelAttribute("sform")  Sform sform
		
			) {
	
				/*
				 * 파라미터로 하는법(받는쪽에서 [[${param.id}]]
				 * String id,
				 * 
				 * 속성으로 넘김
				 * @ModelAttribute("pw") String pw
				 * [[${pr}]]
				 * 
				 * 속성으로 객체를 넘김
				 * @ModelAttribute("sform")  Sform sform
				 * $[[${sform}]]
				 */
		
		System.out.println(sform);
		
		
		return "seung/gogo";
	}
	
	@RequestMapping("randomForm")
	String randomForm(Model model) {
	    List<Integer> randomNumbers = new ArrayList<>();
	    List<String> genders = new ArrayList<>(Arrays.asList("남","여"));
	    StudentList studentList = new StudentList();

	    Random random = new Random();

	    for (int i = 0; i < 20; i++) {
	        int ban = random.nextInt(5) + 1;
	        String gender = genders.get(random.nextInt(genders.size()));
	        int kor = random.nextInt(101);
	        int eng = random.nextInt(101);
	        int math = random.nextInt(101);
	        String name = i+1 + "승우";
	        Student student = new Student(ban, gender, kor, eng, math, name);
	        studentList.getStudents().add(student);//다넣어서보냄
	    }

	    model.addAttribute("studentList", studentList);
	    System.out.println("오셧나요?"+studentList);
	    return "seung/randomForm";
	}

	

	@RequestMapping("randomResult")
	String randomResult( Model model, StudentList studentList) {
		
		TreeSet<Student> sortedStudents = new TreeSet<>();
		int i=1;
		for (Student student : studentList.getStudents()) {
			i++;
			//student.getRank();
			System.out.println( student.getTotal() + " " + i);
			sortedStudents.add(student);
		}
		
		StudentList testStu = new StudentList();
		List<Student> tt = new ArrayList<>();
		
		for (Student student : sortedStudents) {
			tt.add(student);
		}
		
		testStu.setStudents(tt);
		testStu.rankCal(testStu);
		
		
		model.addAttribute("studentList",testStu);
		//System.out.println("하이하이 계산되었나요?"+testStu);
	    return "seung/randomResult";
	}



}
