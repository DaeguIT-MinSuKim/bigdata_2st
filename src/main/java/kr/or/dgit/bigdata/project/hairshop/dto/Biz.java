package kr.or.dgit.bigdata.project.hairshop.dto;

import java.sql.Time;
import java.util.Date;

import org.apache.log4j.lf5.util.DateFormatManager;

public class Biz {
	private int bNo;
	private Date bDate;
	private Time bTime; // java.util.* 이 아닌 java.sql.Time 로 import해서 사용함.
	private Customer bcNo;
	private Hairinfo bhNo;
	private HairEvent beNo;
	private Date bDateStart;
	private Date bDateEnd;
	private int totalCustomer;
	private int totalBiz;
	private int totalMoney;
	
	
	public int getTotalCustomer() {
		return totalCustomer;
	}
	public void setTotalCustomer(int totalCustomer) {
		this.totalCustomer = totalCustomer;
	}
	public int getTotalBiz() {
		return totalBiz;
	}
	public void setTotalBiz(int totalBiz) {
		this.totalBiz = totalBiz;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
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
	public Customer getBcNo() {
		return bcNo;
	}
	public void setBcNo(Customer bcNo) {
		this.bcNo = bcNo;
	}
	public Hairinfo getBhNo() {
		return bhNo;
	}
	public void setBhNo(Hairinfo bhNo) {
		this.bhNo = bhNo;
	}
	public HairEvent getBeNo() {
		return beNo;
	}
	public void setBeNo(HairEvent beNo) {
		this.beNo = beNo;
	}
	public Date getbDateStart() {
		return bDateStart;
	}
	public void setbDateStart(Date bDateStart) {
		this.bDateStart = bDateStart;
	}
	public Date getbDateEnd() {
		return bDateEnd;
	}
	public void setbDateEnd(Date bDateEnd) {
		this.bDateEnd = bDateEnd;
	}
	
	public String getBizPrice() {	
		//주문금액 가져오는 메소드(toArray용)
		return String.format("%,d원", (int)(bhNo.gethPrice()*(1-beNo.geteDiscount())));
	}
	@Override
	public String toString() {
		return String.format("Biz [bNo=%s, bDate=%s, bTime=%s, cNo=%s, hNO=%s, eNo=%s]", bNo, bDate, bTime, bcNo, bhNo,
				beNo);
	}
	
	public String[] toArray(Boolean isReport) {
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		if(isReport==true){			
			return new String[]{bNo+"", dfm.format(bDate), bcNo.getcName(), bhNo.gethName(), beNo.geteName(), getBizPrice()};
		}else{
			return new String[]{bNo+"", dfm.format(bDate), bhNo.gethName(), bhNo.gethPriceForm(), beNo.geteName(), getBizPrice()};
		}
		
	}
	
}
