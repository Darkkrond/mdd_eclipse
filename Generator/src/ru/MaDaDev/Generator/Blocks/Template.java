package ru.MaDaDev.Generator.Blocks;

import javax.swing.JComponent;

import ru.MaDaDev.Generator.Utils.BgPanel;

public class Template extends BgPanel {
	private static final long serialVersionUID = 1L;

	private static final int MARGIN_LEFT = 14;
	private static final int MARGIN_TOP = 14;
	
	public Template() {
		super("/res/images/bg/bgDefault.png");
		
		
	}
	
	
	
	public int addComponent(JComponent comp) {
		this.add(comp);
		return comp.getComponentCount();
	}
}
