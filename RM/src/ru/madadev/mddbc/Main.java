package ru.madadev.mddbc;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Main instance;
	
	public Main() {
		this.setTitle("Бакуров пидорас");
		this.setSize(500, 300);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize().getSize();
		this.setLocation((d.width - this.getWidth()) / 2, (d.height - this.getHeight()) / 2);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		instance = new Main();
	}
}
