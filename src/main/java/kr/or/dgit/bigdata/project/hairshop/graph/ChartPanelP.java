package kr.or.dgit.bigdata.project.hairshop.graph;

import java.awt.BorderLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.bigdata.project.hairshop.service.BizService;

public class ChartPanelP extends ChartPanel {

	private JFreeChart chart;
	private ChartPanel cP;
	
	public ChartPanelP(JFreeChart chart) {
		super(chart);
		String chartTitle = "hair";
		chart = ChartFactory.createBarChart(chartTitle, "카테고리", "주문건수", createDataset(), PlotOrientation.VERTICAL, true, true, false);
		this.chart = chart;
		cP = new ChartPanel(chart);
		cP.setVisible(true);
		add(cP);
	}

	private CategoryDataset createDataset() {
		final String CUT = "커트";
		final String DRY = "드라이";
		final String SHAMPOO = "샴푸";
		final String PERM = "펌";
		final String MAGIC = "매직";
		final String TREATMENT = "트리트먼트";
		final String AMPLE = "앰플";
		final String ETC = "기타";
		 
		final String HAIRTYPE = "헤어종류";

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	
		
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(1), CUT, HAIRTYPE);
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(2), DRY, HAIRTYPE);
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(3), SHAMPOO, HAIRTYPE);
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(4), PERM, HAIRTYPE);
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(5), MAGIC, HAIRTYPE);
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(6), TREATMENT, HAIRTYPE);
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(7), AMPLE, HAIRTYPE);
		 dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(8), ETC, HAIRTYPE);
		
		 return dataset;
	}

}
