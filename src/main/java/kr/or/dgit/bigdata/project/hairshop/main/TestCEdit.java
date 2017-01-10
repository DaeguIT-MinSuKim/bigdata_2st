package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;
import kr.or.dgit.bigdata.project.hairshop.ui.CustomerManageEdit;

public class TestCEdit extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JTable table;
	private CustomerManageEdit panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCEdit frame = new TestCEdit();
					frame.setBounds(100, 100, 1100, 700);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestCEdit() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new CustomerManageEdit();
		
		contentPane.add(panel, BorderLayout.CENTER);
		table = panel.getTable();
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JButton btnInsert = new JButton("update");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cNo = Integer.parseInt(panel.getTxtCno().getText()); 
				int dobYear = Integer.parseInt(panel.getTxtD1().getText());
				int dobMonth = Integer.parseInt(panel.getTxtD2().getText())-1;
				int dobDate = Integer.parseInt(panel.getTxtD3().getText());
				
				int djYear = Integer.parseInt(panel.getTxtDJ1().getText());
				int djMonth = Integer.parseInt(panel.getTxtDJ2().getText())-1;
				int djDate = Integer.parseInt(panel.getTxtDJ3().getText());
				
				String name = panel.getTxtCname().getText();
				
				String p1 = panel.getTxtP1().getText();
				String p2 = panel.getTxtP2().getText();
				String p3 = panel.getTxtP3().getText();
				
				GregorianCalendar dobCal = new GregorianCalendar(dobYear, dobMonth, dobDate);
				GregorianCalendar djCal = new GregorianCalendar(djYear, djMonth, djDate);
				Customer insCtm = new Customer();
				insCtm.setcNo(cNo);
				insCtm.setcName(name);
				insCtm.setcDob(dobCal.getTime());
				insCtm.setcDoJoin(djCal.getTime());
				insCtm.setcPhone(p1+"-"+p2+"-"+p3);
				insCtm.setcDel(false);
				

				CustomerService.getInstance().updateCustomer(insCtm);
				
				reloadData();
			}

			
		});
		panel_1.add(btnInsert);
		
	}
	
	private void reloadData() {
		DefaultTableModel model = new DefaultTableModel(getRowData(panel.getTxtCno()), getColumnData());
		table.setModel(model);
		tableSetAlignWith();
		
	}

	private void tableSetAlignWith() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(60, 100, 200, 200, 200);
		
	}

	private void tableSetWidth(int... width) {
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	private void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
		

	private String[] getColumnData() {
		return new String[] { "고객 번호", "고객명", "생년월일", "가입일자", "전화번호" };
	}

	private String[][] getRowData(JTextField txtCno) {
		Map<String, Object> map = new HashMap<>();
		int cNo = Integer.parseInt(txtCno.getText());
		map.put("cNo", cNo);
		List<Customer> list = CustomerService.getInstance().searchCustomerByNoForJoin(map);
		System.out.println("[getRowData]size:" + list.size());

		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray();
		}

		return rowDatas;
	}

}
