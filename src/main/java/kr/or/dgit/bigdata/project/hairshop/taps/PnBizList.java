package kr.or.dgit.bigdata.project.hairshop.taps;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanelP;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.bigdata.project.hairshop.ui.BizHairTotalReport;
import kr.or.dgit.bigdata.project.hairshop.ui.BizReport;

public class PnBizList extends JPanel {

	private BizReport pnBizListMain;
	private JPanel pnBizGraph;
	private BizHairTotalReport panel_1;
	private ChartPanelP panel;
	private JFreeChart chart;
	private JPanel pnBizGraphMain;
	/**
	 * Create the panel.
	 */
	public PnBizList() {
		setToolTipText("날짜, 월별 ,연도별 영업현황이 나타납니다.");
		setLayout(new BorderLayout(0, 0));
		// 영업현황 패널 ver.이유진* 0119 정창희 수정
		pnBizListMain = new BizReport();
		
		pnBizListMain.setBackground(new Color(240, 240, 240));
		add(pnBizListMain, null);
		pnBizListMain.setDefaultPnBizListMain();
		
		pnBizGraph = new JPanel();
		
		pnBizGraph.setToolTipText("영업 현황 통계 그래프가 나타납니다.");
		pnBizGraph.setLayout(null);

		panel_1 = new BizHairTotalReport();
		panel_1.setBounds(195, 12, 690, 171);
		pnBizGraph.add(panel_1);
		
		panel = new ChartPanelP(chart);
		panel.setBounds(195, 195, 690, 430);
		pnBizGraph.add(panel);
		
		pnBizGraphMain = new JPanel();
		pnBizGraphMain.setBackground(new Color(255, 192, 203));
		pnBizGraph.add(pnBizGraphMain, BorderLayout.CENTER);
	}
	public BizReport getPnBizListMain() {
		return pnBizListMain;
	}
	public void setPnBizListMain(BizReport pnBizListMain) {
		this.pnBizListMain = pnBizListMain;
	}
	public JPanel getPnBizGraph() {
		return pnBizGraph;
	}
	public void setPnBizGraph(JPanel pnBizGraph) {
		this.pnBizGraph = pnBizGraph;
	}
	public BizHairTotalReport getPanel_1() {
		return panel_1;
	}
	public void setPanel_1(BizHairTotalReport panel_1) {
		this.panel_1 = panel_1;
	}
	public ChartPanelP getPanel() {
		return panel;
	}
	public void setPanel(ChartPanelP panel) {
		this.panel = panel;
	}
	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	public JPanel getPnBizGraphMain() {
		return pnBizGraphMain;
	}
	public void setPnBizGraphMain(JPanel pnBizGraphMain) {
		this.pnBizGraphMain = pnBizGraphMain;
	}
}
