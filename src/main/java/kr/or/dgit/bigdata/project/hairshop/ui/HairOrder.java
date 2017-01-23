package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.lf5.util.DateFormatManager;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.list.ListTableSetting;
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
	private String[] eventArr; //= {"기획", "생일", "일반", "조조"};
	private String[] hairArr; //= {"커트", "드라이", "샴푸", "펌", "매직", "트리트먼트", "앰플", "기타"};
	private JComboBox cmbHName;
	private JComboBox cmbEName;
	private int hPriceInOrder;
	private Double dHe;
	private Date nowDate;
	private Time nowTime;
	private ListTableSetting table;
	private JPanel pnResult;
	private JScrollPane scrollPane;
	private JPanel pnCards;
	private JPanel pnImg;
	private CustomerManageInsert pnAddInput;
	
	/**
	 * Create the panel.
	 */
	public HairOrder() {
		setForeground(Color.BLUE);
		setBorder(new EmptyBorder(0, 0, 10, 0));
		setLayout(new GridLayout(0, 1, 0, 10));
		
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
		
		JPanel pnForCName = new JPanel();
		pnForOrderMain.add(pnForCName);
		pnForCName.setLayout(new BorderLayout(0, 0));
		
		tfCName = new JTextField();
		pnForCName.add(tfCName);
		tfCName.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSearchActionPerformed(arg0);
			}
		});
		pnForCName.add(btnSearch, BorderLayout.EAST);
		
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
		setArrOptionNames(); // 
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
		
		pnResult = new JPanel();
		add(pnResult);
		pnResult.setLayout(new GridLayout(0, 2, 0, 0));
		
		pnCards = new JPanel();
		pnResult.add(pnCards);
		pnCards.setLayout(new CardLayout(0, 0));
		
		pnImg = new JPanel();
		pnCards.add(pnImg, "name_31439583877535");
		JPanel pnSubAdd = new JPanel();
		ImageIcon iic = new ImageIcon(CustomerManageEdit.class.getResource("/img/desk.jpg"));
		JLabel label_4 = new JLabel("");
		Image img = iic.getImage();
		Image newimg = img.getScaledInstance( 450, 300, java.awt.Image.SCALE_SMOOTH );  
		iic = new ImageIcon( newimg );
		pnImg.setLayout(new BorderLayout(0, 0));
		label_4.setIcon(iic);
		pnImg.add(label_4);

		
		pnCards.add(pnSubAdd, "name_30981526616213");
		pnSubAdd.setLayout(new BorderLayout(0, 0));
		
		pnAddInput = new CustomerManageInsert();
		pnSubAdd.add(pnAddInput, BorderLayout.CENTER);
		
		JPanel pnAddBtnSub = new JPanel();
		pnSubAdd.add(pnAddBtnSub, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("회원 바로 등록");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddActionPerformed(arg0);
			}
		});
		pnAddBtnSub.add(btnAdd);
		
		scrollPane = new JScrollPane();
		pnResult.add(scrollPane);
		
		table = new ListTableSetting();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableMouseClicked(arg0);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
	}
	private void setArrOptionNames() {//옵션명들 입력
		List<Hairinfo> hList = HairinfoService.getInstance().selectHairInfoAll();
		List<HairEvent> eList = HairEventService.getInstance().selectEventAll();
		hairArr = new String[hList.size()+1];
		eventArr = new String[eList.size()+1];
		hairArr[0] = "--선택하세요--";
		eventArr[0] = "--선택하세요--";
		int j =0;
		for(int i=1;i < hList.size()+1;i++){
			
			hairArr[i] =hList.get(j).gethName();
			j++;
		}
		j=0;
		for(int i=1;i < eList.size()+1;i++){
			
			eventArr[i] =eList.get(j).geteName();
			j++;
		}
	}
	public void setTxtInOrder(int cNo, String cName){
		
		if (cNo != 0) {
			tfCNo.setText(cNo+"");
		}		
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
		int hNo = cmbHName.getSelectedIndex();
		if (hNo !=0) {
			Hairinfo h =  new Hairinfo(hNo);
			Hairinfo tempH = HairinfoService.getInstance().selectHairInfoByNo(h);
			tfHNo.setText(hNo+"");
			hPriceInOrder = Integer.parseInt(tempH.toString());
			tfHPrice.setText(String.format("%,d 원", hPriceInOrder));
			if(dHe != null){
				int totalPrice = (int)(hPriceInOrder *(1-dHe));// 거꾸로 수행시 총금액이 0원이 되지않게 함.		
				tfTotal.setText(String.format("%,d 원", totalPrice));
			}
		}
		
	}
	protected void cmbENameItemStateChanged(ItemEvent e) {
		int eNo = cmbEName.getSelectedIndex();
		if (eNo != 0) {
			HairEvent he = new HairEvent(eNo);
			HairEvent tempHe = HairEventService.getInstance().selectEventByNo(he);
			
			tfEDiscount.setText(tempHe.toString());
			tfENo.setText(eNo+"");
			
			dHe = Double.parseDouble(tempHe.toString());
			
			int totalPrice = (int)(hPriceInOrder *(1-dHe));
			
			tfTotal.setText(String.format("%,d 원", totalPrice));
		}
		
		
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
	
	
	public JTable getTable() {
		return table;
	}
	public void setTable(ListTableSetting table) {
		this.table = table;
	}
	public void reloadData() {
		table.setColumDataIndex(1);
		DefaultTableModel model = new DefaultTableModel(getRowData(tfCName.getText()), table.getColumnData()){
		    public boolean isCellEditable(int row, int column){
		      return false;//This causes all cells to be not editable
		    }
		  };
		table.setModel(model);
		table.tableSetAlignWidth();		
	}

	String[][] getRowData(String cName) {
		Map<String, Object> map = new HashMap<>();
		map.put("cName", cName);
		List<Customer> list = CustomerService.getInstance().searchCustomerByName(map);
		
		if (list.size() == 0) {//리스트 읽어들인뒤 결과따라 좌측 패널 연동
			List<Customer> listByAll = CustomerService.getInstance().selectByAll();
			int newCno =listByAll.size()+1;
			pnAddInput.getTxtCno().setText(newCno+"");
			pnAddInput.getTxtCname().setText(tfCName.getText());
			CardLayout cl = (CardLayout)(pnCards.getLayout());
	        cl.show(pnCards, "name_30981526616213");
	        
		}else if (list.size() > 0){
	      
	        if (list.size() == 1) {
				tfCNo.setText(list.get(0).getcNo()+"");	
			}
		}
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray();
		}
		
		return rowDatas;
	}

	protected void btnSearchActionPerformed(ActionEvent arg0) {
		CardLayout cl = (CardLayout)(pnCards.getLayout());
		cl.show(pnCards, "name_31439583877535");
		reloadData();
	}
	protected void btnAddActionPerformed(ActionEvent arg0) {
		int jop= JOptionPane.showConfirmDialog(null, pnAddInput.getTxtCname().getText()+" 신규회원 정보를 추가하겠습니까?");
		if (jop == 0) {
			pnAddInput.insertNewCostomer();
			tfCName.setText(pnAddInput.getTxtCname().getText());
			tfCNo.setText(pnAddInput.getTxtCno().getText());
		}
	}
	protected void tableMouseClicked(MouseEvent arg0) {
		try{
			String cNo = table.getValueAt(table.getSelectedRow(), 0).toString();
			String cName = table.getValueAt(table.getSelectedRow(), 1).toString();
			tfCNo.setText(cNo);
			tfCName.setText(cName);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("우클릭 이벤트는 일어나지 않습니다.");
		}
	}
}