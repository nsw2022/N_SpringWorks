package aop_p_ex.fish;

import java.util.HashMap;

import org.springframework.stereotype.Component;


public class FigureCal {
	
	HashMap<String, Figure> map;
	
	public FigureCal() {
		map = new HashMap<>();
		
		map.put("원1 넓이", new Figure("원1", 3));
		map.put("원2 둘레", new Figure("원2", 3));
		map.put("직사각형1 넓이", new Figure("직사각형1 넓이", 4,5) );
		map.put("직사각형2 둘레", new Figure("직사각형2 둘레", 4,5));
		map.put("직각삼각형1 넓이", new Figure("직각삼각형1 넓이", 4,5));
		map.put("직각삼각형2 둘레", new Figure("직각삼각형2 둘레", 3,4,5));

	}
	
	public void Carea() {
		
	}
	
	@Override
	public String toString() {
		return "FigureCal [map=" + map + "]";
	}
	
	
}
