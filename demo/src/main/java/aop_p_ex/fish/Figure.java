package aop_p_ex.fish;

public class Figure {
	String name;
	int radius, width, height, hypotenuse;
	
	final double PI = Math.PI;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHypotenuse() {
		return hypotenuse;
	}

	public void setHypotenuse(int hypotenuse) {
		this.hypotenuse = hypotenuse;
	}

	public double getPI() {
		return PI;
	}

	@Override
	public String toString() {
		return "Figure [name=" + name + ", radius=" + radius + ", width=" + width + ", height=" + height
				+ ", hypotenuse=" + hypotenuse + ", PI=" + PI + "]";
	}

	public Figure(String name, int radius) {
		super();
		this.name = name;
		this.radius = radius;
	}

	public Figure(String name, int width, int height) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public Figure(String name, int width, int height, int hypotenuse) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.hypotenuse = hypotenuse;
	}

	
	
	
	
	
}
