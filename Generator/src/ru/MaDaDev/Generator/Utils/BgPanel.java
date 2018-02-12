package ru.MaDaDev.Generator.Utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BgPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage bg;
	public BgPanel(String path) {
		this.setLayout(null);
		try {
			bg = ImageIO.read(BgPanel.class.getResource(path));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
	}
}
