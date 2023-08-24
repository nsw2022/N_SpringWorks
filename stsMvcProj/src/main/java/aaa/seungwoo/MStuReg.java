package aaa.seungwoo;

import java.util.ArrayList;
import java.util.TreeSet;

import lombok.Data;

@Data
public class MStuReg {

	ArrayList<MStu> arr;
	TreeSet<MStu> mstre;
	
	public void rankCalc() {
		for (MStu mStu : arr) {
			mStu.rankCal(arr);
		}
	}
	
	public TreeSet<MStu> geTreeSet() {
		mstre = new TreeSet<>(arr);
		
		return mstre;
	}
	
}
