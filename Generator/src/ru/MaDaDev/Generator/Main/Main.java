package ru.MaDaDev.Generator.Main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import ru.MaDaDev.Generator.Blocks.Compile;
import ru.MaDaDev.Generator.Blocks.Elements;
import ru.MaDaDev.Generator.Blocks.Template;
import ru.MaDaDev.Generator.Blocks.Theme;
import ru.MaDaDev.Generator.Utils.BgPanel;
import ru.MaDaDev.Generator.Utils.DragListener;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public static Main instance;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720; 
	public JPanel topPanel;
	public JPanel template;
	
	public Main() {
		this.setTitle("Генератор лаунчера без хуев");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((d.width - WIDTH) / 2, (d.height - HEIGHT) / 2, WIDTH, HEIGHT);
		JLayeredPane mainPane = new JLayeredPane();
		BgPanel bg = new BgPanel("/res/images/bg.png");
		
		topPanel = new JPanel(null);
		topPanel.setBounds(0, 0, WIDTH, 720);
		topPanel.setOpaque(false);
		
		mainPane.add(bg, JLayeredPane.DEFAULT_LAYER);
		mainPane.add(topPanel, JLayeredPane.DEFAULT_LAYER + 50);
		
		DragListener.settings.setVisible(false);
		topPanel.add(DragListener.settings);
		
		this.setContentPane(mainPane);
		Container c = this.getContentPane();
		
		Elements e = new Elements();
		e.setBounds(891, 0, 389, 540);
		c.add(e);
		
		Compile cp = new Compile();
		cp.setBounds(891, 540, 389, 180);
		c.add(cp);
		
		Theme t = new Theme();
		t.setBounds(0, 540, 891, 180);
		c.add(t);
		
		template = new Template();
		template.setBounds(0, 0, 891, 540);
		c.add(template);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		instance = new Main();
	}
}
