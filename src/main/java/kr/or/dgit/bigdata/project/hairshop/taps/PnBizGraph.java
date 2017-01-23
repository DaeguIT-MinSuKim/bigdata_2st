package kr.or.dgit.bigdata.project.hairshop.taps;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanelP;
import org.jfree.chart.JFreeChart;

import kr.or.dgit.bigdata.project.hairshop.ui.BizHairTotalReport;

public class PnBizGraph extends JPanel {

	private BizHairTotalReport panel_1;
	private JFreeChart chart;
	private ChartPanelP panel;

	/**
	 * Create the panel.
	 */
	public PnBizGraph() {

		setLayout(null);

		panel_1 = new BizHairTotalReport();
		panel_1.getTfTotalBizPrice().setEditable(false);
		panel_1.getTfTotalBizCnt().setEditable(false);
		panel_1.getTfTotalCusCnt().setEditable(false);
		panel_1.setBounds(195, 12, 690, 171);
		add(panel_1);
		
		panel = new ChartPanelP(chart);
		panel.setBounds(195, 195, 690, 430);
		add(panel);
	}

}
