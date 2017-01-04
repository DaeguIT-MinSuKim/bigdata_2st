package kr.or.dgit.bigdata.project.hairshop.dto;

import java.util.Date;

public class Customer {
	private int cNo;
	private String cName;
	private Date cDob;
	private Date cDoJoin;
	private String cPhone;//휴대폰 번호 0으로 시작해서 int형 대신에 String으로 바꿔 봤어요. - 유진
	
	public Customer() {}
	// 생성자들중에 제가 테스트하는 도중 필요해서 이름, 이름+폰번호 생성자 추가했어요 - 유진
	public Customer(int cNo) {
		super();
		this.cNo = cNo;
	}
	
	public Customer(int cNo, String cName) {
		super();
		this.cNo = cNo;
		this.cName = cName;
	}
	
	public Customer(String cName) {
		super();
		this.cName = cName;
	}

	public Customer(String cName, String cPhone) {
		super();
		this.cName = cName;
		this.cPhone = cPhone;
	}

	public Customer(String cName, Date cDob) {
		super();
		this.cName = cName;
		this.cDob = cDob;
	}

	

	public Customer(int cNo, String cName, Date cDob, Date cDoJoin, String cPhone) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cDob = cDob;
		this.cDoJoin = cDoJoin;
		this.cPhone = cPhone;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Date getcDob() {
		return cDob;
	}

	public void setcDob(Date cDob) {
		this.cDob = cDob;
	}

	public Date getcDoJoin() {
		return cDoJoin;
	}

	public void setcDoJoin(Date cDoJoin) {
		this.cDoJoin = cDoJoin;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	@Override
	public String toString() {
		return "Customer [cNo=" + cNo + ", cName=" + cName + ", cDob=" + cDob + ", cDoJoin=" + cDoJoin + ", cPhone="+ cPhone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cDoJoin == null) ? 0 : cDoJoin.hashCode());
		result = prime * result + ((cDob == null) ? 0 : cDob.hashCode());
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + cNo;
		result = prime * result + ((cPhone == null) ? 0 : cPhone.hashCode());;
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
		Customer other = (Customer) obj;
		if (cDoJoin == null) {
			if (other.cDoJoin != null)
				return false;
		} else if (!cDoJoin.equals(other.cDoJoin))
			return false;
		if (cDob == null) {
			if (other.cDob != null)
				return false;
		} else if (!cDob.equals(other.cDob))
			return false;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (cNo != other.cNo)
			return false;
		if (cPhone != other.cPhone)
			return false;
		return true;
	}	
}
