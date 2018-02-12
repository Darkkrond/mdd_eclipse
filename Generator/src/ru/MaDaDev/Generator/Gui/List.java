package ru.MaDaDev.Generator.Gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class List extends JComponent {
	private static final long serialVersionUID = 1L;

	private BufferedImage bgUp;
	private BufferedImage bgMiddle1;
	private BufferedImage bgMiddle2;
	private BufferedImage bgDown;
	
	private int count;
	
	public List(String path, int count) {
		this.count = count;
		try {
			BufferedImage bg = ImageIO.read(List.class.getResource(path));
			int h = bg.getHeight() / 4;
			
			bgUp = bg.getSubimage(0, 0, bg.getWidth(), h);
			bgMiddle1 = bg.getSubimage(0, h, bg.getWidth(), h);
			bgMiddle2 = bg.getSubimage(0, h * 2, bg.getWidth(), h);
			bgDown = bg.getSubimage(0, h * 3, bg.getWidth(), h);
		} catch (IOException e) {e.printStackTrace();}
	}
	
	@Override
	protected void paintComponent(Graphics gr) {
		Graphics2D g = (Graphics2D) gr.create();
		
		g.drawImage(bgUp, 0, 0, bgUp.getWidth(), bgUp.getHeight(), null);
		int num;
		for (num = 0; num < count - 2; num++) {
			g.drawImage((num % 2 == 0 ? bgMiddle1 : bgMiddle2), 0, bgUp.getHeight() * (num + 1), bgUp.getWidth(), bgUp.getHeight(), null);
		}
		g.drawImage(bgDown, 0, bgUp.getHeight() * (num + 1), bgUp.getWidth(), bgUp.getHeight(), null);
		
		g.dispose();
		super.paintComponent(gr);
	}
}
