package bycycle;

public class ThreeBycycle implements BycycleCategory {
	
	int ba;
	Baguni baguni;
	barr[] barr;
	Handle nohandleisDie;
	
	public ThreeBycycle() {
		System.out.println("세발자전거입니다.");
	}
	
	@Override
	public void go() {
		System.out.println("세발 자전거는 세배로 빨라요");
	}

	@Override
	public void fix() {
		System.out.println("세바리 수리해유");

	}

	@Override
	public void fall() {
		System.out.println("세배로 비싸유");

	}

	public int getBa() {
		return ba;
	}

	public void setBa(int ba) {
		this.ba = ba;
	}

	public Baguni getBaguni() {
		return baguni;
	}

	public void setBaguni(Baguni baguni) {
		this.baguni = baguni;
	}

	public barr[] getBarr() {
		return barr;
	}

	public void setBarr(barr[] barr) {
		this.barr = barr;
	}

	public Handle getNohandleisDie() {
		return nohandleisDie;
	}

	public void setNohandleisDie(Handle nohandleisDie) {
		this.nohandleisDie = nohandleisDie;
	}

	
	
	

}
