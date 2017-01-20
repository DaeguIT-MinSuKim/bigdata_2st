package kr.or.dgit.bigdata.project.hairshop.admin.setting.service;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFileChooser {
	public FileChooser() {
		setCurrentDirectory(new File(System.getProperty("user.dir")));
		setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		setMultiSelectionEnabled(false);
		setFileFilter(new FileNameExtensionFilter("txt Files", "txt"));
	}
}
