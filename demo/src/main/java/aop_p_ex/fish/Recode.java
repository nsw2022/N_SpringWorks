package aop_p_ex.fish;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class Recode {
	ArrayList<Integer> avglist = new ArrayList<>();
	public void jopClass(int kor, int math) {}
	
	public void normalClass(int kor, int math, int eng) {}
	
	public void artClass(int kor, int math, int eng, int skil) {}
	
	public void avgList() {}

}
