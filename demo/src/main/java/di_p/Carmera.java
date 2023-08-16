package di_p;

public class Carmera{
	String name;
	int pixel;
	
	
	
	public Carmera(String name, int pixel) {
		
		this.name = name;
		this.pixel = pixel;
	}

	public Carmera() {
		System.out.println("Carmera 기본생성자");
	}
	
	@Override
	public String toString() {
		return "Carmera [name=" + name + ", pixel=" + pixel + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setCame()"+name);
		this.name = name;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	
	
	
}
