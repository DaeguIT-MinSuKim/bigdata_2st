package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.list.HairEventTable;
import kr.or.dgit.bigdata.project.hairshop.list.HairinfoTable;
import kr.or.dgit.bigdata.project.hairshop.list.ManagerTable;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;
import kr.or.dgit.bigdata.project.hairshop.service.ManagerService;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class AdminSettingPanel extends JPanel implements ActionListener, MouseListener {
	private ManagerTable table;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JPanel confirmPanel;
	private JButton btnDel;

	/**
	 * Create the panel.
	 */
	public AdminSettingPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uAD00\uB9AC\uC790 \uACC4\uC815 \uAD00\uB9AC", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel tbPanel = new JPanel();
		add(tbPanel);
		tbPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		tbPanel.add(scrollPane);
		
		table = new ManagerTable();
		table.addMouseListener(this);
		table.setTableWithData();
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		JPanel btnPanel = new JPanel();
		tbPanel.add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		btnPanel.add(btnAdd);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(this);
		btnPanel.add(btnUpdate);
		
		btnDel = new JButton("삭제");
		btnDel.setEnabled(false);
		btnDel.addActionListener(this);
		btnPanel.add(btnDel);
		
		confirmPanel = new JPanel();
		confirmPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		confirmPanel.setLayout(new BorderLayout());
		add(confirmPanel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDel) {
			btnDelActionPerformed(e);
		}
		if (e.getSource() == btnUpdate) {
			btnUpdatePerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddPerformed(e);
		}
	}
	protected void btnAddPerformed(ActionEvent e) {		
		confirmPanel.removeAll();
		AdminSet addPanel = new AdminSet("추가");
		addPanel.setmTable(table);
		addPanel.setConfirmPanel(confirmPanel);
		confirmPanel.add(new AdminSet("추가"));
		revalidate();
		repaint();
	}
	protected void btnUpdatePerformed(ActionEvent e) {
		confirmPanel.removeAll();
		LoginSet loginUi = new LoginSet();
		Manager manager = table.getSelectedItemWithIndex(table.getSelectedRow());
		loginUi.setTextFields(manager);
		loginUi.setConfirmPanel(confirmPanel);
		loginUi.setmTable(table);
		confirmPanel.add(loginUi);		
		revalidate();
		repaint();
	}

	protected void btnDelActionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?", "삭제", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
			Manager manager = table.getSelectedItemWithIndex(table.getSelectedRow());
			if(manager!=null){
				ManagerService.getInstance().deleteManager(manager);
				JOptionPane.showMessageDialog(null, manager.getmName()+"을 성공적으로 삭제하였습니다.");
				table.setTableWithData();
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			tableMouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	protected void tableMouseClicked(MouseEvent e) {
		btnUpdate.setEnabled(true);
		btnDel.setEnabled(true);
	}
	public void setinitPanel(){
		confirmPanel.removeAll();
		table.setTableWithData();
		confirmPanel.repaint();
		confirmPanel.revalidate();
	}
}
