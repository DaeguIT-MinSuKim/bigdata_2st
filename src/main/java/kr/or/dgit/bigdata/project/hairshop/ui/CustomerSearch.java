package kr.or.dgit.bigdata.project.hairshop.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerSearch extends JPanel {
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Create the panel.
	 */
	public CustomerSearch() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnSearch = new JPanel();
		pnSearch.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnSearch, BorderLayout.NORTH);
		
		JLabel lblSearch = new JLabel("검색 : ");
		pnSearch.add(lblSearch);
		
		txtSearch = new JTextField();
		pnSearch.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.
			}
		});
		pnSearch.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"고객번호", "고객명", "생년월일", "가입일자"
			}
		));
		scrollPane.setViewportView(table);
		
	}

}
