package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.jfree.chart.ChartPanelP;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.list.CustomerHairTable;
import kr.or.dgit.bigdata.project.hairshop.list.CustomerSearchListForAll;
import kr.or.dgit.bigdata.project.hairshop.list.CustomerSearchListForOne;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;
import kr.or.dgit.bigdata.project.hairshop.service.ManagerService;
import kr.or.dgit.bigdata.project.hairshop.taps.PnCusSearch;
import kr.or.dgit.bigdata.project.hairshop.taps.PnHome;
import kr.or.dgit.bigdata.project.hairshop.taps.PnOrderList;
import kr.or.dgit.bigdata.project.hairshop.test.CustomerSearch;
import kr.or.dgit.bigdata.project.hairshop.ui.BizHairTotalReport;
import kr.or.dgit.bigdata.project.hairshop.ui.BizReport;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerManageEdit;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerManageInsert;
import kr.or.dgit.bigdata.project.hairshop.ui.HairOrder;
import kr.or.dgit.bigdata.project.hairshop.ui.HairOrderSearch;
import kr.or.dgit.bigdata.project.hairshop.ui.HomePanel;
import kr.or.dgit.bigdata.project.hairshop.ui.login.ManagerLogin;

public class HairMain<hip> extends JFrame {

	private JPanel contentPane;
	private PnHome pnHome;
	private JPanel pnCusSearch;
	private JPanel pnHairOder;
	private JPanel pnOrderList;
	private JPanel pnBizList;
	private JPanel pnBizGraph;  
	private JTabbedPane tabbedPane; //static으로 전환 
	private HomePanel pnHomeMain;
	private JPanel pnCusSearchCards;//static으로 전환 
	private JPanel pnCusSearchBtns;
	private JButton btnAdd;
	private JButton btnToMain1;
	private HairOrder pnHairOderMain;
	private JPanel pnHairOderBtns;
	private JButton btnOrder;
	private JButton btnToMain2;
	private HairOrderSearch pnOrderListMain;
	private JPanel pnOrderListBtns;
	private JButton btnToMain3;
	private BizReport pnBizListMain;
	private JPanel pnBizGraphMain;
	private JButton btnSave;
	private JButton btnHairInfo;
	private CustomerSearch pnSearchSub;
	private CustomerManageInsert pnCusAdd;
	private CustomerManageEdit pnCusEdit;
	private JButton btnSearch;	
	private int cNo;
	private String cName;
	private String dob;
	private String doJoin;
	private String phone;
	private CustomerSearchListForOne tableInSearch;
	private CustomerSearchListForAll tableInSearchForAll;	
	private CustomerHairTable hip;
	private int cardIndex; // 0은 검색, 1은 추가, 2는 수정
	private BizHairTotalReport panel_1;
	private ChartPanelP panel;
	private JFreeChart chart;
	private JPopupMenu popup;
	private JLabel lblTextTest;

	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public HairMain()  {
		setTitle("DGIT HAIR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		/* 고객 헤어 정보를  보여줄 table을 담고있는 패널 ver.이유진*/		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);		
		pnHome = new PnHome(); // 부모 = 자식 관계 
		pnHome.getPnHomeMain().getcSearch().addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				switchTab(1);
			}
		});
		pnHome.getPnHomeMain().getcAdd().addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				switchTab(1);
				showThisCard("name_1666358524774753");	
				btnSaveTrueAction();			   
			}			
		});
		pnHome.getPnHomeMain().gethOrder().addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				switchTab(2);
			}
		});
		pnHome.getPnHomeMain().getBtnManager().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnManagerActionPerformed(arg0);
			}			
		});
		tabbedPane.remove(pnBizList);
		tabbedPane.remove(pnBizGraph);
		pnHome.getPnHomeMain().getBtnLogout().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.remove(pnBizList);
				tabbedPane.remove(pnBizGraph);
				pnHomeMain.getBtnLogout().setVisible(false);
			}			
		});
		tabbedPane.addTab("홈", null, pnHome, null);
		
		pnCusSearch = new PnCusSearch();
		tabbedPane.addTab("고객검색", null, pnCusSearch, null);
		setBtnAdd(new JButton("회원추가"));
		getBtnAdd().setForeground(Color.DARK_GRAY);
		getBtnAdd().setBounds(2, 156, 140, 156);		
		getBtnAdd().setBorderPainted(false);
		getBtnAdd().setFocusPainted(false);
		getBtnAdd().setContentAreaFilled(true);
		getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		getBtnAdd().setBackground(new Color(248, 248, 255));
		pnHairOder = new JPanel();
		tabbedPane.addTab("헤어주문", null, pnHairOder, null);
		pnHairOder.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				pnHairOderComponentShown(arg0);
			}
		});
		pnOrderList = new PnOrderList();
		tabbedPane.addTab("헤어주문검색", null, pnOrderList, null);
		tabbedPane.setEnabledAt(3, false); // true로 바꾸면 활성화
		pnBizList = new JPanel();		
		
	}
//액션 리스너 메소드//////////////////////////////////////////////////////////
	public JPanel getPnCusSearchCards() {
		return pnCusSearchCards;
	}

	public void setPnCusSearchCards(JPanel pnCusSearchCards) {
		this.pnCusSearchCards = pnCusSearchCards;
	} 


	protected void btnAddActionPerformed(ActionEvent e) {
		showThisCard("name_1666358524774753");
        btnSave.setEnabled(true);
        cardIndex =1;        
        List<Customer> customerForSize = CustomerService.getInstance().selectByAll();// 카운트 할 sql문을 만드는 게 좋음. 현재 임시용.
        int txtCno =customerForSize.size()+1;
        pnCusAdd.getTxtCno().setText(txtCno+"");
        
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		pnSearchSub.revalidate();		
		showThisCard("name_1666323161344197");        
        btnSave.setEnabled(false);
        cardIndex =0;
	}

	protected void btnSaveActionPerformed(ActionEvent e) {
		switch (cardIndex) {
		case 1:
			pnCusAdd.insertNewCostomer();
			int directOderInAdd = JOptionPane.showConfirmDialog(null, "해당 고객 번호로 바로 주문 하시겠습니까?");
			if(directOderInAdd==0){
				pnHairOderMain.setTxtInOrder(Integer.parseInt(pnCusAdd.getTxtCno().getText()),pnCusAdd.getTxtCname().getText());
				tabbedPane.setSelectedComponent(pnHairOder);
				
			}
			cardIndex =0;
			
			break;
		case 2:
			pnCusEdit.setTxtInCusEditForUpdate();
			int directOderInEdit = JOptionPane.showConfirmDialog(null, "해당 고객 번호로 바로 주문 하시겠습니까?");
			if(directOderInEdit==0){
				pnHairOderMain.setTxtInOrder(Integer.parseInt(pnCusEdit.getTxtCno().getText()),pnCusEdit.getTxtCname().getText());
				tabbedPane.setSelectedComponent(pnHairOder);
				
			}
			cardIndex =0;
			break;
		
		default:  
			break;  
		}  
		
	}
	protected void btnHairInfoActionPerformed(ActionEvent e) { // 테이블 보이기 추가
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setSelectedComponent(pnOrderList);
		Customer c = CustomerService.getInstance().searchCustomerByNo(Integer.parseInt(pnHairOderMain.getTfCNo().getText()));	
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		pnOrderListMain.setTxtInHairIfo(c.getcNo(), c.getcName(), dfm.format(c.getcDob()));
		hip.setTableWithData(c);

	}
	protected void btnToMainActionPerformed(ActionEvent e) {
		tabbedPane.setSelectedComponent(pnHome);
	}
	protected void btnOrderActionPerformed(ActionEvent e) {
		pnHairOderMain.insertBizByOrder();
		
	}
	
	private void clickAndGetDataFromTable(JTable table) {
		
		cNo = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()); // 선택한 열의 0번째 인덱스 행을 출력
		cName = table.getValueAt(table.getSelectedRow(), 1).toString();
		dob = table.getValueAt(table.getSelectedRow(), 2).toString();
		doJoin = table.getValueAt(table.getSelectedRow(), 3).toString();
		phone = table.getValueAt(table.getSelectedRow(), 4).toString();
		
		pnCusEdit.setTxtInCusEdit(cNo, cName, dob, doJoin, phone);
		pnOrderListMain.setTxtInHairIfo(cNo, cName, dob);
		pnOrderListMain.reloadData();
		
		
	}
	protected void pnSearchSubTableForAllMouseReleased(MouseEvent e ,JTable jt) {
		
		
		int r = jt.rowAtPoint(e.getPoint());
        if (r >= 0 && r < jt.getRowCount()) {
        	jt.setRowSelectionInterval(r, r);
        } else {
        	jt.clearSelection();
        }

        int rowindex = jt.getSelectedRow();
        if (rowindex < 0)
            return;
        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
        	clickAndGetDataFromTable(jt);
        	JPopupMenu popup = new JPopupMenu(); //우클릭시 팝업 메뉴 등장
    		popup.add(new JMenuItem(new AbstractAction("수정") {
                public void actionPerformed(ActionEvent e) {
                	showThisCard("name_1666378783739869");
        	        btnSave.setEnabled(true);
        	        cardIndex =2;
        	        pnHairOderMain.setTxtInOrder(cNo, cName); // 수정된 내역이 있더라도 DB와 관련된것은 변동이 없는 cNo뿐이라 무관함. 
        			
                }
            }));
    		popup.add(new JMenuItem(new AbstractAction("삭제") {
    	            public void actionPerformed(ActionEvent e) {
    	            	int jopi = JOptionPane.showConfirmDialog(null, cName+"회원을 정말 삭제하시겠습니까?");
    	    			if (jopi == 0) {
    	    				Customer cForDel = new Customer();
    	    				cForDel.setcDel(true);
    	    				cForDel.setcNo(cNo);
    	    				CustomerService.getInstance().deleteCustomer(cForDel);
    	    			}
    	            }
    	    }));
    		popup.add(new JMenuItem(new AbstractAction("주문") {
    	            public void actionPerformed(ActionEvent e) {
    	            	tabbedPane.setSelectedComponent(pnHairOder);
    	    			pnHairOderMain.setTxtInOrder(cNo, cName);
    	    			tabbedPane.setEnabledAt(3, true);
    	            }
    	    }));
    		popup.add(new JMenuItem(new AbstractAction("헤어정보") {
    	            public void actionPerformed(ActionEvent e) {
    	            	tabbedPane.setEnabledAt(3, true);
    	    			tabbedPane.setSelectedComponent(pnOrderList);
    	    			hip.setTableWithData(new Customer(cNo));
    	            }
    	    }));
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
	}
	private void btnManagerActionPerformed(ActionEvent arg0) {//관리자 로그인 버튼 이벤트 리스너
		ManagerLogin ml = new ManagerLogin();
		ml.setVisible(true); 
		ml.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Manager manager =  new Manager();
				manager.setmName(ml.getTxtId().getText());
				Manager temp = ManagerService.getInstance().selectmPasswordByName(manager);
				char[] pass = ml.getPasswordField().getPassword();
				String userPass ="";
				for (char c : pass) { 
					userPass +=c;
				}
				if (temp.getmPassword().equals(userPass)) {
					tabbedPane.addTab("영업현황", null, pnBizList, null);
					tabbedPane.addTab("영업그래프", null, pnBizGraph, null);
					pnHomeMain.getBtnLogout().setVisible(true);
					ml.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "해당 아이디가 존재하지 않거나 비밀번호가 틀립니다.");
					ml.getTxtId().requestFocus();
					tabbedPane.remove(pnBizList);
					tabbedPane.remove(pnBizGraph);
				}
				
			}
		});
				
	}
	
	public void switchTab(int index){
		tabbedPane.setSelectedIndex(index);
	}	
	
	protected void pnHairOderComponentShown(ComponentEvent arg0) {
		pnHairOderMain.setTxtInOrder(cNo, cName);		
	}
	public void showThisCard(String string) {
		CardLayout cl = (CardLayout)(pnCusSearchCards.getLayout());
        cl.show(pnCusSearchCards, string);
	}
	public static JButton getBtnAdd() {
		return btnAdd;
	}


	public static void setBtnAdd(JButton btnAdd) {
		HairMain.btnAdd = btnAdd;
	}


	public static JTabbedPane getTabbedPane() {
		return tabbedPane;
	}


	public static void setTabbedPane(JTabbedPane tabbedPane) {
		HairMain.tabbedPane = tabbedPane;
	}
	private void btnSaveTrueAction() {
		 btnSave.setEnabled(true);
		 cardIndex =1;			        
		 List<Customer> customerForSize = CustomerService.getInstance().selectByAll();// 카운트 할 sql문을 만드는 게 좋음. 현재 임시용.
		 int txtCno =customerForSize.size()+1;
		 pnCusAdd.getTxtCno().setText(txtCno+"");
	}	
}