package kr.or.dgit.bigdata.project.hairshop.graph;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	public DrawingPanel() {
	}
	private static final long serialVersionUID = 1L;

	private int totalBookOwn;
	private int totalOverDue;
	private int totalRent;

	public void paint(Graphics g) {
		for (int cnt = 1; cnt < 7; cnt++) {
			g.drawString(cnt * 5 + "", 25, 155 - 20 * cnt);		//y축 레이블값
			g.drawLine(50, 150 - 20 * cnt, 350, 150 - 20 * cnt);	//x축 선
		}
		
		g.drawLine(50, 150, 350, 150);		//밑에 X축
		g.drawLine(50, 150, 50, 30);		//왼쪽 y축
		g.drawLine(350, 150, 350, 30);		//오른쪽 y축
		
		g.drawString("총보유권수", 70, 165);	//항목레이블
		g.drawString("연체권수", 170, 165);	//항목레이블
		g.drawString("대여권수", 270, 165);	//항목레이블

		g.setColor(Color.RED);
		g.fillRect(80, 150 - totalBookOwn * 4, 30, totalBookOwn * 4);
		g.fillRect(180, 150 - totalOverDue * 4, 30, totalOverDue * 4);
		g.fillRect(280, 150 - totalRent * 4, 30, totalRent * 4);
	}

	public void setScores(int totalBookOwn, int totalOverDue, int totalRent) {
		this.totalBookOwn = totalBookOwn;
		this.totalOverDue = totalOverDue;
		this.totalRent = totalRent;
	}
	
	public static void main(String[] args) {
		
	}
}
