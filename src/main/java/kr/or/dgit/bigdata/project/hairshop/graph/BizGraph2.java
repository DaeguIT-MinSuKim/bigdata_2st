package kr.or.dgit.bigdata.project.hairshop.graph;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BizGraph2{

	final String CUT = "커트";
	final String DRY = "드라이";
	final String SHAMPOO = "샴푸";
	final String PERM = "펌";
	final String MAGIC = "매직";
	final String TREATMENT = "트리트먼트";
	final String AMPLE = "앰플";
	final String ETC = "기타";
	
	final String HAIRTYPE = "헤어종류";
	
	JPanel jp = new JPanel();
	
		
	public BizGraph2(String applicationTitle, String chartTitle) {
		JFreeChart barChart =
				 ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(), PlotOrientation.VERTICAL, true, true, false);
	}


	private CategoryDataset createDataset( ){
		 final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	
		 dataset.addValue(1, CUT, HAIRTYPE);
		 dataset.addValue(2,  DRY, HAIRTYPE);
		 dataset.addValue(3, SHAMPOO, HAIRTYPE);
		 dataset.addValue(4, PERM, HAIRTYPE);
		 dataset.addValue(5, MAGIC, HAIRTYPE);
		 dataset.addValue(6, TREATMENT, HAIRTYPE);
		 dataset.addValue(7, AMPLE, HAIRTYPE);
		 dataset.addValue(8, ETC, HAIRTYPE);
		 
		 return dataset;
	}
	
	
}
