package ru.MaDaDev.Generator.Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;

public class CheckBox extends JCheckBox {
	private static final long serialVersionUID = 1L;

	BufferedImage bgNormal;
	BufferedImage bgChecked;
	
	public CheckBox(int x, int y, int w, int h, String text, String bg, String fontName, float fontSize, Color fontColor) {
		this.setBounds(x, y, w, h);
		this.setText(text);
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		try {
			BufferedImage bgImg = ImageIO.read(CheckBox.class.getResource(bg));
			bgChecked = bgImg.getSubimage(0, 0, bgImg.getWidth(), bgImg.getHeight() / 2);
			bgNormal = bgImg.getSubimage(0, bgImg.getHeight() / 2, bgImg.getWidth(), bgImg.getHeight() / 2);
			this.setFont(Font.createFont(Font.TRUETYPE_FONT, CheckBox.class.getResourceAsStream(fontName)).deriveFont(fontSize));
		} catch (Exception e) {e.printStackTrace();}
		
	}
	
	@Override
	protected void paintComponent(Graphics maing) {
		Graphics2D g = (Graphics2D)maing.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (isSelected()) g.drawImage(bgChecked, 0, 0, bgChecked.getWidth(), getHeight(), null);
		else g.drawImage(bgNormal, 0, 0, bgNormal.getWidth(), getHeight(), null);
		g.drawString(getText(), bgNormal.getWidth() + 10, (getHeight() / 2) + (g.getFontMetrics().getHeight() / 4));
		g.dispose();
	}
}
