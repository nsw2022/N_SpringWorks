package di_p;

public class AutowisePhone {
	
	String name;
	Screen screen;
	Battery battery;
	Carmer carmer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public Battery getBattery() {
		return battery;
	}
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	public Carmer getCarmer() {
		return carmer;
	}
	public void setC(Carmer carmer) {
		this.carmer = carmer;
	}
	public AutowisePhone(String name, Screen screen, Battery battery, Carmer c) {
		super();
		this.name = name;
		this.screen = screen;
		this.battery = battery;
		this.carmer = c;
		System.out.println("저는 모든 자료형이에요");
	}
	
	public AutowisePhone() {
		System.out.println("나는 기본이에요");
	}
	
	public AutowisePhone(String name, Screen screen, Battery battery) {
		super();
		this.name = name;
		this.screen = screen;
		this.battery = battery;
		System.out.println("나는 둘만 받았네요");
	}
	@Override
	public String toString() {
		return "AutowisePhone [name=" + name + ", screen=" + screen + ", battery=" + battery + ", carmer=" + carmer
				+ "]";
	}
	
	

	
	
	
}

class Screen{
	String name;
	int size;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Screen [name=" + name + ", size=" + size + "]";
	}

	
}

class Battery{
	String name;
	int charge;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	@Override
	public String toString() {
		return "Battery [name=" + name + ", charge=" + charge + "]";
	}
	
}

class Carmer{
	String name, place;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Carmer [name=" + name + ", place=" + place + "]";
	}
	
	
}
