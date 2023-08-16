package Taluga;

public class Bycycle implements Unit{
	
	int ba;
	String handel;
	String baguni;
	
	public Bycycle() {
		System.out.println("나는 기본이오");
	}
	
	public Bycycle(int ba, String handel, String baguni) {
		super();
		this.ba = ba;
		this.handel = handel;
		this.baguni = baguni;
//		System.out.println("포카리요");
	}
	
	
	
	
	public Bycycle(int ba, String handel) {
		super();
		this.ba = ba;
		this.handel = handel;
//		System.out.println("3발과 MTB가 가능하다오");
	}




	@Override
	public void go() {
		
		if (ba>=3) {
			System.out.println("세발자전거 출발"+" 바퀴가 "+ba+" 지요");
		}else if (ba ==2 && baguni != null) {
			System.out.println("포카리 자전거 출발" +" 바퀴가 " +ba +" 지요");
		}else if (ba==2&&baguni==null) {
			System.out.println("MTB출발");
		}
		
	}

	@Override
	public void fix() {
		
		if (ba>=3) {
			System.out.println("세발자전거 수리");
		}else if (ba ==2 && baguni != null) {
			System.out.println("포카리 자전거 수리");
		}else if (ba==2&&baguni==null) {
			System.out.println("MTB수리");
		}
		
		
	}

	@Override
	public void fall() {
		if (ba>=3) {
			System.out.println("세발자전거 넘어진다");
		}else if (ba ==2 && baguni != null) {
			System.out.println("포카리 넘어진다");
		}else if (ba==2&&baguni==null) {
			System.out.println("MTB 넘어진다");
		}
	}

	public int getBa() {
		return ba;
	}

	public void setBa(int ba) {
		this.ba = ba;
	}

	public String getHandel() {
		return handel;
	}

	public void setHandel(String handel) {
		this.handel = handel;
	}

	public String getBaguni() {
		return baguni;
	}

	public void setBaguni(String baguni) {
		this.baguni = baguni;
	}
	
	

}
