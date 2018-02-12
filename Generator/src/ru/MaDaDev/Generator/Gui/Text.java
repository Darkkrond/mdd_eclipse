package ru.MaDaDev.Generator.Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import ru.MaDaDev.Generator.Utils.DragListener;

public class Text extends JComponent {
	private static final long serialVersionUID = 1L;

	private String text;
	private int align;
	
	public Text(int x, int y, int w, int h, String text, String fontName, float fontSize, Color color, int align, DragListener drag) {
		setBounds(x, y, w, h);
		setVisible(true);
		setForeground(color);
		setBackground(new Color(0, 0, 0, 0));
		setOpaque(false);
		setFocusable(false);
		this.text = text;
		this.align = align;
		if (drag != null) {
			drag.setComponent(this);
			this.addMouseListener(drag);
			this.addMouseMotionListener(drag);
		}
		try {
			this.setFont(Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(fontName)).deriveFont(fontSize));
		} catch (Exception e) {}
	}
	
	public Text(int x, int y, int w, int h, String text, String fontName, float fontSize, Color color, int align) {
		setBounds(x, y, w, h);
		setVisible(true);
		setForeground(color);
		setBackground(new Color(0, 0, 0, 0));
		setOpaque(false);
		setFocusable(false);
		this.text = text;
		this.align = align;
		try {
			this.setFont(Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(fontName)).deriveFont(fontSize));
		} catch (Exception e) {}
	}
	
	public int getAlign() {
		return this.align;
	}
	
	public String getText() {
		return this.text;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D) g.create();
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = align == 1 ? 0 : (align == 2 ? (getWidth() - g.getFontMetrics().stringWidth(text)) / 2 : (getWidth() - g.getFontMetrics().stringWidth(text)));
		
		gr.drawString(text, 5 + x, 7 + g.getFontMetrics().getHeight() / 2);
		gr.dispose();
		super.paintComponent(g);
	}
}
