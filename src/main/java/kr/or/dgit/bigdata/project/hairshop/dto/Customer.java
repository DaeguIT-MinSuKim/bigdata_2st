package kr.or.dgit.bigdata.project.hairshop.dto;

import java.util.Date;

public class Customer {
	/* 변수 */
	private int cNo;
	private String cName;
	private Date cDob;

	private Date cDoJoin;
	private String cPhone;
	private boolean cDel;
	/* GET/SET */
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
	
	

	
	public boolean iscDel() {
		return cDel;
	}
	public void setcDel(boolean cDel) {
		this.cDel = cDel;
	}
	@Override
	public String toString() {
		return "Customer [cNo=" + cNo + ", cName=" + cName + ", cDob=" + cDob + ", cDoJoin=" + cDoJoin + ", cPhone="
				+ cPhone + "]";
	}
	
	public String[] toArray() {
		
		return  new String[] {cNo+"", cName, cDob+"", cDoJoin+"", cPhone};
	}

	/* 생성자 */
	public Customer() {}
	public Customer(String cName) {
		super();
		this.cName = cName;
	}
	public Customer(int cNo, String cName, Date cDob, Date cDoJoin, String cPhone) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cDob = cDob;
		this.cDoJoin = cDoJoin;
		this.cPhone = cPhone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cDoJoin == null) ? 0 : cDoJoin.hashCode());
		result = prime * result + ((cDob == null) ? 0 : cDob.hashCode());
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + cNo;
		result = prime * result + ((cPhone == null) ? 0 : cPhone.hashCode());
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
		if (cPhone == null) {
			if (other.cPhone != null)
				return false;
		} else if (!cPhone.equals(other.cPhone))
			return false;
		return true;
	}
	
	

}
