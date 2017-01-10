package kr.or.dgit.bigdata.project.hairshop.dto;

public class HairEvent {
	/* FIELDS */
	private int eNo;
	private String eName;
	private double eDiscount;

	/* GET/SET */
	public int geteNo() {
		return eNo;
	}

	public void seteNo(int eNo) {
		this.eNo = eNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public double geteDiscount() {
		return eDiscount;
	}

	public void seteDiscount(double eDiscount) {
		this.eDiscount = eDiscount;
	}

	public String geteDiscountForm() {
		// 헤어주문 프로그램에서 할인율 호출 시 00%형태로 보여주기 위해 만든 메소드
		return Double.toString(eDiscount * 100) + "%";
	}

	/* CONSTURCTOR */
	public HairEvent() {
	}

	public HairEvent(String eName, double eDiscount) {
		super();
		this.eName = eName;
		this.eDiscount = eDiscount;
	}

	/* METHODS */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(eDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + eNo;
		return result;
	}

	@Override
	public String toString() {
		return String.format("Event [eName=%s]", eName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HairEvent other = (HairEvent) obj;
		if (Double.doubleToLongBits(eDiscount) != Double.doubleToLongBits(other.eDiscount))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (eNo != other.eNo)
			return false;
		return true;
	}

}