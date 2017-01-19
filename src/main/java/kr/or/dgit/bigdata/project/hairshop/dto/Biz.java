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
	private int cNo;
	private int hNo;
	private int eNo;
	private int totalCustomer;
	private int totalBiz;
	private int totalMoney;
	public int getcNo() {
		return cNo;
	}
	public void setcNo() {
		this.cNo = bcNo.getcNo();
	}
	public int gethNo() {
		return hNo;
	}
	public void sethNo() {
		this.hNo = bhNo.gethNo();
	}
	public int geteNo() {
		return eNo;
	}
	public void seteNo() {
		this.eNo = beNo.geteNo();
	}
	
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
		setcNo();
	}
	public Hairinfo getBhNo() {
		return bhNo;
	}
	public void setBhNo(Hairinfo bhNo) {
		this.bhNo = bhNo;
		sethNo();
	}
	public HairEvent getBeNo() {
		return beNo;
	}
	public void setBeNo(HairEvent beNo) {
		this.beNo = beNo;
		seteNo();
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
	
	public String[] toCSArray() {
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		return new String[]{bNo+"", dfm.format(bDate), bhNo.gethName(), bhNo.gethPriceForm(), beNo.geteName(), getBizPrice()};		
	}
	
	public String[] toBizArray() {
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");	
		return new String[]{bNo+"", dfm.format(bDate), bcNo.getcName(), bhNo.gethName(), beNo.geteName(), getBizPrice()};
	}
	
	/*코드 정리 중 삭제할 코드 */
	public String[] toArray(Boolean isReport) {
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		if(isReport==true){			
			return new String[]{bNo+"", dfm.format(bDate), bcNo.getcName(), bhNo.gethName(), beNo.geteName(), getBizPrice()};
		}else{
			return new String[]{bNo+"", dfm.format(bDate), bhNo.gethName(), bhNo.gethPriceForm(), beNo.geteName(), getBizPrice()};
		}
		
	}
}
