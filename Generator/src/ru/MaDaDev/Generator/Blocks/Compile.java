package ru.MaDaDev.Generator.Blocks;

import java.awt.Color;

import ru.MaDaDev.Generator.Gui.Button;
import ru.MaDaDev.Generator.Utils.BgPanel;

public class Compile extends BgPanel {
	private static final long serialVersionUID = 1L;

	private static final int MARGIN_LEFT = 6;
	private static final int MARGIN_TOP = 6;
	
	public Compile() {
		super("/res/images/bg/bgCompile.png");
		
		this.add(new Button(MARGIN_LEFT + 8, MARGIN_TOP + 10, 198, 32, "Загрузить шаблон", "/res/images/button.png", "/res/font.ttf", 16, Color.BLACK));
		this.add(new Button(MARGIN_LEFT + 8, MARGIN_TOP + 50, 198, 32, "Сохранить шаблон", "/res/images/button.png", "/res/font.ttf", 16, Color.BLACK));
		this.add(new Button(MARGIN_LEFT + 8, MARGIN_TOP + 90, 198, 32, "Добавить в библиотеку", "/res/images/button.png", "/res/font.ttf", 16, Color.BLACK));
		this.add(new Button(MARGIN_LEFT + 215, MARGIN_TOP + 10, 147, 145, "", "/res/images/compileBtn.png", "/res/font.ttf", 16, Color.BLACK));
	}
	
	public void test() {
		System.out.println("проверка тип");
	}
}
