package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.list.HairinfoTable;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class HairinfoSet extends JPanel implements ActionListener, KeyListener {
	private JTextField tfhNo;
	private JTextField tfhName;
	private JTextField tfhPrice;
	private JButton btnOk;
	private JButton btnCancel;
	private HairinfoTable hairinfoTable;
	private JPanel inputPanel;
	
	public void setInputPanel(JPanel inputPanel) {
		this.inputPanel = inputPanel;
	}
	public void setHairinfoTable(HairinfoTable hairinfoTable) {
		this.hairinfoTable = hairinfoTable;
	}
	/**
	 * Create the panel.
	 */
	public HairinfoSet(String title) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblhNo = new JLabel("헤어번호");
		lblhNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblhNo);
		
		tfhNo = new JTextField();
		tfhNo.setHorizontalAlignment(SwingConstants.RIGHT);
		tfhNo.setEditable(false);
		add(tfhNo);
		tfhNo.setColumns(10);
		
		JLabel lblhName = new JLabel("헤어명");
		lblhName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblhName);
		
		tfhName = new JTextField();
		tfhName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfhName);
		tfhName.setColumns(10);
		
		JLabel lblhPrice = new JLabel("단가");
		lblhPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblhPrice);
	
		tfhPrice = new JTextField();
		tfhPrice.addKeyListener(this);
		tfhPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfhPrice);
		tfhPrice.setColumns(10);
		
		btnOk = new JButton(title);
		btnOk.addActionListener(this);
		add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		add(btnCancel);
	}

	public void sethNo() {
		// tfhNo에 번호를 입력하는 메소드
		List<Hairinfo> hList = HairinfoService.getInstance().selectHairInfoAll();
		if(hList.isEmpty()){
			tfhNo.setText("1");
		}else{
			tfhNo.setText(hList.size()+1+"");
		}
	}
	
	public void setTextFields(Hairinfo hairinfo){
		tfhName.setText(hairinfo.gethName());
		tfhNo.setText(hairinfo.gethNo()+"");
		tfhPrice.setText(hairinfo.gethPrice()+"");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancel) {
			btnCancelActionPerformed(arg0);
		}
		if (arg0.getSource() == btnOk) {
			btnOkActionPerformed(arg0);
		}
	}
	protected void btnOkActionPerformed(ActionEvent arg0) {
		int res = JOptionPane.showConfirmDialog(null, "정말 "+btnOk.getText().trim()+" 하시겠습니까?", "헤어"+btnOk.getText().trim(), JOptionPane.OK_CANCEL_OPTION);
		if(res==JOptionPane.OK_OPTION){
			if(btnOk.getText().trim().equals("추가")){
				Hairinfo h = getHairinfoValue();
				if(h != null){
					HairinfoService.getInstance().insertHairInfo(h);					
				}else{
					JOptionPane.showMessageDialog(null, "추가할 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}else{
				Hairinfo h = getHairinfoValue();
				if(h != null){
					HairinfoService.getInstance().updateHairInfo(h);
				}else{
					JOptionPane.showMessageDialog(null, "수정할 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			JOptionPane.showMessageDialog(null, "성공적으로 "+btnOk.getText().trim()+"되었습니다.");
			hairinfoTable.setTableWithData();
			inputPanel.removeAll();
			inputPanel.repaint();
		}
	}
	private Hairinfo getHairinfoValue() {
		// TODO Auto-generated method stub
		String hNo = tfhNo.getText().trim();
		String hName = tfhName.getText().trim();
		String hPrice = tfhPrice.getText().trim();
		if(hNo!=""&& hName!=""&&hPrice!=""){
			Hairinfo res = new Hairinfo( hName, Integer.parseInt(hPrice));
			res.sethNo(Integer.parseInt(hNo));
			return res;
		}else{
			return null;
		}
	}

	protected void btnCancelActionPerformed(ActionEvent arg0) {
		clearTF();
		inputPanel.removeAll();
		inputPanel.repaint();
	}

	private void clearTF() {
		if(btnOk.getText().equals("추가")){
			sethNo();
		}else{
			
		}
		tfhName.setText("");
		tfhPrice.setText("");
	}
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == tfhPrice) {
			tfhPriceKeyTyped(e);
		}
	}
	protected void tfhPriceKeyTyped(KeyEvent e) {
		/* 아직 이 이벤트를 발생시킨 e 값은 textfield에 입력되지 않았으므로 길이를 제한할 때 이를 고려하여 수정해야 함.*/		
		char c = e.getKeyChar();
		if(!Character.isDigit(c)){
			e.consume();
			return;
		}
		if(tfhPrice.getText().trim().length()>=11){
			e.consume();
			return;
		}
	}
}
