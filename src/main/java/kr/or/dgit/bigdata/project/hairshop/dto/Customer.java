package kr.or.dgit.bigdata.project.hairshop.dto;

import java.util.Date;

public class Customer {
	private int cNo;
	private String cName;
	private Date cDob;
	private Date cDoJoin;
	private String cPhone;
	private boolean cDel;

	public Customer() {
	}

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

	public Customer(int cNo, String cName, Date cDob, Date cDoJoin, String cPhone, boolean cDel) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cDob = cDob;
		this.cDoJoin = cDoJoin;
		this.cPhone = cPhone;
		this.cDel = cDel;
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

}
