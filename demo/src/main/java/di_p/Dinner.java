package di_p;

public class Dinner {
	String name;
	int price;
	public Dinner(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Dinner [name=" + name + ", price=" + price + "]";
	}
	
}
