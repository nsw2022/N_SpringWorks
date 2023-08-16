package di_p;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Umbrella implements BeanNameAware, InitializingBean, DisposableBean{

	String name, type;
	int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("Umbrella setName()" + name);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Umbrella(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Umbrella() {
		System.out.println("Umbrella 기본 생성자");
	}
	
	
	
	public Umbrella(String name, String type, int price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	
	}
	@Override
	public String toString() {
		return "Umbrella [name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName()"+name);
	}
	
}
