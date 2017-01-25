package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.fonts.Fonts;
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
import kr.or.dgit.bigdata.project.hairshop.ui.admin.ManagerLogin;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private boolean mlTf; //false면 관리자 모드 비접속, true면 관리자 모드 접속 중

	Fonts f = new Fonts();
	private JFreeChart chart;

	public static void setUIFont(javax.swing.plaf.FontUIResource f) {

		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

	public HairMain() {
		setTitle("DGIT HAIR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		/* 고객 헤어 정보를 보여줄 table을 담고있는 패널 ver.이유진 */
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(this);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		try {
			tabbedPane.setFont(f.getHanNa().deriveFont(0, 16f));
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
				cardIndex = 0;
			}
		});
		pnHome.getPnHomeMain().getcAdd().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switchTab(1);
				showThisCard("name_1666358524774753");
				btnSaveTrueAction();
			}
		});
		pnHome.getPnHomeMain().gethOrder().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switchTab(2);
			}
		});
		pnHome.getPnHomeMain().getBtns()[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnManagerActionPerformed(arg0);
			}
		});
		tabbedPane.remove(pnBizList);
		tabbedPane.remove(pnBizGraph);
		tabbedPane.addTab("  홈  ", null, pnHome, null); // pnHome 탭 끝. 로그아웃 연동
														// 추가 요망
		pnCusSearch = new PnCusSearch();//
		pnCusSearch.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				pnCusSearchComponentShown(arg0);
			}
		});
		pnCusSearch.getPnSearchSub().getTableForAll().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				pnSearchSubTableForAllMouseReleased(arg0, pnCusSearch.getTableInSearchForAll());//
			}
		});
		pnCusSearch.getPnSearchSub().getTable().addMouseListener(new MouseAdapter() {
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
		pnCusSearch.getBtnAdd().addActionListener(new ActionListener() {// 회원추가
																		// 패널 이동
																		// 버튼
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
		pnCusSearch.addComponentListener(new ComponentAdapter() {//////////
			@Override
			public void componentShown(ComponentEvent arg0) {
				showThisCard("name_1666323161344197");
			}
		});
		tabbedPane.addTab("고객검색", null, pnCusSearch, null);
		pnHairOder = new PnHairOder();// pnHairOder
		pnHairOder.getPnHairOderMain().getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnHairOderPnHairOderMainTableMouseClicked(arg0);
			}
		});
		pnHairOder.getPnHairOderMain().getTfCName().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				pnHairOderPnHairOderMainTfCNameKeyTyped(arg0);
			}
		});
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
		pnHairOder.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				pnHairOderComponentShown(arg0);
			}
		});
		tabbedPane.addTab("헤어주문", null, pnHairOder, null);// pnHairOrder 끝
		pnOrderList = new PnOrderList();// pnOrderList
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
		pnBizGraph.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				pnBizGraphComponentShown(arg0);
			}
		});
		pnAdmin = new PnAdmin();
		pnAdmin.setTabbedPane(tabbedPane);
		pnAdmin.getBtnToLogout().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLogout();
			}
		});
		pnAdmin.getBtnSetting().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hairPanelInit();
			}
		});
		
	}

	// 액션 리스너 메소드//////////////////////////////////////////////////////////
	protected void btnAddActionPerformed(ActionEvent e) {
		showThisCard("name_1666358524774753");
		pnCusSearch.getBtnSave().setEnabled(true);
		cardIndex = 1;
		List<Customer> customerForSize = CustomerService.getInstance().selectByAll();
		int txtCno = customerForSize.size() + 1;
		pnCusSearch.getPnCusAdd().getTxtCno().setText(txtCno + "");
		pnCusSearch.getBtnAdd().setEnabled(false);
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		pnCusSearch.getPnSearchSub().revalidate();
		showThisCard("name_1666323161344197");
		pnCusSearch.getBtnSave().setEnabled(false);
		cardIndex = 0;
		pnCusSearch.getBtnAdd().setEnabled(true);
		pnCusSearch.getPnSearchSub().reloadDataForAll();// 고객검색 내에서 회원검색 패널 이동버튼 클릭시 테이블 재검색
	}

	protected void btnSaveActionPerformed(ActionEvent e) {/////
		switch (cardIndex) {
		case 1:
			pnCusSearch.getPnCusAdd().insertNewCostomer();
			int directOderInAdd = JOptionPane.showConfirmDialog(null, "해당 고객 번호로 바로 주문 하시겠습니까?");
			if (directOderInAdd == 0) {
				pnHairOder.getPnHairOderMain().setTxtInOrder(
						Integer.parseInt(pnCusSearch.getPnCusAdd().getTxtCno().getText()),
						pnCusSearch.getPnCusAdd().getTxtCname().getText());
				tabbedPane.setSelectedComponent(pnHairOder);
				pnHairOder.getPnHairOderMain().reloadData();
			}
			cardIndex = 0;
			pnCusSearch.getPnCusAdd().setClearTxt();
			break;
		case 2:
			pnCusSearch.getPnCusEdit().setTxtInCusEditForUpdate();
			int directOderInEdit = JOptionPane.showConfirmDialog(null, "해당 고객 번호로 바로 주문 하시겠습니까?");
			if (directOderInEdit == 0) {
				pnHairOder.getPnHairOderMain().setTxtInOrder(
						Integer.parseInt(pnCusSearch.getPnCusEdit().getTxtCno().getText()),
						pnCusSearch.getPnCusEdit().getTxtCname().getText());
				tabbedPane.setSelectedComponent(pnHairOder);
				pnHairOder.getPnHairOderMain().reloadData();
			}
			cardIndex = 0;
			break;
		default:
			break;
		}
	}

	protected void btnHairInfoActionPerformed(ActionEvent e) { // 테이블 보이기 추가 //
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setSelectedComponent(pnOrderList);
		Customer c = CustomerService.getInstance().searchCustomerByNo(Integer.parseInt(pnHairOder.getPnHairOderMain().getTfCNo().getText()));	
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		pnOrderList.getPnOrderListMain().setTxtInHairIfo(c.getcNo(), c.getcName(), dfm.format(c.getcDob()));
		pnOrderList.getPnOrderListMain().reloadData();
		pnHairOder.getPnHairOderMain().setClearTxt2();
	}

	protected void btnToMainActionPerformed(ActionEvent e) {
		tabbedPane.setSelectedComponent(pnHome);
	}

	protected void btnOrderActionPerformed(ActionEvent e) {// 주문 버튼
		pnHairOder.getPnHairOderMain().insertBizByOrder();
		Customer c = CustomerService.getInstance()
				.searchCustomerByNo(Integer.parseInt(pnHairOder.getPnHairOderMain().getTfCNo().getText()));
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		pnOrderList.getPnOrderListMain().setTxtInHairIfo(c.getcNo(), c.getcName(), dfm.format(c.getcDob()));
		pnOrderList.getPnOrderListMain().reloadData();
		tabbedPane.setEnabledAt(3, true);
		pnHairOder.getPnHairOderMain().setClearTxt();
		pnHairOder.getPnHairOderMain().reloadDataForAll();
	}

	private void clickAndGetDataFromTable(JTable table) {
		cNo = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		cName = table.getValueAt(table.getSelectedRow(), 1).toString();
		dob = table.getValueAt(table.getSelectedRow(), 2).toString();
		doJoin = table.getValueAt(table.getSelectedRow(), 3).toString();
		phone = table.getValueAt(table.getSelectedRow(), 4).toString();
		pnCusSearch.getPnCusEdit().setTxtInCusEdit(cNo, cName, dob, doJoin, phone);
		pnOrderList.getPnOrderListMain().setTxtInHairIfo(cNo, cName, dob);
		pnOrderList.getPnOrderListMain().reloadData();
		pnHairOder.getPnHairOderMain().setTxtInOrder(cNo, cName);
		pnHairOder.getPnHairOderMain().reloadData();
	}

	protected void pnSearchSubTableForAllMouseReleased(MouseEvent e, JTable jt) {
		int r = jt.rowAtPoint(e.getPoint());
		if (r >= 0 && r < jt.getRowCount()) {
			jt.setRowSelectionInterval(r, r);
		} else {
			jt.clearSelection();
		}
		int rowindex = jt.getSelectedRow();
		if (rowindex < 0)
			return;
		if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
			clickAndGetDataFromTable(jt);
			JPopupMenu popup = new JPopupMenu(); // 우클릭시 팝업 메뉴 등장
			popup.add(new JMenuItem(new AbstractAction("수정") {
				public void actionPerformed(ActionEvent e) {
					showThisCard("name_1666378783739869");
					pnCusSearch.getBtnSave().setEnabled(true);
					cardIndex = 2;
					pnHairOder.getPnHairOderMain().setTxtInOrder(cNo, cName); // 수정된 내역이 있더라도 DB와 관련된것은 변동이 없는 cNo뿐이라 무관함.
					pnCusSearch.getBtnAdd().setEnabled(true);
				}
			}));
			popup.add(new JMenuItem(new AbstractAction("삭제") {
				public void actionPerformed(ActionEvent e) {
					int jopi = JOptionPane.showConfirmDialog(null, cName + "회원을 정말 삭제하시겠습니까?");
					if (jopi == 0) {
						Customer cForDel = new Customer();
						cForDel.setcDel(true);
						cForDel.setcNo(cNo);
						CustomerService.getInstance().deleteCustomer(cForDel);
						pnCusSearch.getPnSearchSub().reloadDataForAll();
					}
				}
			}));
			popup.add(new JMenuItem(new AbstractAction("주문") {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedComponent(pnHairOder);
					pnHairOder.getPnHairOderMain().setTxtInOrder(cNo, cName);
					pnHairOder.getPnHairOderMain().reloadData();
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

	private void btnManagerActionPerformed(ActionEvent arg0) {// 관리자 로그인 버튼 이벤트 리스너
		if (pnBizList.isDisplayable()) {
			JOptionPane.showMessageDialog(null, "이미 관리자 모드로 접속 중 입니다.");
		} else {
			ManagerLogin ml = new ManagerLogin();
			ml.setVisible(true);
			ml.getBtnLogin().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Manager manager = new Manager();

					manager.setmName(ml.getTxtId().getText());
					Manager temp = ManagerService.getInstance().selectmPasswordByName(manager);
					char[] pass = ml.getPasswordField().getPassword();
					String userPass = "";
					for (char c : pass) {
						userPass += c;
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
					mlTf = true;
				}
			});
		}
	}

	public void switchTab(int index) {
		tabbedPane.setSelectedIndex(index);
	}

	protected void pnHairOderComponentShown(ComponentEvent arg0) {////////////
		pnHairOder.getPnHairOderMain().setArrOptionNames();
		pnHairOder.getPnHairOderMain().setTxtInOrder();
		if (pnHairOder.getPnHairOderMain().getTfCNo().getText().equals("")) {
			pnHairOder.getBtnHairInfo().setEnabled(false);
		} else {
			pnHairOder.getBtnHairInfo().setEnabled(true);
		}
		pnHairOder.getPnHairOderMain().setClearTxt2();

	}

	public void showThisCard(String string) {
		CardLayout cl = (CardLayout) (pnCusSearch.getPnCusSearchCards().getLayout());
		cl.show(pnCusSearch.getPnCusSearchCards(), string);
	}

	private void btnSaveTrueAction() {
		pnCusSearch.getBtnSave().setEnabled(true);
		cardIndex = 1;
		List<Customer> customerForSize = CustomerService.getInstance().selectByAll();
		int txtCno = customerForSize.size() + 1;
		pnCusSearch.getPnCusAdd().getTxtCno().setText(txtCno + "");
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == tabbedPane) {
			tabbedPaneStateChanged(e);
		}
	}

	protected void tabbedPaneStateChanged(ChangeEvent e) {
		switch (((JTabbedPane) e.getSource()).getSelectedIndex()) {
		case 4:
			pnBizList.setDefaultPnBizListMain();
			break;
		case 6:
			pnAdmin.setDefaultPanel();
			break;
		default:
			break;
		}
	}

	private void isLogout() {
		mlTf = false;
	}

	private void pnCusSearchComponentShown(ComponentEvent arg0) {
		pnCusSearch.getTableInSearchForAll().reloadDataForAll();
		pnCusSearch.getBtnAdd().setEnabled(true);
		pnCusSearch.getPnCusAdd().setClearTxt();
	}

	private void pnBizGraphComponentShown(ComponentEvent arg0) {// 그래프 패널 초기화용
		pnBizGraph.getPanel_1().reloadData();
		pnBizGraph.getPanel().chartRefresh();
	}

	protected void pnHairOderPnHairOderMainTfCNameKeyTyped(KeyEvent arg0) {
		pnHairOder.getPnHairOderMain().getTfCNo().setText("");
	}

	protected void pnHairOderPnHairOderMainTableMouseClicked(MouseEvent arg0) {
		if (pnHairOder.getPnHairOderMain().getTfCNo().getText().equals("")) {
			pnHairOder.getBtnHairInfo().setEnabled(false);
		} else {
			pnHairOder.getBtnHairInfo().setEnabled(true);
		}
	}
	private void hairPanelInit() {
		pnHairOder.getPnHairOderMain().setClearTxt();
		pnOrderList.getPnOrderListMain().setClearTxt();
	}

}