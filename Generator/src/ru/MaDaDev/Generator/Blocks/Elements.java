package ru.MaDaDev.Generator.Blocks;

import java.awt.Color;

import ru.MaDaDev.Generator.Gui.Image;
import ru.MaDaDev.Generator.Gui.List;
import ru.MaDaDev.Generator.Gui.Text;
import ru.MaDaDev.Generator.Utils.BgPanel;
import ru.MaDaDev.Generator.Utils.DragListener;

public class Elements extends BgPanel {
	private static final long serialVersionUID = 1L;

	private static final int MARGIN_LEFT = 6;
	private static final int MARGIN_TOP = 13;
	
	private List list;
	
	public Elements() {
		super("/res/images/bg/bgElements.png");
		
		list = new List("/res/images/bgList.png", 8);
		list.setBounds(MARGIN_LEFT + 8, MARGIN_TOP + 36, 355, 400);
		
		this.add(new Image(MARGIN_LEFT + 197, MARGIN_TOP + 44, 161, 27, "/res/images/elements/tf.png", new DragListener(0)));
		this.add(new Image(MARGIN_LEFT + 197, MARGIN_TOP + 87, 161, 27, "/res/images/elements/button.png", new DragListener(0)));
		this.add(new Image(MARGIN_LEFT + 197, MARGIN_TOP + 130, 161, 27, "/res/images/elements/ib.png", new DragListener(0)));
		this.add(new Text(MARGIN_LEFT + 197, MARGIN_TOP + 178, 161, 27, "Lable", "/res/font.ttf", 15, Color.BLACK, 2, new DragListener(0)));
		this.add(new Image(MARGIN_LEFT + 264, MARGIN_TOP + 217, 28, 27, "/res/images/elements/img.png", new DragListener(0)));
		this.add(new Image(MARGIN_LEFT + 197, MARGIN_TOP + 262, 161, 25, "/res/images/elements/cb.png", new DragListener(0)));
		this.add(new Text(MARGIN_LEFT + 197, MARGIN_TOP + 307, 161, 27, "News", "/res/font.ttf", 15, Color.BLACK, 2, new DragListener(0)));
		this.add(new Image(MARGIN_LEFT + 197, MARGIN_TOP + 347, 161, 27, "/res/images/elements/bar.png", new DragListener(0)));
		
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 44, 173, 27, "Текстовое поле", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 87, 173, 27, "Текстовая кнопка", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 130, 173, 27, "Графическая кнопка", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 178, 173, 27, "Текст", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 217, 173, 27, "Картинка", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 262, 173, 27, "Галочка", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 307, 173, 27, "Новостной браузер", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 347, 173, 27, "Индикатор состояния", "/res/font.ttf", 15, Color.BLACK, 1));
		this.add(list);
	}

	private void mousePressed(int btnId) {
		
	}
}
