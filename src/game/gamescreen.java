package game;
import java.util.ArrayList;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class gamescreen {
	ArrayList<GObject> objects = new ArrayList<GObject>();
	GImage screenImage = new GImage("mBackground.jpg");
	int APPLICATION_WIDTH = 670;
	int APPLICATION_HEIGHT = 474;
	int currentX = 0;
	int currentY = 0;
	int xoff = 0;
	int yoff = 0;
	int[][] newImage;
	int[][] imageArray;
	public gamescreen(GImage inputImage, int xpos, int ypos, int xsize, int ysize){
		APPLICATION_WIDTH = xsize;
		APPLICATION_HEIGHT = ysize;
		imageArray = inputImage.getPixelArray();
		currentX = xpos;
		currentY = ypos;
		newImage = getViewed();
		screenImage = new GImage(newImage);
		
	}
	private int[][] getViewed(){
		int[][] newpic = new int[APPLICATION_HEIGHT][APPLICATION_WIDTH];
		int newpicX = 0;
		int newpicY = 0;
		for(int x = currentX - APPLICATION_WIDTH/2; x < currentX + APPLICATION_WIDTH/2; x++, newpicX++){
			for(int y = currentY - APPLICATION_HEIGHT/2; y < currentY + APPLICATION_HEIGHT/2; y++, newpicY++){
				//println(" " + newpicX + " " + newpicY + " " + x + " " + y + " " + imageArray.length + " " + imageArray[1].length);
				newpic[newpicY][newpicX] = imageArray[y][x];
			}
			newpicY = 0;
		}
		return newpic;
	}/** Change the image onscreen*/
	public void setImage(GImage inputImage, int xpos, int ypos){
		imageArray = inputImage.getPixelArray();
		currentX = xpos;
		currentY = ypos;
		newImage = getViewed();
		screenImage = new GImage(newImage);
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
	/*public void right(){
		for(int x = 0; x < 669; x++){
			for(int y = 0; y < 474; y++){
				newImage[y][x] = newImage[y][x+1];
			}
		}
		for(int y = 0; y < 474; y++){
			newImage[y][669] = imageArray[(currentY + y) - 237][currentX + 335];
		}
		screenImage = new GImage(newImage);
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
			newImage[y][0] = imageArray[(currentY + y) - 237][currentX - 336];
		}
		screenImage = new GImage(newImage);
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
			newImage[0][x] = imageArray[currentY - 238][(currentX + x) - 335];
		}
		screenImage = new GImage(newImage);
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
			newImage[473][x] = imageArray[currentY + 237][currentX + x - 335];
		}
		screenImage = new GImage(newImage);
		moveObjects(0,-1);
		currentY++;
	}*/
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
	public void move(int xmove, int ymove){
		currentX += xmove;
		currentY += ymove;
		//int[][] newerImage = new int[APPLICATION_WIDTH][APPLICATION_HEIGHT];
		/*for(int x = -((xmove - Math.abs(xmove))/2); x < APPLICATION_WIDTH - (xmove + Math.abs(xmove))/2; x++){
			for(int y = -((ymove - Math.abs(ymove))/2); x < APPLICATION_HEIGHT - (ymove + Math.abs(xmove))/2; x++){
				newerImage[x][y] = newImage[x + xmove][y + ymove];
			}
		}
		for(int y = 0; y < APPLICATION_HEIGHT; y++){
			for(int x = 0; x < ((xmove + Math.abs(xmove))/2); x++){
				newerImage[x][y] = imageArray[(currentX - ((APPLICATION_WIDTH + 1)/2)) + x][(currentY - ((APPLICATION_HEIGHT + 1)/2)) + y];
			}
			for(int x = APPLICATION_WIDTH - 1; x >= APPLICATION_WIDTH - (xmove + Math.abs(xmove))/2; x--){
				newerImage[x][y] = imageArray[(currentX - ((APPLICATION_WIDTH + 1)/2)) + x][(currentY - ((APPLICATION_HEIGHT + 1)/2)) + y];
			}
		}
		for(int x = 0; x < APPLICATION_WIDTH; x++){
			for(int y = 0; y < ((ymove + Math.abs(ymove))/2); x++){
				newerImage[x][y] = imageArray[(currentX - ((APPLICATION_WIDTH + 1)/2)) + x][(currentY - ((APPLICATION_HEIGHT + 1)/2)) + y];
			}
			for(int y = APPLICATION_HEIGHT - 1; y >= APPLICATION_HEIGHT - (ymove + Math.abs(ymove))/2; y--){
				newerImage[x][y] = imageArray[(currentX - ((APPLICATION_WIDTH + 1)/2)) + x][(currentY - ((APPLICATION_HEIGHT + 1)/2)) + y];
			}
		}*/
		if(currentY + (APPLICATION_HEIGHT/2) >= imageArray.length){
			ymove -= (currentY + 1 + (APPLICATION_HEIGHT/2)) - imageArray.length;
		}
		if(currentX + (APPLICATION_WIDTH/2) >= imageArray[0].length){
			xmove -= (currentX + 1 + (APPLICATION_WIDTH/2)) - imageArray[0].length;
		}
		if(currentY - (APPLICATION_HEIGHT/2) < 0){
			ymove -= (currentY - (APPLICATION_HEIGHT/2));
		}
		if(currentX - (APPLICATION_WIDTH/2) < 0){
			xmove -= (currentX - (APPLICATION_WIDTH/2));
		}
		if(currentY + (APPLICATION_HEIGHT/2) >= imageArray.length){
			currentY -= (currentY + 1 + (APPLICATION_HEIGHT/2)) - imageArray.length;
		}
		if(currentX + (APPLICATION_WIDTH/2) >= imageArray[0].length){
			currentX -= (currentX + 1 + (APPLICATION_WIDTH/2)) - imageArray[0].length;
		}
		if(currentY - (APPLICATION_HEIGHT/2) < 0){
			currentY -= (currentY - (APPLICATION_HEIGHT/2));
		}
		if(currentX - (APPLICATION_WIDTH/2) < 0){
			currentX -= (currentX - (APPLICATION_WIDTH/2));
		}
		for(int x = 0; x < APPLICATION_WIDTH; x++){
			for(int y = 0; y < APPLICATION_HEIGHT; y++){
				newImage[y][x] = imageArray[(currentY + y) - ((APPLICATION_HEIGHT - 1)/2)][(currentX + x) - ((APPLICATION_WIDTH - 1)/2)];
			}
		}
		//newImage = newerImage;
		screenImage = new GImage(newImage);
		moveObjects(-xmove, -ymove);
	}
	/*
	 * if(yoff == 0 && xoff == 0){
	 * 
	 * }
	 */

}
