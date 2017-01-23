package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.list.HairEventTable;
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

public class HairEvnetAdminPanel extends JPanel implements ActionListener, MouseListener {
	private HairEventTable table;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JPanel inputPanel;

	/**
	 * Create the panel.
	 */
	public HairEvnetAdminPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "헤어 이벤트 관리", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel tbPanel = new JPanel();
		add(tbPanel);
		tbPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		tbPanel.add(scrollPane);
		
		table = new HairEventTable();
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
		HairEventSet addPanel = new HairEventSet("추가");
		addPanel.sethNo();
		setInputPanel(addPanel);		
	}
	protected void btnUpdatePerformed(ActionEvent e) {
		btnUpdate.setEnabled(false);
		HairEvent selected = table.getSelectedItemWithIndex(table.getSelectedRow());
		HairEventSet updPanel = new HairEventSet("수정");
		updPanel.setTextFields(selected);
		setInputPanel(updPanel);
	}
	private void setInputPanel(HairEventSet panel) {
		inputPanel.removeAll();
		panel.setInputPanel(inputPanel);
		panel.setHairEventTable(table);
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
		table.setTableWithData();
		inputPanel.removeAll();
	}
}
