package game;
import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;


public class gaame extends GraphicsProgram{
	int currentstate = 1;
	boolean right = false;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	GImage[] forward = new GImage[3];
	
	GRect guy  = new GRect(40,430,50,50);
	GRect solid = new GRect(250,250,27,170);
	
	int width = getWidth();
	int height = getHeight();



	public void run() {
		
		addKeyListeners();

		add(guy);

		add(solid);

		solid.setFilled(true);
		solid.setFillColor(Color.GRAY);

	}

	public void keyPressed(KeyEvent e) {

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
