package game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class game extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = 670;
	public static final int APPLICATION_HEIGHT = 474;
	GImage Play = new GImage("button.png");
	int currentstate = 1;
	boolean right = false;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	boolean playing = false;
	GImage[] foward = new GImage[3];
	GImage background = new GImage("mBackground.jpg");
	GLabel PlayText = new GLabel("Play");
	GRect guy  = new GRect(40,430,50,50);
	GRect solid = new GRect(250,250,27,170);
	GImage foward1 = new GImage("backwards1.png");
	GImage foward2 = new GImage("backwards2.png");
	GImage foward3 = new GImage("backwards3.png");
	GImage left1 = new GImage("left1.png");
	GImage left2 = new GImage("left2.png");
	GImage left3 = new GImage("left3.png");
	GImage right1 = new GImage("right1.png");
	GImage right2 = new GImage("right2.png");
	GImage right3 = new GImage("right3.png");
	GImage backward1 = new GImage("foward1.png");
	GImage backward2 = new GImage("foward2.png");
	GImage backward3 = new GImage("foward3.png");

	int width = getWidth();
	int height = getHeight();

	public void run(){

		addMouseListeners();


		add(background);

		add(Play, (getWidth()/2) - (Play.getWidth()/2), (getHeight()/3) - (Play.getHeight()/2));

		PlayText.setColor(Color.BLACK);
		PlayText.setFont("UbuntuMono-BOLD-24");

		add(PlayText, (getWidth()/2) - (PlayText.getWidth()/2), APPLICATION_HEIGHT/3 + (PlayText.getHeight()/3));

	}

	public void mousePressed(MouseEvent e) {
		GObject click = getElementAt(e.getX(), e.getY());
		println(click);
		if(click == Play || click == PlayText) {
			removeAll();
			play();
		}
	}
	public void play() {

		addKeyListeners();
		playing = true;
		add(guy);

		add(solid);

		solid.setFilled(true);
		solid.setFillColor(Color.GRAY);

	}
	public void keyPressed(KeyEvent e) {
		if(playing){
			int key = e.getKeyCode();

			for(int i = 0; i < 8; i++) {
				walk(key);
				if(currentstate < 3){
					currentstate++;
				}
				else{
					currentstate = 1;
				}
			}
		}
	}


	public void walk(int key) {

		GObject b = getElementAt(guy.getX() - 1, guy.getY());

		if(b != solid) {

			GObject j = getElementAt(guy.getX() - 1, guy.getY() + guy.getHeight());

			if(j != solid) {

				GObject d = getElementAt(guy.getX() - 1, guy.getY() + (guy.getHeight()/2));

				if(d != solid) {

					if(key == KeyEvent.VK_LEFT) {
						left = true;
						guy.move(-1, 0);
					}
				}

			}
		}



		GObject a = getElementAt(guy.getX() + guy.getWidth() + 1,guy.getY());

		if(a != solid) {

			GObject f = getElementAt(guy.getX() + guy.getWidth() + 1,guy.getY() + guy.getHeight());

			if(f != solid) {

				GObject m = getElementAt(guy.getX() + guy.getWidth() + 1,guy.getY() + (guy.getHeight()/2));

				if(m != solid) {


					if(key == KeyEvent.VK_RIGHT) {
						right = true;
						guy.move(1, 0);
					}
				}
			}
		}


		GObject g = getElementAt(guy.getX() + (guy.getWidth()/2),guy.getY() - 1);

		if(g != solid) {


			GObject c = getElementAt(guy.getX(),guy.getY() - 1);

			if(c != solid) {

				GObject p = getElementAt(guy.getX() + guy.getWidth(),guy.getY() - 1);

				if(p != solid) {

					if(key == KeyEvent.VK_UP) {
						up = true;
						guy.move(0, -1);
					}
				}
			}
		}


		GObject l = getElementAt(guy.getX(),guy.getY() + guy.getHeight() + 1);

		if(l != solid) {

			GObject n = getElementAt(guy.getX() + guy.getWidth(),guy.getY() + guy.getHeight() + 1);

			if(n != solid) {

				GObject k = getElementAt(guy.getX() + (guy.getWidth()/2),guy.getY() + guy.getHeight() + 1);

				if(k != solid) {



					if(key == KeyEvent.VK_DOWN) {
						down = true;
						guy.move(0, 1);
					}
				}
			}
		}
	}
}
