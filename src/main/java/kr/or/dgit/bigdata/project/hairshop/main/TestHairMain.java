package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import kr.or.dgit.bigdata.project.hairshop.graph.BizGraph3;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import java.awt.Dimension;

public class TestHairMain extends JFrame {

	private JPanel contentPane;
	private JPanel pnHome;
	private JPanel pnCusSearch;
	private JPanel pnHairOder;
	private JPanel pnOrderList;
	private JPanel pnBizList;
	private JPanel pnBizGraph;
	private JTabbedPane tabbedPane;
	private JPanel pnHomeMain;
	private JPanel pnCusSearchMain;
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
	private JButton btnSave;
	private JButton btnYear;
	private JButton btnToMain4;
	private JButton btnHairInfo;
	private JPanel pnBizGraphMain;
	private BizGraph3 chartPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestHairMain frame = new TestHairMain();
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
	public TestHairMain() {
		setTitle("DGIT Hairshop Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
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
		pnCusSearch.setLayout(null);

		pnCusSearchMain = new JPanel();
		pnCusSearchMain.setBounds(0, 0, 900, 620);
		pnCusSearchMain.setBackground(new Color(255, 192, 203));
		pnCusSearch.add(pnCusSearchMain);
		pnCusSearchMain.setLayout(new BorderLayout(0, 0));

		pnCusSearchBtns = new JPanel();
		pnCusSearchBtns.setBounds(898, 0, 180, 620);
		pnCusSearchBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnCusSearchBtns.setBackground(Color.PINK);
		pnCusSearch.add(pnCusSearchBtns);
		pnCusSearchBtns.setLayout(new GridLayout(4, 0, 0, 20));

		btnAdd = new JButton("회원추가");
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
		pnHairOder.setLayout(null);

		pnHairOderMain = new JPanel();
		pnHairOderMain.setBounds(0, 0, 900, 620);
		pnHairOderMain.setBackground(new Color(255, 192, 203));
		pnHairOder.add(pnHairOderMain);

		pnHairOderBtns = new JPanel();
		pnHairOderBtns.setBounds(898, 0, 180, 620);
		pnHairOderBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnHairOderBtns.setBackground(Color.PINK);
		pnHairOder.add(pnHairOderBtns);
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
		pnOrderList.setLayout(null);

		pnOrderListMain = new JPanel();
		pnOrderListMain.setBounds(0, 0, 900, 620);
		pnOrderListMain.setBackground(new Color(255, 192, 203));
		pnOrderList.add(pnOrderListMain);

		pnOrderListBtns = new JPanel();
		pnOrderListBtns.setBounds(898, 0, 180, 620);
		pnOrderListBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnOrderListBtns.setBackground(Color.PINK);
		pnOrderList.add(pnOrderListBtns);
		pnOrderListBtns.setLayout(new GridLayout(4, 0, 0, 20));

		btnToMain3 = new JButton("메인화면");
		btnToMain3.setBackground(new Color(248, 248, 255));
		pnOrderListBtns.add(btnToMain3);

		pnBizList = new JPanel();
		tabbedPane.addTab("영업현황", null, pnBizList, null);
		pnBizList.setToolTipText("날짜, 월별 ,연도별 영업현황이 나타납니다.");
		pnBizList.setLayout(null);

		pnBizListMain = new JPanel();
		pnBizListMain.setBounds(0, 0, 900, 620);
		pnBizListMain.setBackground(new Color(255, 192, 203));
		pnBizList.add(pnBizListMain);

		pnBizListBtns = new JPanel();
		pnBizListBtns.setBounds(898, 0, 180, 620);
		pnBizListBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnBizListBtns.setBackground(Color.PINK);
		pnBizList.add(pnBizListBtns);
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
		pnBizGraph.add(pnBizGraphMain, BorderLayout.CENTER);
		pnBizGraphMain.setLayout(new BorderLayout(0, 0));
		
		chartPanel = new BizGraph3((String) null, (String) null);
		chartPanel.setPreferredSize(new Dimension(560, 367));
		pnBizGraphMain.add(chartPanel);

	}

}
