package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomDialog dialog = new CustomDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			JLabel lblCustomer = new JLabel("");
			lblCustomer.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblCustomer);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.CENTER);
			buttonPane.setLayout(new GridLayout(2, 2, 0, 0));
			{
				JButton btnEdit = new JButton("수정");
				btnEdit.setActionCommand("OK");
				buttonPane.add(btnEdit);
				getRootPane().setDefaultButton(btnEdit);
			}
			{
				JButton btnDel = new JButton("삭제");
				btnDel.setActionCommand("Cancel");
				buttonPane.add(btnDel);
			}
			{
				JButton btnOrder = new JButton("주문");
				btnOrder.setActionCommand("OK");
				buttonPane.add(btnOrder);
			}
			{
				JButton btnHairInfo = new JButton("헤어정보");
				btnHairInfo.setActionCommand("Cancel");
				buttonPane.add(btnHairInfo);
			}
		}
	}

}
