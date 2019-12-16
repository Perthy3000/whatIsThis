package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HitAnimation extends AnimationTimer {
	GraphicsContext gContext;
	
	public HitAnimation(GraphicsContext gc) {
		gContext = gc;
	}
	
	final int WIDTH = 1024;
	final int HEIGHT = 1024;
	final int nWIDTH = WIDTH/8;
	final int nHEIGHT = HEIGHT/8;
	final double CANVAS_WIDTH = 800;
	final double CANVAS_HEIGHT = 800;
	
	final Image hitImage = new Image(ClassLoader.getSystemResource("hit-yellow.png").toString(), WIDTH/2, 0, true, false);
	int frameNum = 0;
	int frameX;
	int frameY;
	int x = 0;
	int y = 0;
	boolean reverse = false;

	@Override
	public void handle(long currentNanoTime) {
		
		
		frameX = frameNum%4;
		frameY = frameNum/4;
		x = frameX*nWIDTH;
		y = frameY*nHEIGHT;
		System.out.println(frameNum);
		
		if(frameNum > 15) this.stop();
		frameNum++;			
		
		gContext.clearRect(220, 20, nWIDTH, nHEIGHT);
		gContext.drawImage(hitImage, x, y, nWIDTH, nHEIGHT, 220, 20, nWIDTH, nHEIGHT);
		
	}
}
