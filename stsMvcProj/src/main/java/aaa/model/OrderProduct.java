package aaa.model;

import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
//@Getter
//@Setter
public class OrderProduct {

	String pname;
	int price, cnt, total;
	public int getPrice() {
		total = price * cnt;
		return total;
	}

	
}
