package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

@SuppressWarnings("serial")
public class HairinfoTable extends ListTableSetting {
	private List<Hairinfo> hList;
	public HairinfoTable() {}

	public void setTableWithData() {
		setColumDataIndex(4);
		setModel(new DefaultTableModel(getDatas(), getColumnData()));		
		tableSetAlignWidth();
	}
	
	private String[][] getDatas() {	
		hList = HairinfoService.getInstance().selectHairInfoAll();
		if(!hList.isEmpty()){
			String[][] res = new String[hList.size()][];
			for(int i=0;i<res.length;i++){
				res[i] = hList.get(i).toArray();
			}
			return res;
		}
		return new String[][]{};
	}
	public Hairinfo getSelectedItemWithIndex(int index){
		return hList.get(index);
	}
	
}
