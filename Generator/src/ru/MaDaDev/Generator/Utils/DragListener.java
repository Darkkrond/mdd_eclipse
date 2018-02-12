package ru.MaDaDev.Generator.Utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import ru.MaDaDev.Generator.Blocks.SettingsPanel;
import ru.MaDaDev.Generator.Gui.Image;
import ru.MaDaDev.Generator.Gui.Text;
import ru.MaDaDev.Generator.Main.Main;

public class DragListener implements MouseListener, MouseMotionListener {
	private int type;
	private JComponent origComp;
	private JComponent comp;
	public static SettingsPanel settings = new SettingsPanel();
	private int moveX = 0;
	private int moveY = 0;
	
	public void setComponent (JComponent comp) {
		this.origComp = comp;
	}
	
	public DragListener(int type) {
		this.type = type;
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		moveX = e.getXOnScreen() - Main.instance.getX() - (2 * e.getX());
		moveY = e.getYOnScreen() - Main.instance.getY() - (2 * e.getY());
		if (type == 0) {
			if (origComp instanceof Image) {
				comp = new Image(e.getX() + moveX, e.getY() + moveY, origComp.getWidth(), origComp.getHeight(), ((Image) origComp).getImg());
			} else if (origComp instanceof Text) {
				comp = new Text(e.getX() + moveX, e.getY() + moveY, origComp.getWidth(), origComp.getHeight(), ((Text) origComp).getText(), null, 0, null, ((Text) origComp).getAlign());
				comp.setFont(origComp.getFont());
			}
			Main.instance.topPanel.add(comp);
			Main.instance.topPanel.repaint();
		} else {
			comp = origComp;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (type == 0) {
			Main.instance.topPanel.remove(comp);
			Main.instance.template.add(comp);
			Main.instance.repaint();
			settings.setLocation(comp.getLocation().x + comp.getWidth(), comp.getLocation().y - (comp.getLocation().y + SettingsPanel.HEIGHT > Main.HEIGHT ? SettingsPanel.HEIGHT - comp.getHeight() : 0));
			
			settings.creating(comp);
			settings.setVisible(true);
		} else {
			
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		comp.setLocation(e.getX() + moveX, e.getY() + moveY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

}
