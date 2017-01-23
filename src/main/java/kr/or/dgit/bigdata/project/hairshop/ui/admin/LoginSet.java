package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.list.ManagerTable;
import kr.or.dgit.bigdata.project.hairshop.service.ManagerService;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LoginSet extends JPanel implements ActionListener {
	private JTextField tfmName;
	private JPasswordField tfmPassword;
	private JButton btnOk;
	private JButton btnCancel;
	private JLabel lblmNo;
	private JPanel confirmPanel;
	private Manager manager;
	private ManagerTable mTable;
	
	public void setmTable(ManagerTable mTable) {
		this.mTable = mTable;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void setConfirmPanel(JPanel confirmPanel) {
		this.confirmPanel = confirmPanel;
	}

	/**
	 * Create the panel.
	 */
	public LoginSet() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{215, 215, 0};
		gridBagLayout.rowHeights = new int[]{56, 56, 56, 56, 56, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		
		JLabel lblmName = new JLabel("아이디");
		lblmName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblmName = new GridBagConstraints();
		gbc_lblmName.fill = GridBagConstraints.BOTH;
		gbc_lblmName.insets = new Insets(0, 0, 5, 5);
		gbc_lblmName.gridx = 0;
		gbc_lblmName.gridy = 0;
		add(lblmName, gbc_lblmName);
		tfmName = new JTextField();
		tfmName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_tfmName = new GridBagConstraints();
		gbc_tfmName.fill = GridBagConstraints.BOTH;
		gbc_tfmName.insets = new Insets(0, 0, 5, 0);
		gbc_tfmName.gridx = 1;
		gbc_tfmName.gridy = 0;
		add(tfmName, gbc_tfmName);
		tfmName.setColumns(10);
		
		JLabel lblmPassword = new JLabel("비밀번호");
		lblmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblmPassword = new GridBagConstraints();
		gbc_lblmPassword.fill = GridBagConstraints.BOTH;
		gbc_lblmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblmPassword.gridx = 0;
		gbc_lblmPassword.gridy = 1;
		add(lblmPassword, gbc_lblmPassword);
		
				tfmPassword = new JPasswordField();
				tfmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
				GridBagConstraints gbc_tfmPassword = new GridBagConstraints();
				gbc_tfmPassword.fill = GridBagConstraints.BOTH;
				gbc_tfmPassword.insets = new Insets(0, 0, 5, 0);
				gbc_tfmPassword.gridx = 1;
				gbc_tfmPassword.gridy = 1;
				add(tfmPassword, gbc_tfmPassword);
				tfmPassword.setColumns(10);
		
		btnOk = new JButton("로그인");
		btnOk.addActionListener(this);				
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.BOTH;
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 4;
		add(btnOk, gbc_btnOk);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 4;
		add(btnCancel, gbc_btnCancel);
		lblmNo = new JLabel();
	}
	
	public void setTextFields(Manager manager){
		tfmName.setText(manager.getmName());
		lblmNo.setText(Integer.toString(manager.getmNo()));
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancel) {
			btnCancelActionPerformed(arg0);
		}
		if (arg0.getSource() == btnOk) {
			btnOkActionPerformed(arg0);
		}
	}
	
	private void btnCancelActionPerformed(ActionEvent arg0) {
		tfmPassword.setText("");
		confirmPanel.removeAll();
		confirmPanel.revalidate();
		confirmPanel.repaint();
	}
	
	protected void btnOkActionPerformed(ActionEvent arg0) {
		if(btnOk.getText().trim().equals("로그인")){
			String id = tfmName.getText().trim();
			String password = convertToString(tfmPassword);
			if(id.equals("")||password.equals("")){
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 입력해 주세요.");
				return;
			}
			Manager temp = new Manager();
			temp.setmName(id);
			Manager manager = ManagerService.getInstance().selectmPasswordByName(temp);
			if(manager.getmPassword().equals(password.trim())){
				confirmPanel.removeAll();
				AdminSet updPanel = new AdminSet("수정");
				updPanel.setConfirmPanel(confirmPanel);
				updPanel.setmTable(mTable);
				updPanel.setTextFields(manager);
				confirmPanel.add(updPanel);
				confirmPanel.revalidate();
				confirmPanel.repaint();
			}else{
				JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.");
			}
		}
	}
	
	private String convertToString(JPasswordField tfmPassword) {
		String password = "";
		char[] pwList =tfmPassword.getPassword();
		for(int i=0; i < pwList.length; i++){
			password+=pwList[i];
		}
		return password;
	}
}
