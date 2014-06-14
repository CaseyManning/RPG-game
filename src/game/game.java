package game;
import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acmx.export.javax.swing.JButton;

public class game extends GraphicsProgram {
	public static final int APPLICATION_WIDTH = 670;
	public static final int APPLICATION_HEIGHT = 474;
	public void run(){
		GImage Play = new GImage("button.png");
		GImage background = new GImage("mBackground.jpg");
		GLabel PlayText = new GLabel("Play");
		add(background);
		add(Play, (getWidth()/2) - (Play.getWidth()/2), (getHeight()/3) - (Play.getHeight()/2));
		PlayText.setColor(Color.BLACK);
		add(PlayText, Play.getX()/* + (PlayText.getWidth()/2)*/, Play.getY()/* + (Play.getY()/2)*/);
		println(Play.getLocation());
	}
}
