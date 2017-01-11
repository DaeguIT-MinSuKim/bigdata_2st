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
	private JPanel pnHomeBtns;
	private JButton btnAdd;
	private JButton btnToMain;

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
		
		pnHomeBtns = new JPanel();
		pnHomeBtns.setBackground(Color.PINK);
		pnHomeBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnHome.add(pnHomeBtns, BorderLayout.EAST);
		pnHomeBtns.setLayout(new GridLayout(3, 0, 0, 20));
		
		btnAdd = new JButton("회원추가");
		btnAdd.setBackground(new Color(248, 248, 255));
		pnHomeBtns.add(btnAdd);
		
		btnToMain = new JButton("메인화면");
		btnToMain.setBackground(new Color(248, 248, 255));
		pnHomeBtns.add(btnToMain);
		
		pnCusSearch = new JPanel();
		tabbedPane.addTab("고객검색", null, pnCusSearch, null);
		pnCusSearch.setToolTipText("고객검색 및 회원 추가, 삭제");
		pnCusSearch.setLayout(new BorderLayout(0, 0));
		
		pnHairOder = new JPanel();
		tabbedPane.addTab("헤어주문", null, pnHairOder, null);
		pnHairOder.setToolTipText("헤어주문");
		pnHairOder.setLayout(new BorderLayout(0, 0));
		
		pnOrderList = new JPanel();
		tabbedPane.addTab("헤어주문검색", null, pnOrderList, null);
		tabbedPane.setEnabledAt(3, false); // 고객 검색 후 true로 활성화
		pnOrderList.setToolTipText("고객의 헤어주문내역이 나타납니다.");
		pnOrderList.setLayout(new BorderLayout(0, 0));
		
		pnBizList = new JPanel();
		tabbedPane.addTab("영업현황", null, pnBizList, null);
		pnBizList.setToolTipText("날짜, 월별 ,연도별 영업현황이 나타납니다.");
		pnBizList.setLayout(new BorderLayout(0, 0));
		
		pnBizGraph = new JPanel();
		tabbedPane.addTab("영업그래프", null, pnBizGraph, null);
		pnBizGraph.setToolTipText("영업 현황 통계 그래프가 나타납니다.");
		pnBizGraph.setLayout(new BorderLayout(0, 0));
		
	}

}
