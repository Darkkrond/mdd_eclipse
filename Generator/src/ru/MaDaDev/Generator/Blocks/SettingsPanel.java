package ru.MaDaDev.Generator.Blocks;

import java.awt.Color;

import javax.swing.JComponent;

import ru.MaDaDev.Generator.Gui.Button;
import ru.MaDaDev.Generator.Gui.Text;
import ru.MaDaDev.Generator.Gui.TextField;
import ru.MaDaDev.Generator.Utils.BgPanel;

public class SettingsPanel extends BgPanel {
	private static final long serialVersionUID = 1L;

	private static final int MARGIN_LEFT = 6;
	private static final int MARGIN_TOP = 6;
	public static final int WIDTH = 274;
	public static final int HEIGHT = 352;
	
	TextField bgImg;
	TextField bgColor;
	TextField fgColor;
	TextField text;
	TextField font;
	TextField fontSize;
	
	TextField x;
	TextField y;
	TextField w;
	TextField h;
	
	Button save;
	
	public SettingsPanel() {
		super("/res/images/bg/bgSettingsBlock.png");
		this.setSize(WIDTH, HEIGHT);
		
		bgImg = new TextField(MARGIN_LEFT + 14, MARGIN_TOP + 43, 239, 27, "/res/elements/tf.png", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		bgColor = new TextField(MARGIN_LEFT + 14, MARGIN_TOP + 74 + 18, 115, 27, "FFFFFF", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		fgColor = new TextField(MARGIN_LEFT + 138, MARGIN_TOP + 74 + 18, 115, 27, "000000", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		text = new TextField(MARGIN_LEFT + 14, MARGIN_TOP + 117 + 18, 239, 27, "/res/elements/tf.png", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		font = new TextField(MARGIN_LEFT + 14, MARGIN_TOP + 161 + 18, 115, 27, "/res/font.ttf", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		fontSize = new TextField(MARGIN_LEFT + 138, MARGIN_TOP + 161 + 18, 115, 27, "16", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		x = new TextField(MARGIN_LEFT + 14, MARGIN_TOP + 211 + 18, 115, 27, "x", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		y = new TextField(MARGIN_LEFT + 138, MARGIN_TOP + 211 + 18, 115, 27, "y", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		w = new TextField(MARGIN_LEFT + 14, MARGIN_TOP + 259 + 18, 115, 27, "w", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		h = new TextField(MARGIN_LEFT + 138, MARGIN_TOP + 259 + 18, 115, 27, "h", "/res/images/textField.png", "/res/font.ttf", 14, Color.BLACK);
		save = new Button(MARGIN_LEFT + 50, MARGIN_TOP + 310, 161, 27, "Завершить создание", "/res/images/button.png", "/res/font.ttf", 14, Color.BLACK);
		
		this.add(new Text(MARGIN_LEFT + 14, MARGIN_TOP + 25, 234, 20, "Фоновая картинка", "/res/font.ttf", 14, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 74, 115, 20, "Цвет фона (RGBA)", "/res/font.ttf", 12, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 136, MARGIN_TOP + 74, 120, 20, "Цвет текста (RGBA)", "/res/font.ttf", 12, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 14, MARGIN_TOP + 117, 234, 20, "Текст", "/res/font.ttf", 14, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 161, 115, 20, "Шрифт", "/res/font.ttf", 14, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 136, MARGIN_TOP + 161, 120, 20, "Размер текста", "/res/font.ttf", 14, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 211, 115, 20, "Смещение по X", "/res/font.ttf", 14, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 136, MARGIN_TOP + 211, 120, 20, "Смещение по Y", "/res/font.ttf", 14, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 12, MARGIN_TOP + 259, 115, 20, "Ширина", "/res/font.ttf", 14, Color.BLACK, 1));
		this.add(new Text(MARGIN_LEFT + 136, MARGIN_TOP + 259, 120, 20, "Высота", "/res/font.ttf", 14, Color.BLACK, 1));
		
		this.add(bgImg);
		this.add(bgColor);
		this.add(fgColor);
		this.add(text);
		this.add(font);
		this.add(fontSize);
		this.add(x);
		this.add(y);
		this.add(w);
		this.add(h);
		this.add(save);
	}
	
	public void creating(JComponent comp) {
		this.bgColor.setText(Integer.toHexString(comp.getBackground().getRGB()).toUpperCase());
		this.fgColor.setText(Integer.toHexString(comp.getForeground().getRGB()).toUpperCase());
	}
}
