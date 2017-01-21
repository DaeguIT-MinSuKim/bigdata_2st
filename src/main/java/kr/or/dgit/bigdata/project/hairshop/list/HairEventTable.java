package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.service.HairEventService;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

@SuppressWarnings("serial")
public class HairEventTable extends ListTableSetting {
	private List<HairEvent> eList;
	public HairEventTable() {}

	public void setTableWithData() {
		setColumDataIndex(5);
		setModel(new DefaultTableModel(getDatas(), getColumnData()));		
		tableSetAlignWidth();
	}
	
	private String[][] getDatas() {	
		eList = HairEventService.getInstance().selectEventAll();
		if(!eList.isEmpty()){
			String[][] res = new String[eList.size()][];
			for(int i=0;i<res.length;i++){
				res[i] = eList.get(i).toArray();
			}
			return res;
		}
		return new String[][]{};
	}
	public HairEvent getSelectedItemWithIndex(int index){
		return eList.get(index);
	}
	
}
