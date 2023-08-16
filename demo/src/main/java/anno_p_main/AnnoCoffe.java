package anno_p_main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.boot.util.Instantiator.FailureHandler;

public class AnnoCoffe {
	
	
	String name;
	int price;
	@Qualifier("w1")
	@Autowired
	Wondu wondu;
	
	@Qualifier("b1")
	@Autowired
	Bosock bosock;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	

	public void setPrice(int price) {
		this.price = price;
	}
	
	public Wondu getWondu() {
		return wondu;
	}
	public void setWondu(Wondu wondu) {
		this.wondu = wondu;
	}
	
	public Bosock getBosock() {
		return bosock;
	}
	
	
	public void setBosock(Bosock bosock) {
		this.bosock = bosock;
	}
	@Override
	public String toString() {
		return "AnnoCoffe [name=" + name + ", price=" + price + ", wondu=" + wondu + ", bosock=" + bosock + "]";
	}
	
	
}

class Wondu{
	String name,type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Wondu [name=" + name + ", type=" + type + "]";
	}
	
	
}

class Bosock{
	String boType;

	public String getBoType() {
		return boType;
	}

	public void setBoType(String boType) {
		this.boType = boType;
	}

	@Override
	public String toString() {
		return "Bosock [boType=" + boType + "]";
	}
	
	
}