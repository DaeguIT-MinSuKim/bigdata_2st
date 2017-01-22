package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public class AdminSet extends JPanel implements ActionListener, KeyListener {
	private JTextField tfmName;
	private JPasswordField tfmPassword;
	private JButton btnOk;
	private JButton btnCancel;
	private ManagerTable mTable;
	private JLabel lblmPassword2;
	private JPasswordField tfmPassword2;
	private JLabel lblconfirm;
	private JLabel lblmNo;
	private JPanel confirmPanel;
	
	public void setConfirmPanel(JPanel confirmPanel) {
		this.confirmPanel = confirmPanel;
	}
	public void setmTable(ManagerTable mTable) {
		this.mTable = mTable;
	}


	/**
	 * Create the panel.
	 */
	public AdminSet(String title) {
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
				
		tfmPassword2 = new JPasswordField();
		tfmPassword2.addKeyListener(this);
		
		lblmPassword2 = new JLabel("비밀번호 확인");
		lblmPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblmPassword2 = new GridBagConstraints();
		gbc_lblmPassword2.fill = GridBagConstraints.BOTH;
		gbc_lblmPassword2.insets = new Insets(0, 0, 5, 5);
		gbc_lblmPassword2.gridx = 0;
		gbc_lblmPassword2.gridy = 2;
		add(lblmPassword2, gbc_lblmPassword2);
		tfmPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
		tfmPassword2.setColumns(10);
		GridBagConstraints gbc_tfmPassword2 = new GridBagConstraints();
		gbc_tfmPassword2.fill = GridBagConstraints.BOTH;
		gbc_tfmPassword2.insets = new Insets(0, 0, 5, 0);
		gbc_tfmPassword2.gridx = 1;
		gbc_tfmPassword2.gridy = 2;
		add(tfmPassword2, gbc_tfmPassword2);

		lblconfirm = new JLabel("");
		lblconfirm.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblconfirm = new GridBagConstraints();
		gbc_lblconfirm.gridwidth = 2;
		gbc_lblconfirm.fill = GridBagConstraints.BOTH;
		gbc_lblconfirm.insets = new Insets(0, 0, 5, 5);
		gbc_lblconfirm.gridx = 0;
		gbc_lblconfirm.gridy = 3;
		add(lblconfirm, gbc_lblconfirm);
		
		btnOk = new JButton(title);
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);	
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.BOTH;
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 4;
		add(btnOk, gbc_btnOk);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 4;
		add(btnCancel, gbc_btnCancel);
		lblmNo = new JLabel();
	}
	
	public void setTextFields(Manager manager){
		tfmName.setText(manager.getmName());
		lblmNo.setText(Integer.toString(manager.getmNo()));
		System.out.println(lblmNo.getText());
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
		tfmPassword2.setText("");
		setPanelAfterUpdate();
	}
	protected void btnOkActionPerformed(ActionEvent arg0) {
		if(btnOk.getText().trim().equals("수정")){
			String id = tfmName.getText().trim();
			String password = convertToString(tfmPassword);
			if(id.equals("")||password.equals("")){
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 입력해 주세요.");
				return;
			}
			
			Manager temp = new Manager();
			temp.setmNo(Integer.parseInt(lblmNo.getText()));
			temp.setmName(id);
			temp.setmPassword(password);
			
			if(ManagerService.getInstance().selectmPasswordByName(temp)!=null&&ManagerService.getInstance().selectmPasswordByName(temp).getmNo()!=temp.getmNo()){
				JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.","경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			ManagerService.getInstance().updateManager(temp);
			JOptionPane.showMessageDialog(null, "성공적으로 수정하였습니다.");			
			setPanelAfterUpdate();		
			
		}else if(btnOk.getText().trim().equals("추가")){
			String id = tfmName.getText().trim();
			String password = convertToString(tfmPassword);
			
			if(id.equals("")||password.equals("")){
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 입력해 주세요.");
				return;
			}			
			
			Manager temp = new Manager();
			temp.setmName(id);
			temp.setmPassword(password);
			
			if(ManagerService.getInstance().selectmPasswordByName(temp)!=null){
				JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.","경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			ManagerService.getInstance().insertManager(temp);
			JOptionPane.showMessageDialog(null, "성공적으로 추가하였습니다.");
			setPanelAfterUpdate();
		}
	}
	private void setPanelAfterUpdate() {
		// TODO Auto-generated method stub
		mTable.setTableWithData();
		confirmPanel.removeAll();
		confirmPanel.revalidate();
		confirmPanel.repaint();	
	}
	private String convertToString(JPasswordField tfmPassword) {
		String password = "";
		char[] pwList =tfmPassword.getPassword();
		for(int i=0; i < pwList.length; i++){
			password+=pwList[i];
		}
		return password;
	}
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tfmPassword2) {
			passwordFieldKeyReleased(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void passwordFieldKeyReleased(KeyEvent arg0) {
		if(convertToString(tfmPassword).equals(convertToString(tfmPassword2))){
			lblconfirm.setForeground(Color.GREEN);
			lblconfirm.setText("비밀번호가 일치합니다.");
			btnOk.setEnabled(true);
		}else{
			btnOk.setEnabled(false);
		}
		
	}
}
