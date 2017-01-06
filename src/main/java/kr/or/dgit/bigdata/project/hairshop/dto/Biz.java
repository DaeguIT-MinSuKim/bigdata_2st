package kr.or.dgit.bigdata.project.hairshop.dto;

import java.sql.Time;
import java.util.Date;

public class Biz {
	private int bNo;
	private Date bDate;
	private Time bTime; // java.util.* 이 아닌 java.sql.Time 로 import해서 사용함.
	private Customer cNo;
	private Hairinfo hNO;
	private HairEvent eNo;
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public Time getbTime() {
		return bTime;
	}
	public void setbTime(Time bTime) {
		this.bTime = bTime;
	}
	public Customer getcNo() {
		return cNo;
	}
	public void setcNo(Customer cNo) {
		this.cNo = cNo;
	}
	public Hairinfo gethNO() {
		return hNO;
	}
	public void sethNO(Hairinfo hNO) {
		this.hNO = hNO;
	}
	public HairEvent geteNo() {
		return eNo;
	}
	public void seteNo(HairEvent eNo) {
		this.eNo = eNo;
	}
	@Override
	public String toString() {
		return String.format("Biz [bNo=%s, bDate=%s, bTime=%s, cNo=%s, hNO=%s, eNo=%s]", bNo, bDate, bTime, cNo, hNO,
				eNo);
	}
	
	
	
}
