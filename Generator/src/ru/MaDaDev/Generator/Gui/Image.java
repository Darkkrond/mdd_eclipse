package ru.MaDaDev.Generator.Gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import ru.MaDaDev.Generator.Utils.DragListener;

public class Image extends JComponent {
	private static final long serialVersionUID = 1L;

	BufferedImage bg;
	String img;
	
	public Image(int x, int y, int w, int h, String path) {
		this.img = path;
		this.setBounds(x, y, w, h);
		try {
			bg = ImageIO.read(Image.class.getResource(path));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public Image(int x, int y, int w, int h, String path, DragListener drag) {
		this.img = path;
		this.setBounds(x, y, w, h);
		if (drag != null) {
			drag.setComponent(this);
			this.addMouseListener(drag);
			this.addMouseMotionListener(drag);
		}
		try {
			bg = ImageIO.read(Image.class.getResource(path));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public String getImg() {
		return this.img;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
	}
}
