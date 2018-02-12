package ru.MaDaDev.Generator.Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Button extends JButton implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	BufferedImage bgUnpressed;
	BufferedImage bgPressed;
	BufferedImage bgHoverred;
	BufferedImage bgDisabled;
	private boolean pressed;
	private boolean entered;
	
	public Button(int x, int y, int w, int h, String text, String image, String fontName, float fontSize, Color color) {
		this.setBounds(x, y, w, h);
		this.setFocusPainted(false);
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setForeground(color);
		this.addMouseListener(this);
		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusable(false);
		this.setText(text);
		try {
			BufferedImage bg = ImageIO.read(Button.class.getResource(image));
			
			bgUnpressed = bg.getSubimage(0, 0, bg.getWidth(), bg.getHeight() / 4);
			bgPressed = bg.getSubimage(0, bg.getHeight() / 4, bg.getWidth(), bg.getHeight() / 4);
			bgHoverred = bg.getSubimage(0, bg.getHeight() / 4 * 2, bg.getWidth(), bg.getHeight() / 4);
			bgDisabled = bg.getSubimage(0, bg.getHeight() / 4 * 3, bg.getWidth(), bg.getHeight() / 4);
			
			this.setFont(Font.createFont(Font.TRUETYPE_FONT, Button.class.getResourceAsStream(fontName)).deriveFont(fontSize));
		} catch (FontFormatException | IOException e) {e.printStackTrace();}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D) g.create();
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (pressed) gr.drawImage(bgPressed, 0, 0, getWidth(), getHeight(), null);
		else if (entered) gr.drawImage(bgHoverred, 0, 0, getWidth(), getHeight(), null);
		else if (!isEnabled()) gr.drawImage(bgDisabled, 0, 0, getWidth(), getHeight(), null);
		else gr.drawImage(bgUnpressed, 0, 0, getWidth(), getHeight(), null);
		
		gr.dispose();
		super.paintComponent(g);
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {
		this.entered = true;
		repaint();
	}
	public void mouseExited(MouseEvent e) {
		this.entered = false;
		repaint();
	}
	public void mousePressed(MouseEvent e) {
		this.pressed = true;
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		this.pressed = false;
		repaint();
	}
}
