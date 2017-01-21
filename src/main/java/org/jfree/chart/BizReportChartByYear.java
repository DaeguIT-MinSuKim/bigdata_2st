package org.jfree.chart;

import java.awt.Font;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

public class BizReportChartByYear extends JFrame  {
		
	  public BizReportChartByYear(String title) throws IOException {
		super(title);
		CategoryDataset dataset = createDateset();
		JFreeChart chart = createChart(dataset);	  
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(700,500));
		setContentPane(chartPanel);
		pack();  
	  }

	private JFreeChart createChart(CategoryDataset dataset) {
		// TODO Auto-generated method stub
		JFreeChart chart = ChartFactory.createStackedBarChart(
			      "년도별 매출 실적"
			      , ""
			      , "실적"
			      , dataset
			      , PlotOrientation.VERTICAL
			      , true
			      , true
			      , false);
			  
		  chart.setBackgroundPaint(java.awt.Color.white);
		  /* 한글이 깨져보이는 경우 해결책 */
		  // 제목
		  chart.getTitle().setFont(new Font("돋움", Font.BOLD, 15));
		  // 범례
		  chart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 10));
		  
		  CategoryPlot plot = chart.getCategoryPlot();
		  
		  Font font = plot.getDomainAxis().getLabelFont();
		  // X축 라벨
		  plot.getDomainAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize()));
		  // X축 도메인
		  plot.getDomainAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10));
		  
		  font = plot.getRangeAxis().getLabelFont();
		  // Y축 라벨
		  plot.getRangeAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize()));
		  // Y축 범위
		  plot.getRangeAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10));
		return chart;
	}

	private CategoryDataset createDateset() {
		/* Create Dateset and insert Datas */
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		List<Hairinfo> hList = HairinfoService.getInstance().selectHairInfoAll();
		Set<Integer> tempList = BizService.getInstance().selectBDateYear();
		Integer[] yList = tempList.toArray(new Integer[tempList.size()]);
		HashMap<String, Object> searchMap = new HashMap<>();
		
		for (int i=0; i < yList.length; i++) {
			searchMap.put("year", yList[i]);
		    for (int j=0; j < hList.size(); j++) {
		    	searchMap.put("hNo", hList.get(j).gethNo());
		    	HashMap<String, Object> res = BizService.getInstance().selectBizWithHairInfo(searchMap);
		    	if(res != null){
		    		double dres = (double) res.get("sum");
		    		dataset.addValue(dres, hList.get(j).gethName(), yList[i]+"년");
		    	}else if(res==null){
		    		dataset.addValue(0.0, hList.get(j).gethName(), yList[i]+"년");
		    	}
		    }
		  }
		return dataset;
	}

}