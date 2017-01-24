package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.list.HairEventTable;
import kr.or.dgit.bigdata.project.hairshop.service.HairEventService;

public class HairEventSet extends JPanel implements ActionListener, KeyListener {
	private JTextField tfeNo;
	private JTextField tfeName;
	private JTextField tfeDiscount;
	private JButton btnOk;
	private JButton btnCancel;
	private HairEventTable hairEventTable;
	private JPanel inputPanel;
	
	public void setInputPanel(JPanel inputPanel) {
		this.inputPanel = inputPanel;
	}
	public void setHairEventTable(HairEventTable hairEventTable) {
		this.hairEventTable = hairEventTable;
	}

	/**
	 * Create the panel.
	 */
	public HairEventSet(String title) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lbleNo = new JLabel("이벤트 번호");
		lbleNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbleNo);
		
		tfeNo = new JTextField();
		tfeNo.setHorizontalAlignment(SwingConstants.RIGHT);
		tfeNo.setEditable(false);
		add(tfeNo);
		tfeNo.setColumns(10);
		
		JLabel lbleName = new JLabel("이벤트 명");
		lbleName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbleName);
		
		tfeName = new JTextField();
		tfeName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfeName);
		tfeName.setColumns(10);
		
		JLabel lbleDiscount = new JLabel("할인율");
		lbleDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbleDiscount);

		tfeDiscount = new JTextField();
		tfeDiscount.addKeyListener(this);
		tfeDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfeDiscount);
		tfeDiscount.setColumns(10);
		
		btnOk = new JButton(title);
		btnOk.addActionListener(this);
		add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		add(btnCancel);
	}

	public void sethNo() {
		// tfhNo에 번호를 입력하는 메소드
		List<HairEvent> eList = HairEventService.getInstance().selectEventAll();
		if(eList.isEmpty()){
			tfeNo.setText("1");
		}else{
			tfeNo.setText(eList.size()+1+"");
		}
	}
	
	public void setTextFields(HairEvent hairEvent){
		tfeName.setText(hairEvent.geteName());
		tfeNo.setText(hairEvent.geteNo()+"");
		tfeDiscount.setText((int)Math.floor(hairEvent.geteDiscount()*1000.0)/10+"");
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
		int res = JOptionPane.showConfirmDialog(null, "정말 "+btnOk.getText().trim()+" 하시겠습니까?", "이벤트"+btnOk.getText().trim(), JOptionPane.OK_CANCEL_OPTION);
		if(res==JOptionPane.OK_OPTION){
			if(btnOk.getText().trim().equals("추가")){
				HairEvent e = getHairEventValue();
				if(e != null){
					HairEventService.getInstance().insertEvent(e);
				}else{
					JOptionPane.showMessageDialog(null, "추가할 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}else{
				HairEvent e = getHairEventValue();
				if(e != null){
					HairEventService.getInstance().updateEvent(e);
				}else{
					JOptionPane.showMessageDialog(null, "수정할 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			JOptionPane.showMessageDialog(null, "성공적으로 "+btnOk.getText().trim()+"되었습니다.");
			hairEventTable.setTableWithData();
			inputPanel.removeAll();
			inputPanel.repaint();
		}
	}
	private HairEvent getHairEventValue() {
		// TODO Auto-generated method stub
		String eNo = tfeNo.getText().trim();
		String eName = tfeName.getText().trim();
		String eDiscount = tfeDiscount.getText().trim();
		if(eNo!=""&& eName!=""&&eDiscount!=""){
			HairEvent res = new HairEvent( eName, toDiscountForm(eDiscount));
			res.seteNo(Integer.parseInt(eNo));
			return res;
		}else{
			return null;
		}
	}

	private double toDiscountForm(String eDiscount) {
		return Double.parseDouble(eDiscount)/100.0;
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
		tfeName.setText("");
		tfeDiscount.setText("");
	}
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == tfeDiscount) {
			tfhPriceKeyTyped(e);
		}
	}
	protected void tfhPriceKeyTyped(KeyEvent e) {		
		char c = e.getKeyChar();
		if(!Character.isDigit(c)){
			e.consume();
			return;
		}
		
		if(tfeDiscount.getText().trim().length()>=2){
			tfeDiscount.setText(tfeDiscount.getText().substring(1));
			return;
		}
	}
}
