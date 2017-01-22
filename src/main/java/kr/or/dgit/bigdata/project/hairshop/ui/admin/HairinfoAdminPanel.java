package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.list.HairinfoTable;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

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

public class HairinfoAdminPanel extends JPanel implements ActionListener, MouseListener {
	private HairinfoTable table;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JPanel inputPanel;

	/**
	 * Create the panel.
	 */
	public HairinfoAdminPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "헤어 정보 관리", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel tbPanel = new JPanel();
		add(tbPanel);
		tbPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		tbPanel.add(scrollPane);
		
		table = new HairinfoTable();
		table.addMouseListener(this);
		table.setTableWithData();
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		JPanel btnPanel = new JPanel();
		tbPanel.add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		btnPanel.add(btnAdd);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(this);
		btnPanel.add(btnUpdate);
		
		inputPanel = new JPanel();
		inputPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		inputPanel.setLayout(new BorderLayout());
		add(inputPanel);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			btnUpdatePerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddPerformed(e);
		}
	}
	protected void btnAddPerformed(ActionEvent e) {		
		HairinfoSet addPanel = new HairinfoSet("추가");
		addPanel.sethNo();
		setInputPanel(addPanel);		
	}
	protected void btnUpdatePerformed(ActionEvent e) {
		Hairinfo selected = table.getSelectedItemWithIndex(table.getSelectedRow());
		HairinfoSet updPanel = new HairinfoSet("수정");
		updPanel.setTextFields(selected);
		setInputPanel(updPanel);
	}
	private void setInputPanel(HairinfoSet panel) {
		inputPanel.removeAll();
		panel.setInputPanel(inputPanel);
		panel.setHairinfoTable(table);
		inputPanel.add(panel, BorderLayout.CENTER);
		revalidate();
		repaint();
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
	}
	
	public void setInitPanel(){
		inputPanel.removeAll();
	}
}
