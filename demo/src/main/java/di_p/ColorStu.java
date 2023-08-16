package di_p;


import java.util.Arrays;



public class ColorStu {
	String name,marking;
	int[] score;
	int total,avg;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getScore() {
		return score;
	}
	public void setScore(int[] score) {
		this.score = score;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}
		
		avg = total/score.length;
	}
	
	public String getMarking() {
		return marking;
	}
	public void setMarking(String marking) {
		this.marking = marking;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public ColorStu(String name, int[] score, int total, int avg) {
		super();
		this.name = name;
		this.score = score;
		this.total = total;
		this.avg = avg;
	}
	
	public ColorStu() {
		
	}
	@Override
	public String toString() {
		return "ColorStu [name=" + name + ", marking=" + marking + ", score=" + Arrays.toString(score) + ", total="
				+ total + ", avg=" + avg + "]";
	}
	public ColorStu(String name, String marking, int[] score, int total, int avg) {
		super();
		this.name = name;
		this.marking = marking;
		this.score = score;
		this.total = total;
		this.avg = avg;
	}
	
	
	
	
	
	
	
}
