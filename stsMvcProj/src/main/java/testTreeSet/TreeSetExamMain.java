package testTreeSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

class CheckRank{
	ArrayList arrCla = new ArrayList();
	ArrayList arrAvg = new ArrayList();
	
	private static CheckRank me = null;
	
	private CheckRank() {}
	
	static public CheckRank getInstance() {
		
		if(me==null) {
			me = new CheckRank();
		}
		return me;
	}
	
	void pp(TSStud ts) {
	    arrCla.add(ts); // 학생 객체를 arrCla 리스트에 추가합니다.
	    arrAvg.add(ts.avg); // 학생의 평균 점수를 arrAvg 리스트에 추가합니다.

	    int n = arrAvg.size(); // 리스트의 크기를 저장합니다.
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            // 인접한 두 요소를 비교하고 정렬합니다.
	            if ((int) arrAvg.get(j) < (int) arrAvg.get(j + 1)) {
	                // 평균값을 비교하여 정렬 순서를 바꿉니다.
	                int tempAvg = (int) arrAvg.get(j);
	                arrAvg.set(j, arrAvg.get(j + 1));
	                arrAvg.set(j + 1, tempAvg);

	                // 학생 객체도 같은 순서로 정렬합니다.
	                TSStud tempStud = (TSStud) arrCla.get(j);
	                arrCla.set(j, arrCla.get(j + 1));
	                arrCla.set(j + 1, tempStud);
	            }
	        }
	    }

	    // 정렬된 순서대로 학생 객체에 등수를 부여합니다.
	    for (int i = 0; i < arrCla.size(); i++) {
	        TSStud rk = (TSStud) arrCla.get(i);
	        rk.rank = i + 1;
	    }
	}


}

class TSStud {
	String name,type,gender;
	int [] jum;
	int tot, avg , ban;
	public int rank;
	public TSStud(String name,int ban,String gender, int... jum) {
		if(jum.length==4) {
			type="예체능";
		}
		else {
			type="일반";
		}
		this.name = name;
		this.jum = jum;
		this.ban = ban;
		this.gender=gender;
		calc();
	}
	
	void calc() {
		tot = 0;
		for (int i : jum) {
			tot += i;
		}
		avg = tot / jum.length;
		CheckRank.getInstance().pp(this);
	}
	
	@Override
	public String toString() {
		return type+"\t"+ban + "반\t" +gender+"\t"+rank + "등\t" +name + "\t" +Arrays.toString(jum) + "\t" + tot + "\t" + avg;
	}
	
	
	
}

class TSStCom implements Comparator<TSStud>{

	@Override
	public int compare(TSStud o1, TSStud o2) {
		
	     // 일반, 예체능으로 구별
        int res = o1.type.compareTo(o2.type);
        
        if (res == 0) {
            // 같을 시 반으로 구별
            res = Integer.compare(o1.ban, o2.ban);
        }
        if (res == 0) {
            // 반 같을 시 성별로 구별
            res = o1.gender.compareTo(o2.gender);
        }
        if (res == 0) {
            // 성별 같을 시 등수로 구별 (평균으로 대체)
            res = Integer.compare(o2.avg, o1.avg); // 내림차순으로 변경
        }
        if (res == 0) {
            // 평균도 같다면 이름으로 구별
            res = o1.name.compareTo(o2.name);
        }

        return res;
		/*
		TSStud me = (TSStud)o1;
		TSStud you = (TSStud)o2;
		

		//일반,예체능으로 구별
		
		int res = TypEEE.valueOf(you.type).ordinal()-TypEEE.valueOf(me.type).ordinal();
		//같을시 반으로 구별
		if(res==0) {		
			res = me.ban-you.ban;
		}
		//반같을시 성별로 구별
		if(res==0) {		
			res = GenEEE.valueOf(you.gender).ordinal()-GenEEE.valueOf(me.gender).ordinal();
		}
		//성별 같을시 등수로 구별인데 아직등수가 정해지지않아서 등수가 곧 평균임으로 평균으로 구별
		if(res==0) {		
			res = you.avg-me.avg;
		}
		//평균도 같다면 이름으로 구별 ㄱㄴㄷ순
		if(res==0) {		
			res = me.name.compareTo(you.name);
		}
		

		
		return res;
		*/
	}


	
}



enum TypEEE{
	일반,예체능
}
enum GenEEE{
	여,남
}
public class TreeSetExamMain {

	public static void main(String[] args) {
		
		TreeSet studs = new TreeSet(new TSStCom());
		studs.add(new TSStud("일",3,"남", 17,68,61));
		studs.add(new TSStud("이",2,"여", 97,58,61,71));
		studs.add(new TSStud("삼",1,"여", 97,98,31));
		studs.add(new TSStud("사",3,"여", 77,48,71,71));
		studs.add(new TSStud("오",3,"남", 17,18,61));
		studs.add(new TSStud("육",2,"여", 77,48,71));
		studs.add(new TSStud("칠",1,"남", 57,58,21,71));
		studs.add(new TSStud("팔",2,"여", 99,78,71));
		
		for (Object obj : studs) {
			System.out.println(obj);
		}
	}

}
