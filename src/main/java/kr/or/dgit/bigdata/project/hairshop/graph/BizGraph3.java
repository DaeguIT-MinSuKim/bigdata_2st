package kr.or.dgit.bigdata.project.hairshop.graph;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BizGraph3 extends ChartPanel {
	static JFreeChart barChart;
	
	public BizGraph3() {
		super(barChart);
	}
	
	public BizGraph3(String applicationTitle, String chartTitle) {
		super(barChart);
		
		barChart = ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(), PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		 
	}

	 private CategoryDataset createDataset( ){
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
	
		 dataset.addValue(1, CUT, HAIRTYPE);
		 dataset.addValue(2,  DRY, HAIRTYPE);
		 dataset.addValue(3, SHAMPOO, HAIRTYPE);
		 dataset.addValue(4, PERM, HAIRTYPE);
		 dataset.addValue(5, MAGIC, HAIRTYPE);
		 dataset.addValue(6, TREATMENT, HAIRTYPE);

		 return dataset;
	}
	 
}
