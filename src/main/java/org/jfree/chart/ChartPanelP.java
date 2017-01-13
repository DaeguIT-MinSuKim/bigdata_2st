package org.jfree.chart;

import org.jfree.chart.StandardChartTheme;

import java.awt.Font;
import java.io.UnsupportedEncodingException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.bigdata.project.hairshop.service.BizService;

public class ChartPanelP extends ChartPanel {

	private JFreeChart chart;
	private ChartPanel cP;
	private Font labelFont;
		
	public ChartPanelP(JFreeChart chart) {
		super(chart);
		String chartTitle = "hair";
		chart = ChartFactory.createBarChart(chartTitle, "카테고리", "주문건수", createDataset(), PlotOrientation.VERTICAL, true, true, false);
		this.chart = chart;
				
		//차트 제목
		labelFont = chart.getTitle().getFont();
		chart.getTitle().setFont(new Font("굴림",labelFont.getStyle(),labelFont.getSize()));
		//X축 제목
		labelFont = chart.getCategoryPlot().getDomainAxis().getLabelFont();
		chart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("돋움",labelFont.getStyle(),labelFont.getSize()));
		//X축 값에 대한 레이블
		labelFont = chart.getCategoryPlot().getDomainAxis().getTickLabelFont();
		chart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("돋움",labelFont.getStyle(),labelFont.getSize()));
		//Y축 제목
		labelFont = chart.getCategoryPlot().getDomainAxis().getLabelFont();
		chart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("돋움",labelFont.getStyle(),labelFont.getSize()));
		//Y축  값에 대한 레이블
		labelFont = chart.getCategoryPlot().getRangeAxis().getTickLabelFont();
		chart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("돋움",labelFont.getStyle(),labelFont.getSize()));
		//범례
		chart.getLegend().setItemFont(new Font("돋움",Font.PLAIN,10));
		
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
