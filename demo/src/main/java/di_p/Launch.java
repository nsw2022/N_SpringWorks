package di_p;

public class Launch {
	String name;
	int price;
	public Launch(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Launch [name=" + name + ", price=" + price + "]";
	}
	
	
	
}
