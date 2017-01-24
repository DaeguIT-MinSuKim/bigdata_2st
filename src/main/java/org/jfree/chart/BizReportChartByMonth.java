package org.jfree.chart;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.fonts.Fonts;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

public class BizReportChartByMonth extends JFrame  {
		
	  public BizReportChartByMonth(String title, int year) throws IOException {
		super(title);
		CategoryDataset dataset = createDateset(year);
		JFreeChart chart = createChart(dataset, year);	  
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
		setContentPane(chartPanel);
		pack();  
	  }

	private JFreeChart createChart(CategoryDataset dataset, int year) {
		// TODO Auto-generated method stub
		JFreeChart chart = ChartFactory.createStackedBarChart3D(
			      year+"년도 월별 매출 실적"
			      , ""
			      , "실적"
			      , dataset
			      , PlotOrientation.VERTICAL
			      , true
			      , true
			      , false);
			  
		  chart.setBackgroundPaint(java.awt.Color.white);
		  /* 한글이 깨져보이는 경우 해결책 */
		  Fonts f = new Fonts();

		  try {
			  // 제목
			  chart.getTitle().setFont(f.getDoHyeon().deriveFont(14f));
			  // 범례
			  chart.getLegend().setItemFont(f.getDoHyeon().deriveFont(14f));
			  CategoryPlot plot = chart.getCategoryPlot();
			  
			  Font font = plot.getDomainAxis().getLabelFont();
			  // X축 라벨
			  plot.getDomainAxis().setLabelFont(f.getDoHyeon().deriveFont(12f));
			  // X축 도메인
			  plot.getDomainAxis().setTickLabelFont(f.getDoHyeon().deriveFont(12f));
			  
			  font = plot.getRangeAxis().getLabelFont();
			  // Y축 라벨
			  plot.getRangeAxis().setLabelFont(f.getDoHyeon().deriveFont(12f));
			  // Y축 범위
			  plot.getRangeAxis().setTickLabelFont(f.getDoHyeon().deriveFont(14f));
		
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
			return chart;
		  

	}

	private CategoryDataset createDateset(int year) {
		/* Create Dateset and insert Datas */
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		List<Hairinfo> hList = HairinfoService.getInstance().selectHairInfoAll();
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("year", year);
		
		for (int i=0; i < 12; i++) {
			searchMap.put("month", i+1);
		    for (int j=0; j < hList.size(); j++) {
		    	searchMap.put("hNo", hList.get(j).gethNo());
		    	HashMap<String, Object> res = BizService.getInstance().selectBizWithHairInfo(searchMap);
		    	if(res != null){
		    		double dres = (double) res.get("sum");
		    		dataset.addValue(dres, hList.get(j).gethName(), (i+1)+"월");
		    	}else if(res==null){
		    		dataset.addValue(0.0, hList.get(j).gethName(), (i+1)+"월");
		    	}
		    }
		  }
		return dataset;
	}

}