package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.lf5.util.DateFormatManager;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;
import kr.or.dgit.bigdata.project.hairshop.service.HairEventService;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

public class HairOrder extends JPanel {
	private JTextField tfBNo;
	private JTextField tfBDate;
	private JTextField tfBTime;
	private JTextField tfCName;
	private JTextField tfCNo;
	private JTextField tfHNo;
	private JTextField tfHPrice;
	private JTextField tfEDiscount;
	private JTextField tfENo;
	private JTextField tfTotal;
	 String[] eventArr = {"기획", "생일", "일반", "조조"};
	String[] hairArr = {"커트", "드라이", "샴푸", "펌", "매직", "트리트먼트", "앰플", "기타"};
	private JComboBox cmbHName;
	private JComboBox cmbEName;
	private int hPriceInOrder;
	private Double dHe;
	private Date nowDate;
	private Time nowTime;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public HairOrder() {
		setForeground(Color.BLUE);
		setBorder(new EmptyBorder(0, 0, 10, 0));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnForOrderMain = new JPanel();
		add(pnForOrderMain);
		pnForOrderMain.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblBNo = new JLabel("영업번호");
		pnForOrderMain.add(lblBNo);
		lblBNo.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfBNo = new JTextField();
		pnForOrderMain.add(tfBNo);
		tfBNo.setEditable(false);
		tfBNo.setColumns(10);
		
		JLabel lblGap1 = new JLabel("");
		pnForOrderMain.add(lblGap1);
		
		JLabel lblGap2 = new JLabel("");
		pnForOrderMain.add(lblGap2);
		
		JLabel lblBData = new JLabel("영업일자");
		pnForOrderMain.add(lblBData);
		lblBData.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfBDate = new JTextField();
		pnForOrderMain.add(tfBDate);
		tfBDate.setEditable(false);
		tfBDate.setColumns(10);
		
		JLabel lblBTime = new JLabel("방문시간");
		pnForOrderMain.add(lblBTime);
		lblBTime.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfBTime = new JTextField();
		pnForOrderMain.add(tfBTime);
		tfBTime.setEditable(false);
		tfBTime.setColumns(10);
		
		JLabel lblCName = new JLabel("고객명");
		pnForOrderMain.add(lblCName);
		lblCName.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfCName = new JTextField();
		pnForOrderMain.add(tfCName);
		tfCName.setEditable(false);
		tfCName.setColumns(10);
		
		JLabel lblCNO = new JLabel("고객번호");
		pnForOrderMain.add(lblCNO);
		lblCNO.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfCNo = new JTextField();
		pnForOrderMain.add(tfCNo);
		tfCNo.setEditable(false);
		tfCNo.setColumns(10);
		
		JLabel lblHName = new JLabel("헤어명");
		pnForOrderMain.add(lblHName);
		lblHName.setHorizontalAlignment(SwingConstants.CENTER);
		
		cmbHName = new JComboBox();
		pnForOrderMain.add(cmbHName);
		cmbHName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cmbHNameItemStateChanged(arg0);
			}
		});
		cmbHName.setModel(new DefaultComboBoxModel(hairArr));
		
		JLabel lblHNO = new JLabel("헤어번호");
		pnForOrderMain.add(lblHNO);
		lblHNO.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfHNo = new JTextField();
		pnForOrderMain.add(tfHNo);
		tfHNo.setColumns(10);
		
		JLabel lblHPrice = new JLabel("단가");
		pnForOrderMain.add(lblHPrice);
		lblHPrice.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfHPrice = new JTextField();
		pnForOrderMain.add(tfHPrice);
		tfHPrice.setColumns(10);
		
		JLabel lblGap3 = new JLabel("");
		pnForOrderMain.add(lblGap3);
		
		JLabel lblGap4 = new JLabel("");
		pnForOrderMain.add(lblGap4);
		
		JLabel lblEName = new JLabel("이벤트명");
		pnForOrderMain.add(lblEName);
		lblEName.setHorizontalAlignment(SwingConstants.CENTER);
		
		cmbEName = new JComboBox();
		pnForOrderMain.add(cmbEName);
		cmbEName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cmbENameItemStateChanged(e);
			}
		});
		cmbEName.setModel(new DefaultComboBoxModel(eventArr));
		
		JLabel lblEDiscount = new JLabel("할인율");
		pnForOrderMain.add(lblEDiscount);
		lblEDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfEDiscount = new JTextField();
		pnForOrderMain.add(tfEDiscount);
		tfEDiscount.setColumns(10);
		
		JLabel lblENO = new JLabel("이벤트번호");
		pnForOrderMain.add(lblENO);
		lblENO.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfENo = new JTextField();
		pnForOrderMain.add(tfENo);
		tfENo.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("금액");
		pnForOrderMain.add(lblTotalPrice);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfTotal = new JTextField();
		pnForOrderMain.add(tfTotal);
		tfTotal.setColumns(10);
		
		JPanel pnForTableAndIcons = new JPanel();
		add(pnForTableAndIcons, BorderLayout.SOUTH);
		pnForTableAndIcons.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		pnForTableAndIcons.add(table);
		
		
		
	}
	public void setTxtInOrder(int cNo, String cName){
		tfCNo.setText(cNo+"");
		tfCName.setText(cName);
		
		List<Biz> bList = BizService.getInstance().selectAllBiz();
		int bNo = bList.size()+1;
		tfBNo.setText(bNo+"");
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		nowDate = new Date(); 		
		tfBDate.setText(dfm.format(nowDate));
		nowTime = new Time(nowDate.getTime());
		tfBTime.setText(nowTime.toString());
		
	}
	
	protected void cmbHNameItemStateChanged(ItemEvent arg0) {
		int hNo = cmbHName.getSelectedIndex()+1;
		Hairinfo h =  new Hairinfo(hNo);
		Hairinfo tempH = HairinfoService.getInstance().selectHairInfoByNo(h);
		tfHNo.setText(hNo+"");
		hPriceInOrder = Integer.parseInt(tempH.toString());
		tfHPrice.setText(String.format("%,d 원", hPriceInOrder));
		
		int totalPrice = (int)(hPriceInOrder *(1-dHe));// 거꾸로 수행시 총금액이 0원이 되지않게 함.
		tfTotal.setText(String.format("%,d 원", totalPrice));
	}
	protected void cmbENameItemStateChanged(ItemEvent e) {
		int eNo = cmbEName.getSelectedIndex()+1;
		HairEvent he = new HairEvent(eNo);
		HairEvent tempHe = HairEventService.getInstance().selectEventByNo(he);
		
		tfEDiscount.setText(tempHe.toString());
		tfENo.setText(eNo+"");
		
		dHe = Double.parseDouble(tempHe.toString());
		
		int totalPrice = (int)(hPriceInOrder *(1-dHe));
		
		tfTotal.setText(String.format("%,d 원", totalPrice));
	}
	
	public void insertBizByOrder(){
		
		
		Biz biz = new Biz();
		biz.setbDate(nowDate);
		biz.setbDate(nowTime);
		
		Customer bcNo = CustomerService.getInstance().searchCustomerByNo(Integer.parseInt(tfCNo.getText()));		
		Hairinfo bhNo = HairinfoService.getInstance().selectHairInfoByNo(new Hairinfo(Integer.parseInt(tfHNo.getText())));
		HairEvent beNo = HairEventService.getInstance().selectEventByNo(new HairEvent(Integer.parseInt(tfENo.getText())));
		
		biz.setBcNo(bcNo);
		biz.setBhNo(bhNo);		
		biz.setBeNo(beNo);
		
		BizService.getInstance().insertBiz(biz);
		
	}
	public JTextField getTfBNo() {
		return tfBNo;
	}
	public void setTfBNo(JTextField tfBNo) {
		this.tfBNo = tfBNo;
	}
	public JTextField getTfBDate() {
		return tfBDate;
	}
	public void setTfBDate(JTextField tfBDate) {
		this.tfBDate = tfBDate;
	}
	public JTextField getTfBTime() {
		return tfBTime;
	}
	public void setTfBTime(JTextField tfBTime) {
		this.tfBTime = tfBTime;
	}
	public JTextField getTfCName() {
		return tfCName;
	}
	public void setTfCName(JTextField tfCName) {
		this.tfCName = tfCName;
	}
	public JTextField getTfCNo() {
		return tfCNo;
	}
	public void setTfCNo(JTextField tfCNo) {
		this.tfCNo = tfCNo;
	}
	public JTextField getTfHNo() {
		return tfHNo;
	}
	public void setTfHNo(JTextField tfHNo) {
		this.tfHNo = tfHNo;
	}
	public JTextField getTfHPrice() {
		return tfHPrice;
	}
	public void setTfHPrice(JTextField tfHPrice) {
		this.tfHPrice = tfHPrice;
	}
	public JTextField getTfEDiscount() {
		return tfEDiscount;
	}
	public void setTfEDiscount(JTextField tfEDiscount) {
		this.tfEDiscount = tfEDiscount;
	}
	public JTextField getTfENo() {
		return tfENo;
	}
	public void setTfENo(JTextField tfENo) {
		this.tfENo = tfENo;
	}
	public JTextField getTfTotal() {
		return tfTotal;
	}
	public void setTfTotal(JTextField tfTotal) {
		this.tfTotal = tfTotal;
	}
	
}