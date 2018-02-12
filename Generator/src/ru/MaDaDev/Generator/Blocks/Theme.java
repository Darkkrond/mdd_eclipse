package ru.MaDaDev.Generator.Blocks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.MaDaDev.Generator.Gui.CheckBox;
import ru.MaDaDev.Generator.Gui.List;
import ru.MaDaDev.Generator.Utils.BgPanel;

public class Theme extends BgPanel {
	private static final long serialVersionUID = 1L;

	private static final int MARGIN_LEFT = 16;
	private static final int MARGIN_TOP = 6;
	
	private List list;
	
	private CheckBox main;
	private CheckBox loginned;
	private CheckBox settings;
	private CheckBox download;
	private CheckBox update;
	
	public Theme() {
		super("/res/images/bg/bgTheme.png");
		
		list = new List("/res/images/bgListTheme.png", 2);
		list.setBounds(MARGIN_LEFT + 10, MARGIN_TOP + 10, 324, 85);
		
		main = new CheckBox(MARGIN_LEFT + 341, MARGIN_TOP + 13, 100, 60, "", "/res/images/screenSelect.png", "/res/font.ttf", 16, Color.BLACK);
		loginned = new CheckBox(MARGIN_LEFT + 445, MARGIN_TOP + 13, 100, 60, "", "/res/images/screenSelect.png", "/res/font.ttf", 16, Color.BLACK);
		settings = new CheckBox(MARGIN_LEFT + 549, MARGIN_TOP + 13, 100, 60, "", "/res/images/screenSelect.png", "/res/font.ttf", 16, Color.BLACK);
		download = new CheckBox(MARGIN_LEFT + 653, MARGIN_TOP + 13, 100, 60, "", "/res/images/screenSelect.png", "/res/font.ttf", 16, Color.BLACK);
		update = new CheckBox(MARGIN_LEFT + 757, MARGIN_TOP + 13, 100, 60, "", "/res/images/screenSelect.png", "/res/font.ttf", 16, Color.BLACK);
		
		main.setSelected(true);
		main.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {changeScreen(0);}});
		loginned.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {changeScreen(1);}});
		settings.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {changeScreen(2);}});
		download.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {changeScreen(3);}});
		update.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {changeScreen(4);}});
		
		this.add(main);
		this.add(loginned);
		this.add(settings);
		this.add(download);
		this.add(update);
		
		this.add(list);
	}
	
	private void changeScreen(int id) {
		if (id != 0) main.setSelected(false);
		if (id != 1) loginned.setSelected(false);
		if (id != 2) settings.setSelected(false);
		if (id != 3) download.setSelected(false);
		if (id != 4) update.setSelected(false);
	}
}
