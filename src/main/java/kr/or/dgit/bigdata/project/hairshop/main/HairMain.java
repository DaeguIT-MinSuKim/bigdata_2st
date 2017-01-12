package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kr.or.dgit.bigdata.project.hairshop.ui.CustomDialog;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerManageEdit;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerManageInsert;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerSearch;

public class HairMain extends JFrame {

	private JPanel contentPane;
	private JPanel pnHome;
	private JPanel pnCusSearch;
	private JPanel pnHairOder;
	private JPanel pnOrderList;
	private JPanel pnBizList;
	private JPanel pnBizGraph;
	private JTabbedPane tabbedPane;
	private JPanel pnHomeMain;
	private JPanel pnCusSearchCards;
	private JPanel pnCusSearchBtns;
	private JButton btnAdd;
	private JButton btnToMain1;
	private JPanel pnHairOderMain;
	private JPanel pnHairOderBtns;
	private JButton btnOrder;
	private JButton btnToMain2;
	private JPanel pnOrderListMain;
	private JPanel pnOrderListBtns;
	private JButton btnToMain3;
	private JPanel pnBizListMain;
	private JPanel pnBizListBtns;
	private JButton btnDate;
	private JButton btnMonth;
	private JPanel pnBizGraphMain;
	private JButton btnSave;
	private JButton btnYear;
	private JButton btnToMain4;
	private JButton btnHairInfo;
	private CustomerSearch pnSearchSub;
	private CustomerManageInsert pnCusAdd;
	private CustomerManageEdit pnCusEdit;
	private JButton btnSearch;	
	private CustomDialog dialog; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HairMain frame = new HairMain();
					frame.setBounds(100, 100, 1100, 700);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public HairMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pnHome = new JPanel();
		tabbedPane.addTab("홈", null, pnHome, null);
		pnHome.setToolTipText("홈 화면으로 돌아갑니다.");
		pnHome.setLayout(new BorderLayout(0, 0));
		
		pnHomeMain = new JPanel();
		pnHomeMain.setBackground(new Color(255, 192, 203));
		pnHome.add(pnHomeMain, BorderLayout.CENTER);
		
		pnCusSearch = new JPanel();
		tabbedPane.addTab("고객검색", null, pnCusSearch, null);
		pnCusSearch.setToolTipText("고객검색 및 회원 추가, 삭제");
		pnCusSearch.setLayout(new BorderLayout(0, 0));
		
		pnCusSearchCards = new JPanel();
		pnCusSearchCards.setBackground(new Color(255, 192, 203));
		pnCusSearch.add(pnCusSearchCards, BorderLayout.CENTER);
		pnCusSearchCards.setLayout(new CardLayout(0, 0));
		
		pnSearchSub = new CustomerSearch();		
		
		pnCusSearchCards.add(pnSearchSub, "name_1666323161344197");		
		// table 관련 이벤트 독립
		JTable tableInSearch = pnSearchSub.getTable();
		tableInSearch.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int cNo = Integer.parseInt(tableInSearch.getValueAt(tableInSearch.getSelectedRow(), 0).toString()); // 선택한 열의 0번째 인덱스 행을 출력
				String cName = tableInSearch.getValueAt(tableInSearch.getSelectedRow(), 1).toString();
				String dob = tableInSearch.getValueAt(tableInSearch.getSelectedRow(), 2).toString();
				String doJoin = tableInSearch.getValueAt(tableInSearch.getSelectedRow(), 3).toString();
				String phone = tableInSearch.getValueAt(tableInSearch.getSelectedRow(), 4).toString();
				Object[] options ={"수정","삭제","주문","헤어정보"};
				
				int jopBtnIndex = JOptionPane.showOptionDialog(null, cName+"["+dob+", "+phone+"]", "회원 관리", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, null, options, options[3]);
				
				if (jopBtnIndex == 0) {
					CardLayout cl = (CardLayout)(pnCusSearchCards.getLayout());
			        cl.show(pnCusSearchCards, "name_1666378783739869");
				}
				
			}
		
		
		});
		
		
		pnCusAdd = new CustomerManageInsert();
		pnCusSearchCards.add(pnCusAdd, "name_1666358524774753");
		
		pnCusEdit = new CustomerManageEdit();
		pnCusSearchCards.add(pnCusEdit, "name_1666378783739869");
		
		pnCusSearchBtns = new JPanel();
		pnCusSearchBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnCusSearchBtns.setBackground(Color.PINK);
		pnCusSearch.add(pnCusSearchBtns, BorderLayout.EAST);
		pnCusSearchBtns.setLayout(new GridLayout(4, 0, 0, 20));
		
		btnSearch = new JButton("회원검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnSearch);
		
		btnAdd = new JButton("회원추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnAdd);
		
		btnSave = new JButton("저장");
		btnSave.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnSave);
		
		btnToMain1 = new JButton("메인화면");
		btnToMain1.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnToMain1);
		
		pnHairOder = new JPanel();
		tabbedPane.addTab("헤어주문", null, pnHairOder, null);
		pnHairOder.setToolTipText("헤어주문");
		pnHairOder.setLayout(new BorderLayout(0, 0));
		
		pnHairOderMain = new JPanel();
		pnHairOderMain.setBackground(new Color(255, 192, 203));
		pnHairOder.add(pnHairOderMain, BorderLayout.CENTER);
		
		pnHairOderBtns = new JPanel();
		pnHairOderBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnHairOderBtns.setBackground(Color.PINK);
		pnHairOder.add(pnHairOderBtns, BorderLayout.EAST);
		pnHairOderBtns.setLayout(new GridLayout(4, 0, 0, 20));
		
		btnOrder = new JButton("주문");
		btnOrder.setBackground(new Color(248, 248, 255));
		pnHairOderBtns.add(btnOrder);
		
		btnHairInfo = new JButton("헤어정보");
		btnHairInfo.setToolTipText("해당 고객의 헤어 스타일 내역으로 이동합니다.");
		btnHairInfo.setBackground(new Color(248, 248, 255));
		pnHairOderBtns.add(btnHairInfo);
		
		btnToMain2 = new JButton("메인화면");
		btnToMain2.setBackground(new Color(248, 248, 255));
		pnHairOderBtns.add(btnToMain2);
		
		pnOrderList = new JPanel();
		tabbedPane.addTab("헤어주문검색", null, pnOrderList, null);
		tabbedPane.setEnabledAt(3, false); // 고객 검색 후 true로 활성화
		pnOrderList.setToolTipText("고객의 헤어주문내역이 나타납니다.");
		pnOrderList.setLayout(new BorderLayout(0, 0));
		
		pnOrderListMain = new JPanel();
		pnOrderListMain.setBackground(new Color(255, 192, 203));
		pnOrderList.add(pnOrderListMain, BorderLayout.CENTER);
		
		pnOrderListBtns = new JPanel();
		pnOrderListBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnOrderListBtns.setBackground(Color.PINK);
		pnOrderList.add(pnOrderListBtns, BorderLayout.EAST);
		pnOrderListBtns.setLayout(new GridLayout(4, 0, 0, 20));
		
		btnToMain3 = new JButton("메인화면");
		btnToMain3.setBackground(new Color(248, 248, 255));
		pnOrderListBtns.add(btnToMain3);
		
		pnBizList = new JPanel();
		tabbedPane.addTab("영업현황", null, pnBizList, null);
		pnBizList.setToolTipText("날짜, 월별 ,연도별 영업현황이 나타납니다.");
		pnBizList.setLayout(new BorderLayout(0, 0));
		
		pnBizListMain = new JPanel();
		pnBizListMain.setBackground(new Color(255, 192, 203));
		pnBizList.add(pnBizListMain, BorderLayout.CENTER);
		
		pnBizListBtns = new JPanel();
		pnBizListBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnBizListBtns.setBackground(Color.PINK);
		pnBizList.add(pnBizListBtns, BorderLayout.EAST);
		pnBizListBtns.setLayout(new GridLayout(4, 0, 0, 20));
		
		btnDate = new JButton("기간별");
		btnDate.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnDate);
		
		btnMonth = new JButton("월별");
		btnMonth.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnMonth);
		
		btnYear = new JButton("연도별");
		btnYear.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnYear);
		
		btnToMain4 = new JButton("메인화면");
		btnToMain4.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnToMain4);
		
		pnBizGraph = new JPanel();
		tabbedPane.addTab("영업그래프", null, pnBizGraph, null);
		pnBizGraph.setToolTipText("영업 현황 통계 그래프가 나타납니다.");
		pnBizGraph.setLayout(new BorderLayout(0, 0));
		
		pnBizGraphMain = new JPanel();
		pnBizGraphMain.setBackground(new Color(255, 192, 203));
		pnBizGraph.add(pnBizGraphMain, BorderLayout.CENTER);
		
		
		
	}
	

	public JPanel getPnCusSearchCards() {
		return pnCusSearchCards;
	}

	public void setPnCusSearchCards(JPanel pnCusSearchCards) {
		this.pnCusSearchCards = pnCusSearchCards;
	} 


	protected void btnAddActionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)(pnCusSearchCards.getLayout());
        cl.show(pnCusSearchCards, "name_1666358524774753");
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)(pnCusSearchCards.getLayout());
        cl.show(pnCusSearchCards, "name_1666323161344197");
	}
	
	
	
}
