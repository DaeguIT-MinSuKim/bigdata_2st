package kr.or.dgit.bigdata.project.hairshop.taps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.main.HairMain;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;
import kr.or.dgit.bigdata.project.hairshop.ui.HomePanel;

public class PnHome extends JPanel {

	private HomePanel pnHomeMain;

	public PnHome() {
		setLayout(new BorderLayout(0, 0));
		pnHomeMain = new HomePanel();
		pnHomeMain.setBackground(new Color(255, 192, 203));
		add(pnHomeMain, BorderLayout.CENTER);
		
	}
	public HomePanel getPnHomeMain() {
		return pnHomeMain;
	}
	public void setPnHomeMain(HomePanel pnHomeMain) {
		this.pnHomeMain = pnHomeMain;
	}
	

}
