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
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblmName = new JLabel("아이디");
		lblmName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblmName);
		lblmNo = new JLabel();
		tfmName = new JTextField();
		tfmName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfmName);
		tfmName.setColumns(10);
		
		JLabel lblmPassword = new JLabel("비밀번호");
		lblmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblmPassword);

		tfmPassword = new JPasswordField();
		tfmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfmPassword);
		tfmPassword.setColumns(10);		
		
		btnOk = new JButton("로그인");
		btnOk.addActionListener(this);				
		add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		add(btnCancel);
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
