package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.AbstractAction;
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

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;
import kr.or.dgit.bigdata.project.hairshop.service.ManagerService;
import kr.or.dgit.bigdata.project.hairshop.taps.PnAdmin;
import kr.or.dgit.bigdata.project.hairshop.taps.PnBizGraph;
import kr.or.dgit.bigdata.project.hairshop.taps.PnBizList;
import kr.or.dgit.bigdata.project.hairshop.taps.PnCusSearch;
import kr.or.dgit.bigdata.project.hairshop.taps.PnHairOder;
import kr.or.dgit.bigdata.project.hairshop.taps.PnHome;
import kr.or.dgit.bigdata.project.hairshop.taps.PnOrderList;
import kr.or.dgit.bigdata.project.hairshop.ui.HomePanel;
import kr.or.dgit.bigdata.project.hairshop.ui.login.ManagerLogin;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class HairMain extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private PnHome pnHome;
	private PnCusSearch pnCusSearch;
	private PnHairOder pnHairOder;
	private PnOrderList pnOrderList;
	private PnBizList pnBizList;//
	private PnBizGraph pnBizGraph;
	private JTabbedPane tabbedPane;  
	private HomePanel pnHomeMain;	
	private int cNo;
	private String cName;
	private String dob;
	private String doJoin;
	private String phone;
	private int cardIndex; // 0은 검색, 1은 추가, 2는 수정
	private JPopupMenu popup;
	private JLabel lblTextTest;
	private PnAdmin pnAdmin;
	
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
		tabbedPane.addChangeListener(this);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		try {
			InputStream isNG = HairMain.class.getResourceAsStream("NANUMGOTHIC.TTF");
			Font nanumG = Font.createFont(Font.TRUETYPE_FONT, isNG);
			Font nanumGothic = nanumG.deriveFont(0, 20f);
			tabbedPane.setFont(nanumGothic);
		} catch (FontFormatException | IOException e1) {

		}
		contentPane.add(tabbedPane, BorderLayout.CENTER);		
		pnHome = new PnHome();//pnHome
		pnHome.getPnHomeMain().getcSearch().addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				switchTab(1);
				pnCusSearch.getPnSearchSub().revalidate();
				showThisCard("name_1666323161344197");
				pnCusSearch.getBtnSave().setEnabled(false);
				cardIndex =0;
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
		tabbedPane.addTab("홈", null, pnHome, null);	//pnHome 탭 끝. 로그아웃 연동 추가 요망	
		pnCusSearch = new PnCusSearch();//pnCusSearch
		pnCusSearch.getPnSearchSub().getTableForAll().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				pnSearchSubTableForAllMouseReleased(arg0 ,pnCusSearch.getTableInSearchForAll());//
			}
		});
		pnCusSearch.getPnSearchSub().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				pnSearchSubTableForAllMouseReleased(arg0, pnCusSearch.getTableInSearch());//
			}
		});
		pnCusSearch.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		pnCusSearch.getBtnAdd().addActionListener(new ActionListener() {//회원추가 패널 이동 버튼
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		pnCusSearch.getBtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSaveActionPerformed(arg0);
			}
		});
		pnCusSearch.getBtnToMain1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToMainActionPerformed(e);
			}
		});
		tabbedPane.addTab("고객검색", null, pnCusSearch, null);			
		pnHairOder = new PnHairOder();//pnHairOder
		pnHairOder.getBtnOrder().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOrderActionPerformed(arg0);
			}
		});
		pnHairOder.getBtnHairInfo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHairInfoActionPerformed(e);
			}
		});
		pnHairOder.getBtnToMain2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToMainActionPerformed(e);
			}
		});
		tabbedPane.addTab("헤어주문", null, pnHairOder, null);//pnHairOrder 끝			
		pnOrderList = new PnOrderList();//pnOrderList
		pnOrderList.getBtnToMain3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToMainActionPerformed(e);
			}
		});
		tabbedPane.addTab("헤어주문검색", null, pnOrderList, null);
		tabbedPane.setEnabledAt(3, false); // true로 바꾸면 활성화
		pnBizList = new PnBizList();
		pnBizList.setTabbedPane(tabbedPane);
		pnBizGraph = new PnBizGraph();
		pnAdmin = new PnAdmin();
		pnAdmin.setTabbedPane(tabbedPane);
	}
//액션 리스너 메소드//////////////////////////////////////////////////////////
	protected void btnAddActionPerformed(ActionEvent e) {
		showThisCard("name_1666358524774753");
		pnCusSearch.getBtnSave().setEnabled(true);
        cardIndex =1;        
        List<Customer> customerForSize = CustomerService.getInstance().selectByAll();// 카운트 할 sql문을 만드는 게 좋음. 현재 임시용.
        int txtCno =customerForSize.size()+1;
        pnCusSearch.getPnCusAdd().getTxtCno().setText(txtCno+"");
        pnCusSearch.getBtnAdd().setEnabled(false);
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		pnCusSearch.getPnSearchSub().revalidate();		
		showThisCard("name_1666323161344197");        
		pnCusSearch.getBtnSave().setEnabled(false);
        cardIndex =0;
        pnCusSearch.getBtnAdd().setEnabled(true);
	}
	protected void btnSaveActionPerformed(ActionEvent e) {
		switch (cardIndex) {
		case 1:
			pnCusSearch.getPnCusAdd().insertNewCostomer();
			int directOderInAdd = JOptionPane.showConfirmDialog(null, "해당 고객 번호로 바로 주문 하시겠습니까?");
			if(directOderInAdd==0){
				pnHairOder.getPnHairOderMain().setTxtInOrder(Integer.parseInt(pnCusSearch.getPnCusAdd().getTxtCno().getText()),pnCusSearch.getPnCusAdd().getTxtCname().getText());
				tabbedPane.setSelectedComponent(pnHairOder);				
			}
			cardIndex =0;			
			break;
		case 2:
			pnCusSearch.getPnCusEdit().setTxtInCusEditForUpdate();
			int directOderInEdit = JOptionPane.showConfirmDialog(null, "해당 고객 번호로 바로 주문 하시겠습니까?");
			if(directOderInEdit==0){
				pnHairOder.getPnHairOderMain().setTxtInOrder(Integer.parseInt(pnCusSearch.getPnCusEdit().getTxtCno().getText()),pnCusSearch.getPnCusEdit().getTxtCname().getText());
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
		Customer c = CustomerService.getInstance().searchCustomerByNo(Integer.parseInt(pnHairOder.getPnHairOderMain().getTfCNo().getText()));	
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		pnOrderList.getPnOrderListMain().setTxtInHairIfo(c.getcNo(), c.getcName(), dfm.format(c.getcDob()));
		pnOrderList.getPnOrderListMain().reloadData();
	}
	protected void btnToMainActionPerformed(ActionEvent e) {
		tabbedPane.setSelectedComponent(pnHome);
	}
	protected void btnOrderActionPerformed(ActionEvent e) {
		pnHairOder.getPnHairOderMain().insertBizByOrder();		
	}	
	private void clickAndGetDataFromTable(JTable table) {		
		cNo = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()); // 선택한 열의 0번째 인덱스 행을 출력
		cName = table.getValueAt(table.getSelectedRow(), 1).toString();
		dob = table.getValueAt(table.getSelectedRow(), 2).toString();
		doJoin = table.getValueAt(table.getSelectedRow(), 3).toString();
		phone = table.getValueAt(table.getSelectedRow(), 4).toString();		
		pnCusSearch.getPnCusEdit().setTxtInCusEdit(cNo, cName, dob, doJoin, phone);
		pnOrderList.getPnOrderListMain().setTxtInHairIfo(cNo, cName, dob);
		pnOrderList.getPnOrderListMain().reloadData();		
		pnHairOder.getPnHairOderMain().setTxtInOrder(cNo, cName);//고객검색 후 헤어주문 서브 테이블도 내용을 자동 반영되게 함.
		pnHairOder.getPnHairOderMain().reloadData();
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
                	pnCusSearch.getBtnSave().setEnabled(true);
        	        cardIndex =2;
        	        pnHairOder.getPnHairOderMain().setTxtInOrder(cNo, cName); // 수정된 내역이 있더라도 DB와 관련된것은 변동이 없는 cNo뿐이라 무관함.         			
        	        pnCusSearch.getBtnAdd().setEnabled(true);
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
    	            	pnHairOder.getPnHairOderMain().setTxtInOrder(cNo, cName);
    	            	pnHairOder.getPnHairOderMain().reloadData();//고객검색에서 헤어주문 이동시 서브테이블 검색한 고객으로 리셋
    	    			tabbedPane.setEnabledAt(3, true);
    	            }
    	    }));
    		popup.add(new JMenuItem(new AbstractAction("헤어정보") {
    	            public void actionPerformed(ActionEvent e) {
    	            	tabbedPane.setEnabledAt(3, true);
    	    			tabbedPane.setSelectedComponent(pnOrderList);
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
					tabbedPane.addTab("프로그램관리", null, pnAdmin, null);
					ml.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "해당 아이디가 존재하지 않거나 비밀번호가 틀립니다.");
					ml.getTxtId().requestFocus();
					tabbedPane.remove(pnBizList);
					tabbedPane.remove(pnBizGraph);
					tabbedPane.remove(pnAdmin);
				}				
			}
		});				
	}	
	public void switchTab(int index){
		tabbedPane.setSelectedIndex(index);
	}	
	public void showThisCard(String string) {
		CardLayout cl = (CardLayout)(pnCusSearch.getPnCusSearchCards().getLayout());
        cl.show(pnCusSearch.getPnCusSearchCards(), string);
	}
	private void btnSaveTrueAction() {
		 pnCusSearch.getBtnSave().setEnabled(true);
		 cardIndex =1;			        
		 List<Customer> customerForSize = CustomerService.getInstance().selectByAll();// 카운트 할 sql문을 만드는 게 좋음. 현재 임시용.
		 int txtCno =customerForSize.size()+1;
		 pnCusSearch.getPnCusAdd().getTxtCno().setText(txtCno+"");
	}	
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == tabbedPane) {
			tabbedPaneStateChanged(e);
		}
	}
	protected void tabbedPaneStateChanged(ChangeEvent e) {
		if(((JTabbedPane)e.getSource()).getSelectedIndex()==4){
			pnBizList.setDefaultPnBizListMain();
		}
	}
}