package beantt.com;

import beantt.com.sub1.Bean2;
import beantt.com.sub1.Price;
import beantt.com.sub1.Water;

public interface Coffe {
	/*
	public String show(Bean2 bean2, Water water, Price price);
	public Object configCoffe(Object config);
	*/
	public Object testBean(Bean2 bean2);
	public Object testWater(Water water);
	public Object testPrice(Price price);
}
