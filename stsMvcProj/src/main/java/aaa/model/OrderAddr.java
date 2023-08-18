package aaa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderAddr {

	String addr1, addr2, zipcode;
}
