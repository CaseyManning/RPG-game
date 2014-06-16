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
	int currentstate = 0;
	boolean right = false;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	boolean playing = false;
	
	GImage background = new GImage("mBackground.jpg");
	GLabel PlayText = new GLabel("Play");
	GImage guy  = new GImage( "backwards0.png", 40,430);
	GRect solid = new GRect(250,250,27,170);
	GRect peerson = new GRect(400, 100, 50,50);

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
		if(playing == false) {
		if(click.equals(Play) || click.equals(PlayText)) {
			removeAll();
			play();
		}
		}
		if(playing == true) {
			GObject j = getElementAt(e.getX(), e.getY());
			if(j.equals(peerson)) {
				println("HI!");
			}
		}
	}
	public void play() {

		addKeyListeners();
		playing = true;
		add(guy);
		add(solid);

		solid.setFilled(true);
		solid.setFillColor(Color.GRAY);
		add(peerson);

	}
	public void keyPressed(KeyEvent e) {
		if(playing){
			int key = e.getKeyCode();
			if(currentstate < 3){
				currentstate++;
			}
			else{
				currentstate = 0;
			}
			for(int i = 0; i < 8; i++) {
				walk(key);

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
						guy.setImage("left" + currentstate + ".png");
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
						guy.setImage("right" + currentstate + ".png");
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
						guy.setImage("backwards" + currentstate + ".png");
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
						guy.setImage("foward" + currentstate + ".png");
					}
				}
			}
		}
	}
}
