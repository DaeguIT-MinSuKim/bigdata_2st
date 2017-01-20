package kr.or.dgit.bigdata.project.hairshop.taps;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.list.CustomerSearchListForAll;
import kr.or.dgit.bigdata.project.hairshop.list.CustomerSearchListForOne;
import kr.or.dgit.bigdata.project.hairshop.main.HairMain;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerManageEdit;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerManageInsert;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerSearch;

public class PnCusSearch extends JPanel {

	private JPanel pnCusSearchCards;
	private CustomerSearch pnSearchSub;
	private CustomerSearchListForOne tableInSearch;
	private CustomerSearchListForAll tableInSearchForAll;
	private CustomerManageInsert pnCusAdd;
	private CustomerManageEdit pnCusEdit;
	private JPanel pnCusSearchBtns;
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnToMain1;

	public PnCusSearch() {
		setLayout(null);
		
		pnCusSearchCards = new JPanel();
		pnCusSearchCards.setBounds(0, 0, 936, 622);
		pnCusSearchCards.setBackground(new Color(255, 192, 203));
		add(pnCusSearchCards);
		pnCusSearchCards.setLayout(new CardLayout(0, 0));
		pnSearchSub = new CustomerSearch();		
		
		pnCusSearchCards.add(pnSearchSub, "name_1666323161344197");
		tableInSearch = pnSearchSub.getTable();
		tableInSearchForAll = pnSearchSub.getTableForAll();
		
		pnCusAdd = new CustomerManageInsert();
		pnCusSearchCards.add(pnCusAdd, "name_1666358524774753");
		
		pnCusEdit = new CustomerManageEdit();
		pnCusSearchCards.add(pnCusEdit, "name_1666378783739869");
		
		pnCusSearchBtns = new JPanel();
		pnCusSearchBtns.setBounds(938, 0, 144, 622);
		pnCusSearchBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnCusSearchBtns.setBackground(new Color(230, 230, 250));
		add(pnCusSearchBtns);
		
		btnSearch = new JButton("회원검색");
		btnSearch.setForeground(Color.DARK_GRAY);
		btnSearch.setBounds(2, 0, 140, 156);
		
		btnSearch.setBorderPainted(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setContentAreaFilled(true);
		pnCusSearchBtns.setLayout(null);
		btnSearch.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnSearch);	
		
		btnAdd = new JButton("회원추가");
		btnAdd.setForeground(Color.DARK_GRAY);
		btnAdd.setBounds(2, 156, 140, 156);		
		btnAdd.setBorderPainted(false);
		btnAdd.setFocusPainted(false);
		btnAdd.setContentAreaFilled(true);
		btnAdd.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnAdd);
		
		btnSave = new JButton("저장");
		btnSave.setForeground(Color.DARK_GRAY);
		btnSave.setBounds(2, 312, 140, 156);
		btnSave.setBorderPainted(false);
		btnSave.setFocusPainted(false);
		btnSave.setContentAreaFilled(true);
		btnSave.setEnabled(false);
		btnSave.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnSave);
		
		btnToMain1 = new JButton("메인화면");
		btnToMain1.setForeground(Color.DARK_GRAY);
		btnToMain1.setBounds(2, 468, 140, 156);		
		btnToMain1.setBorderPainted(false);
		btnToMain1.setFocusPainted(false);
		btnToMain1.setContentAreaFilled(true);			
		btnToMain1.setBackground(new Color(248, 248, 255));
		pnCusSearchBtns.add(btnToMain1);
		
	}

	public JPanel getPnCusSearchCards() {
		return pnCusSearchCards;
	}

	public void setPnCusSearchCards(JPanel pnCusSearchCards) {
		this.pnCusSearchCards = pnCusSearchCards;
	}

	public CustomerSearch getPnSearchSub() {
		return pnSearchSub;
	}

	public void setPnSearchSub(CustomerSearch pnSearchSub) {
		this.pnSearchSub = pnSearchSub;
	}

	public CustomerSearchListForOne getTableInSearch() {
		return tableInSearch;
	}

	public void setTableInSearch(CustomerSearchListForOne tableInSearch) {
		this.tableInSearch = tableInSearch;
	}

	public CustomerSearchListForAll getTableInSearchForAll() {
		return tableInSearchForAll;
	}

	public void setTableInSearchForAll(CustomerSearchListForAll tableInSearchForAll) {
		this.tableInSearchForAll = tableInSearchForAll;
	}

	public CustomerManageInsert getPnCusAdd() {
		return pnCusAdd;
	}

	public void setPnCusAdd(CustomerManageInsert pnCusAdd) {
		this.pnCusAdd = pnCusAdd;
	}

	public CustomerManageEdit getPnCusEdit() {
		return pnCusEdit;
	}

	public void setPnCusEdit(CustomerManageEdit pnCusEdit) {
		this.pnCusEdit = pnCusEdit;
	}

	public JPanel getPnCusSearchBtns() {
		return pnCusSearchBtns;
	}

	public void setPnCusSearchBtns(JPanel pnCusSearchBtns) {
		this.pnCusSearchBtns = pnCusSearchBtns;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnToMain1() {
		return btnToMain1;
	}

	public void setBtnToMain1(JButton btnToMain1) {
		this.btnToMain1 = btnToMain1;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	
}
