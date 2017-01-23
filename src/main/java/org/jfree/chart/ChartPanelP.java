package org.jfree.chart;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.bigdata.project.hairshop.fonts.Fonts;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

public class ChartPanelP extends ChartPanel {

	private JFreeChart chart;
	private ChartPanel cP;
	private Font labelFont;
	
	Fonts f = new Fonts();
	
	public ChartPanelP(JFreeChart chart) {//
		super(chart);
		String chartTitle = "hair";
		chart = ChartFactory.createBarChart3D(chartTitle, "카테고리", "주문건수", createDataset(), PlotOrientation.VERTICAL, true, false, false);
		this.chart = chart;
				
		//차트 제목 폰트
		labelFont = chart.getTitle().getFont();
		try {
			chart.getTitle().setFont(f.getDoHyeon().deriveFont(1, 20f));
			//X축 제목 폰트
			labelFont = chart.getCategoryPlot().getDomainAxis().getLabelFont();
			chart.getCategoryPlot().getDomainAxis().setLabelFont(f.getDoHyeon().deriveFont(1, 20f));
			//X축 값에 대한 레이블 폰트
			labelFont = chart.getCategoryPlot().getDomainAxis().getTickLabelFont();
			chart.getCategoryPlot().getDomainAxis().setTickLabelFont(f.getDoHyeon().deriveFont(1, 14f));
			//Y축 제목 폰트
			labelFont = chart.getCategoryPlot().getDomainAxis().getLabelFont();
			chart.getCategoryPlot().getRangeAxis().setLabelFont(f.getDoHyeon().deriveFont(1, 20f));
			//Y축  값에 대한 레이블 폰트
			labelFont = chart.getCategoryPlot().getRangeAxis().getTickLabelFont();
			chart.getCategoryPlot().getRangeAxis().setTickLabelFont(f.getDoHyeon().deriveFont(1, 14f));
			//범례 폰트
			chart.getLegend().setItemFont(f.getDoHyeon().deriveFont(14f));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		cP = new ChartPanel(chart);
		cP.setVisible(true);
		add(cP);
	}

	public CategoryDataset createDataset() {
	
		String CUT = "커트";
		String DRY = "드라이";
		String SHAMPOO = "샴푸";
		String PERM = "펌";
		String MAGIC = "매직";
		String TREATMENT = "트리트먼트";
		String AMPLE = "앰플";
		String ETC = "기타";
		 
		String HAIRTYPE = "헤어종류";
		
		

		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
			
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
