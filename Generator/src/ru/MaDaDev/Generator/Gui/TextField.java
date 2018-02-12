package ru.MaDaDev.Generator.Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextField extends JTextField {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage bgLeft;
	private BufferedImage bgMiddle;
	private BufferedImage bgRight;
	
	public TextField(int x, int y, int w, int h, String text, String image, String fontName, float fontSize, Color color) {
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setForeground(color);
		this.setBorder(new EmptyBorder(2, 2, 2, 2));
		this.setText(text);
		try {
			BufferedImage bg = ImageIO.read(TextField.class.getResource(image));
			bgLeft = bg.getSubimage(0, 0, bg.getWidth() / 3, bg.getHeight());
			bgMiddle = bg.getSubimage(bg.getWidth() / 3, 0, bg.getWidth() / 3, bg.getHeight());
			bgRight = bg.getSubimage(bg.getWidth() / 3 * 2, 0, bg.getWidth() / 3, bg.getHeight());
			
			this.setFont(Font.createFont(Font.TRUETYPE_FONT, TextField.class.getResourceAsStream(fontName)).deriveFont(fontSize));
		} catch (FontFormatException | IOException e) {e.printStackTrace();}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D) g.create();
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		gr.drawImage(bgLeft, 0, 0, bgLeft.getWidth(), getHeight(), null);
		gr.drawImage(bgMiddle, bgLeft.getWidth(), 0, getWidth() - bgLeft.getWidth() - bgRight.getWidth(), getHeight(), null);
		gr.drawImage(bgRight, getWidth() - bgRight.getWidth(), 0, bgRight.getWidth(), getHeight(), null);
		
		gr.dispose();
		super.paintComponent(g);
	}
}
