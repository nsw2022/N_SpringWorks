package bycycle;

public class MTBBycycle implements BycycleCategory {
	
	int ba;
	barr[] barr;
	Handle handle;
	
	
	
	public Handle getHandle() {
		return handle;
	}

	public void setHandle(Handle handle) {
		this.handle = handle;
	}

	public barr[] getBarr() {
		return barr;
	}

	public void setBarr(barr[] barr) {
		this.barr = barr;
	}

	public MTBBycycle() {
		System.out.println("MTB 자전거");
	}
	
	@Override
	public void go() {
		System.out.println("MTB 는 최강이죠");
	}


	@Override
	public void fix() {
		System.out.println("MTB 수리해유");

	}

	@Override
	public void fall() {
		System.out.println("MTB 넘어져유");

	}

	public int getBa() {
		return ba;
	}

	public void setBa(int ba) {
		this.ba = ba;
	}

	

}
