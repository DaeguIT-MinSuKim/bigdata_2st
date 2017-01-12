package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.lf5.util.DateFormatManager;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;
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

	/**
	 * Create the panel.
	 */
	public HairOrder() {
		setForeground(Color.BLUE);
		setBorder(new EmptyBorder(15, 10, 10, 10));
		setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblBNo = new JLabel("영업번호");
		lblBNo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBNo);
		
		tfBNo = new JTextField();
		add(tfBNo);
		tfBNo.setColumns(10);
		
		JLabel lblGap1 = new JLabel("");
		add(lblGap1);
		
		JLabel lblGap2 = new JLabel("");
		add(lblGap2);
		
		JLabel lblBData = new JLabel("영업일자");
		lblBData.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBData);
		
		tfBDate = new JTextField();
		add(tfBDate);
		tfBDate.setColumns(10);
		
		JLabel lblBTime = new JLabel("방문시간");
		lblBTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBTime);
		
		tfBTime = new JTextField();
		add(tfBTime);
		tfBTime.setColumns(10);
		
		JLabel lblCName = new JLabel("고객명");
		lblCName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCName);
		
		tfCName = new JTextField();
		tfCName.setEditable(false);
		add(tfCName);
		tfCName.setColumns(10);
		
		JLabel lblCNO = new JLabel("고객번호");
		lblCNO.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCNO);
		
		tfCNo = new JTextField();
		tfCNo.setEditable(false);
		add(tfCNo);
		tfCNo.setColumns(10);
		
		JLabel lblHName = new JLabel("헤어명");
		lblHName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHName);
		
		cmbHName = new JComboBox();
		cmbHName.setModel(new DefaultComboBoxModel(hairArr));
		add(cmbHName);
		
		JLabel lblHNO = new JLabel("헤어번호");
		lblHNO.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHNO);
		
		tfHNo = new JTextField();
		add(tfHNo);
		tfHNo.setColumns(10);
		
		JLabel lblHPrice = new JLabel("단가");
		lblHPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHPrice);
		
		tfHPrice = new JTextField();
		add(tfHPrice);
		tfHPrice.setColumns(10);
		
		JLabel lblGap3 = new JLabel("");
		add(lblGap3);
		
		JLabel lblGap4 = new JLabel("");
		add(lblGap4);
		
		JLabel lblEName = new JLabel("이벤트명");
		lblEName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEName);
		
		cmbEName = new JComboBox();
		cmbEName.setModel(new DefaultComboBoxModel(eventArr));
		add(cmbEName);
		
		JLabel lblEDiscount = new JLabel("할인율");
		lblEDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEDiscount);
		
		tfEDiscount = new JTextField();
		add(tfEDiscount);
		tfEDiscount.setColumns(10);
		
		JLabel lblENO = new JLabel("이벤트번호");
		lblENO.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblENO);
		
		tfENo = new JTextField();
		add(tfENo);
		tfENo.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("금액");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalPrice);
		
		tfTotal = new JTextField();
		add(tfTotal);
		tfTotal.setColumns(10);
		
		
	}
	public void setTxtInOrder(int cNo, String cName){
		tfCNo.setText(cNo+"");
		tfCName.setText(cName);
		
		List<Biz> bList = BizService.getInstance().selectAllBiz();
		int bNo = bList.size()+1;
		tfBNo.setText(bNo+"");
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		Date nowDate = new Date(); 		
		tfBDate.setText(dfm.format(nowDate));
		Time nowTime =new Time(nowDate.getTime());
		tfBTime.setText(nowTime.toString());
		
		int hNo = cmbHName.getSelectedIndex()+1;
		Hairinfo h =  new Hairinfo(hNo);
		Hairinfo tempH = HairinfoService.getInstance().selectHairInfoByNo(h);
		
		tfHNo.setText(hNo+"");
		tfHPrice.setText(tempH.toString());
		
		
		int eNo = cmbEName.getSelectedIndex()+1;
		HairEvent he = new HairEvent(eNo);
		HairEvent tempHe = HairEventService.getInstance().selectEventByNo(he);
		
		tfEDiscount.setText(tempHe.toString());
		tfENo.setText(eNo+"");
		
		double totalPrice = Integer.parseInt(tempH.toString())*(1-Double.parseDouble(tempHe.toString()));
		int tp = (int)totalPrice;
		//h.hPrice*(1-e.eDiscount)
		tfTotal.setText(tp+"");
		
	}
	
}