package aaa.providerex;

import lombok.Data;

@Data
public class ExMenuData {
	String url, txt;

	public ExMenuData(String url, String txt) {
		super();
		this.url = url;
		this.txt = txt;
	}
	
}
