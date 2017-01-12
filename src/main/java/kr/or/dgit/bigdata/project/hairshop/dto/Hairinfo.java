package kr.or.dgit.bigdata.project.hairshop.dto;

public class Hairinfo {
	/* FIELDS */
	private int hNo;
	private String hName;
	private int hPrice;
	/* GET/SET */
	public int gethNo() {
		return hNo;
	}
	public void sethNo(int hNo) {
		this.hNo = hNo;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public int gethPrice() {
		return hPrice;
	}
	public void sethPrice(int hPrice) {
		this.hPrice = hPrice;
	}
	public String gethPriceForm() {
		// 헤어 금액을 ,로 구분하여 표시하는 메소드
		return String.format("%,d 원", hPrice);
	}
	/* CONSTRUCTOR */
	public Hairinfo() {}
	public Hairinfo(int hNo) {
		super();
		this.hNo = hNo;
	}
	public Hairinfo(String hName, int hPrice) {
		super();
		this.hName = hName;
		this.hPrice = hPrice;
	}
	/* METHODS */
	@Override
	public String toString() {
		return String.format("%s", gethPriceForm());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hNo;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hairinfo other = (Hairinfo) obj;
		if (hNo != other.hNo)
			return false;
		return true;
	}
	
}