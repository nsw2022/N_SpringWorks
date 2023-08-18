package aaa.model;

import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderData {

	OrderAddr ad;
	ArrayList<OrderProduct> arr;

}
