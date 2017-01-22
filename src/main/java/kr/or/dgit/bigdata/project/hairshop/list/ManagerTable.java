package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.service.HairEventService;
import kr.or.dgit.bigdata.project.hairshop.service.ManagerService;

@SuppressWarnings("serial")
public class ManagerTable extends ListTableSetting {
	private List<Manager> mList;
	public ManagerTable() {}

	public void setTableWithData() {
		setColumDataIndex(6);
		setModel(new DefaultTableModel(getDatas(), getColumnData()));		
		tableSetAlignWidth();
	}
	
	private String[][] getDatas() {	
		mList = ManagerService.getInstance().selectAllManager();
		if(!mList.isEmpty()){
			String[][] res = new String[mList.size()][];
			for(int i=0;i<res.length;i++){
				res[i] = mList.get(i).toArray();
			}
			return res;
		}
		return new String[][]{};
	}
	public Manager getSelectedItemWithIndex(int index){
		return mList.get(index);
	}
	
}
