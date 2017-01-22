package kr.or.dgit.bigdata.project.hairshop.dto;

public class Manager {
	private int mNo;
	private String mName;
	private String mPassword;
	
	
	public int getmNo() {
		return mNo;
	}


	public void setmNo(int mNo) {
		this.mNo = mNo;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getmPassword() {
		return mPassword;
	}


	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}


	@Override
	public String toString() {
		return String.format("%s", mName);
	}
	
	public String[] toArray(){
		return new String[]{mNo+"", mName};
	}
}
