package gui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HitScene extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		final int WIDTH = 1024;
		final int HEIGHT = 1024;
		final int nWIDTH = WIDTH/8;
		final int nHEIGHT = HEIGHT/8;
		final double CANVAS_WIDTH = 800;
		final double CANVAS_HEIGHT = 800;
		
		Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		final Image hitImage = new Image(ClassLoader.getSystemResource("hit-yellow.png").toString(), WIDTH/2, 0, true, false);
		GraphicsContext gContext = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		new AnimationTimer() {
			
			int frameNum = 0;
			int frameX;
			int frameY;
			int x = 0;
			int y = 0;
			boolean reverse = false;
			
			@Override
			public void handle(long currentNanoTime) {
				
				frameX = frameNum%4;
				frameY = (int)frameNum/4;
				x = frameX*nWIDTH;
				y = frameY*nHEIGHT;
				
/*				if(frameNum > 15) {
					this.stop();
				}
				frameNum++; */

				if(frameNum >= 15) {
					reverse = true;
				}
				else if(frameNum <= 0) {
					reverse = false;
				}
				
				if(reverse) {
					frameNum--;
				}
				else {
					frameNum++;
				}
				gContext.clearRect(0, 0, nWIDTH, nHEIGHT);
				gContext.drawImage(hitImage, x, y, nWIDTH, nHEIGHT, 0, 0, nWIDTH, nHEIGHT);
				
			}
		}.start();
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
