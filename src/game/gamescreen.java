package game;
import java.util.ArrayList;
//happy
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class gamescreen extends GraphicsProgram{
	ArrayList<GObject> objects = new ArrayList<GObject>();
	GImage screenImage = new GImage("mBackground.jpg");
	int APPLICATION_WIDTH = 670;
	int APPLICATION_HEIGHT = 474;
	int currentX = 0;
	int currentY = 0;
	int[][] newImage = new int[474][670];
	int[][] imageArray;
	public gamescreen(GImage inputImage, int xpos, int ypos){
		imageArray = inputImage.getPixelArray();
		currentX = xpos;
		currentY = ypos;
		newImage = getViewed();
		screenImage = new GImage(getFlipped(newImage));
		println("" + newImage.length + " " + newImage[0].length + " " + screenImage.getSize());
	}
	private int[][] getViewed(){
		int[][] newpic = new int[474][670];
		int newpicX = 0;
		int newpicY = 0;
		for(int x = currentX - 335; x < currentX + 335; x++, newpicX++){
			for(int y = currentY - 237; y < currentY + 237; y++, newpicY++){
				//println(" " + newpicX + " " + newpicY + " " + x + " " + y + " " + imageArray.length + " " + imageArray[1].length);
				newpic[newpicY][newpicX] = imageArray[y][x];
			}
			newpicY = 0;
		}
		return newpic;
	}/** Change the image onscreen*/
	public void setImage(GImage inputImage, int xpos, int ypos){
		remove(screenImage);
		imageArray = inputImage.getPixelArray();
		currentX = xpos;
		currentY = ypos;
		newImage = getViewed();
		screenImage = new GImage(getFlipped(newImage));
	}
	public GImage getImage(){
		return screenImage;
	}
	public void register(GObject object){
		//add(object);
		objects.add(object);
	}
	public void register(GObject object, int x, int y){
		//add(object, x, y);
		objects.add(object);
	}
	public void right(){
		for(int x = 0; x < 669; x++){
			for(int y = 0; y < 474; y++){
				newImage[y][x] = newImage[y][x+1];
			}
		}
		for(int y = 0; y < 474; y++){
			newImage[y][669] = imageArray[(currentY + y) - 236][currentX + 335];
		}
		remove(screenImage);
		screenImage = new GImage(getFlipped(newImage));
		moveObjects(-1,0);
		currentX++;
	}
	public void left(){
		for(int x = 669; x > 0; x--){
			for(int y = 0; y < 474; y++){
				newImage[y][x] = newImage[y][x-1];
			}
		}
		for(int y = 0; y < 474; y++){
			newImage[y][0] = imageArray[(currentY + y) - 236][currentX - 334];
		}
		remove(screenImage);
		screenImage = new GImage(getFlipped(newImage));
		moveObjects(1,0);
		currentX--;
	}
	public void forward(){
		for(int x = 0; x < 670; x++){
			for(int y = 473; y > 0; y--){
				newImage[y][x] = newImage[y-1][x];
			}
		}
		for(int x = 0; x < 670; x++){
			newImage[0][x] = imageArray[currentY - 237][(currentX + x) - 334];
		}
		remove(screenImage);
		screenImage = new GImage(getFlipped(newImage));
		moveObjects(0,1);
		currentY--;
	}
	public void backward(){
		for(int x = 0; x < 670; x++){
			for(int y = 0; y < 473; y++){
				newImage[y][x] = newImage[y+1][x];
			}
		}
		for(int x = 0; x < 670; x++){
			newImage[473][x] = imageArray[currentY + 236][currentX + x - 334];
		}
		remove(screenImage);
		screenImage = new GImage(getFlipped(newImage));
		moveObjects(0,-1);
		currentY++;
	}
	private void moveObjects(int xmove, int ymove){
		for(int i = 0; i < objects.size(); i++){
			objects.get(i).move(xmove, ymove);
		}
	}
	public void moveObjectsToFront(){
		for(int i = 0; i < objects.size(); i++){
			objects.get(i).sendToFront();
		}
	}
	public int[][] getFlipped(int[][] image){
		int[][] oldImage = new int[474][670];
		for(int x = 0; x < 670; x++){
			for(int y = 0; y < 474; y++){
				oldImage[y][x] = image[y][x];
			}
		}
		return oldImage;
		}

}
