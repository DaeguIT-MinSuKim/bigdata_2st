package org.jfree.chart;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.fonts.Fonts;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

public class ChartPanelP extends ChartPanel {

	private JFreeChart chart;
	private ChartPanel cP;
	private Font labelFont;

	Fonts f = new Fonts();
	private DefaultCategoryDataset dataset;

	public ChartPanelP(JFreeChart chart) {//
		super(chart);
		String chartTitle = "hair";
		chart = ChartFactory.createBarChart3D(chartTitle, "카테고리", "주문건수", createDataset(), PlotOrientation.VERTICAL,
				true, false, false);
		this.chart = chart;

		// 차트 제목 폰트
		labelFont = chart.getTitle().getFont();
		try {
			chart.getTitle().setFont(f.getDoHyeon().deriveFont(1, 20f));
			// X축 제목 폰트
			labelFont = chart.getCategoryPlot().getDomainAxis().getLabelFont();
			chart.getCategoryPlot().getDomainAxis().setLabelFont(f.getDoHyeon().deriveFont(1, 20f));
			// X축 값에 대한 레이블 폰트
			labelFont = chart.getCategoryPlot().getDomainAxis().getTickLabelFont();
			chart.getCategoryPlot().getDomainAxis().setTickLabelFont(f.getDoHyeon().deriveFont(1, 14f));
			// Y축 제목 폰트
			labelFont = chart.getCategoryPlot().getDomainAxis().getLabelFont();
			chart.getCategoryPlot().getRangeAxis().setLabelFont(f.getDoHyeon().deriveFont(1, 20f));
			// Y축 값에 대한 레이블 폰트
			labelFont = chart.getCategoryPlot().getRangeAxis().getTickLabelFont();
			chart.getCategoryPlot().getRangeAxis().setTickLabelFont(f.getDoHyeon().deriveFont(1, 14f));
			// 범례 폰트
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

		dataset = new DefaultCategoryDataset();
		chartRefresh();

		return dataset;
	}

	public void chartRefresh() {//그래프 새로갱신용 메소드 독립
		List<Hairinfo> hList = HairinfoService.getInstance().selectHairInfoAll();
		String[] hairTitle = new String[hList.size()];
		String HAIRTYPE = "헤어종류";
		int j =1;
		for (int i = 0; i < hairTitle.length; i++) {
			hairTitle[i] = hList.get(i).gethName();
		}
		for (int i = 0; i < hairTitle.length; i++) {
			dataset.addValue(BizService.getInstance().selectCountTotalEachHairBiz(j), hairTitle[i], HAIRTYPE);
			j++;
		}
		j=0;
	}

}
