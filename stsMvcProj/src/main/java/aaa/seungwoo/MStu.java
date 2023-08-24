package aaa.seungwoo;

import java.util.ArrayList;

import java.util.List;

import lombok.Data;

@Data
public class MStu implements Comparable<MStu>{
	String name, gender;
	List<Integer> jum;
	int rank,tot, avg , ban, state;
	
	
	public int getTot() {
		tot=0;
		for (Integer i : jum) {
			tot += i;
		}
		return tot;
	}
	
	public int getAvg() {
		avg = getTot()/jum.size();
		return avg;
	}
	
	public void rankCal(ArrayList<MStu> arr) {
		//System.out.println(arr+"오긴했나요 여기에");
		rank = 1;
		for (MStu you : arr) {
			if (avg < you.avg) {
				rank++;
			}
		}
	}
	
	
	
	@Override
	public int compareTo(MStu o) {

		// 성적별
		int res = Integer.compare(rank, o.rank); 
		// 흠 ~별 요소는 어처피 여기서 제어
		// 클릭했을때마다의 정렬순서를 제어하려면 여기를 제어해야 된다생각하는데...
		// 일단 결과까지 진행
	
	
		if (res==0) {
			
			res = Integer.compare(ban, o.ban);
		}
	
		return res;
	
		
	}

	public MStu(String name, String gender, int...jum) {
		super();
		this.name = name;
		this.gender = gender;
		this.jum = new ArrayList<>();
		for (int i : jum) {
			this.jum.add(i);
		}
	}

	public MStu() {
		
	}


}
