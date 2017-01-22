package kr.or.dgit.bigdata.project.hairshop.fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

import kr.or.dgit.bigdata.project.hairshop.ui.HomePanel;

public class Fonts {

	private InputStream isNB;
	private InputStream isDH;
	private InputStream isHN;
	private InputStream isJua;
	private InputStream isYS;
	private InputStream isNG;
	private Font nanumBrush;
	private Font doHyeon;
	private Font hanNa;
	private Font jua;
	private Font yeonSung;
	private Font nanumGothic;

		
	// Ex) Font sizedNanumBrush32p = nanumBrush.deriveFont(0, 32f); 와 같이 다른 클래스에서 로드해서 사용하면됨
	public Font getNanumBrush() throws FontFormatException, IOException {
		InputStream isNB = Fonts.class.getResourceAsStream("NanumBrush.ttf");
		Font nanumBrush = Font.createFont(Font.TRUETYPE_FONT, isNB); 		// 나눔브러쉬 nanumBrush
		return nanumBrush.deriveFont(0, 10f);
	}

	public Font getDoHyeon() throws FontFormatException, IOException {
		InputStream isDH = Fonts.class.getResourceAsStream("BMDOHYEON_ttf.ttf");
		Font doHyeon = Font.createFont(Font.TRUETYPE_FONT, isDH); 		// 나눔브러쉬 nanumBrush
		return doHyeon.deriveFont(0, 10f);
	}

	public Font getHanNa() throws FontFormatException, IOException {
		InputStream isHN = Fonts.class.getResourceAsStream("BMHANNA_11yrs_ttf.ttf");
		Font hanNa = Font.createFont(Font.TRUETYPE_FONT, isHN);					// 한나체 hanNa
		return hanNa.deriveFont(0, 10f);
	}

	public Font getYeonSung() throws FontFormatException, IOException {
		InputStream isYS = Fonts.class.getResourceAsStream("BMYEONSUNG_ttf.ttf");
		Font yeonSung = Font.createFont(Font.TRUETYPE_FONT, isYS);			// 연성체 yeonSung
		return yeonSung.deriveFont(0, 10f);
	}


	public Font getJua() throws FontFormatException, IOException {
		InputStream isJua = Fonts.class.getResourceAsStream("BMJUA_ttf.ttf");
		Font jua = Font.createFont(Font.TRUETYPE_FONT, isJua);						// 주아체 jua
		return jua.deriveFont(0, 10f);
	}

	public Font getNanumGothic() throws FontFormatException, IOException {
		InputStream isNG = Fonts.class.getResourceAsStream("NANUMGOTHIC.TTF");
		Font nanumGothic = Font.createFont(Font.TRUETYPE_FONT, isNG);	// 나눔고딕체 nanumGothic
		return nanumGothic.deriveFont(0, 10f);
	}
	
}
