package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import pokemon.test1;

public class BattleGraphics extends StackPane {
	
	private Canvas canvas;
	private Canvas canvas2;
	private Canvas canvas3;
	private GraphicsContext gc;
	private GraphicsContext gc2;
	private GraphicsContext gc3;
	private Image backgroundImage;
	private Image partnerImage;
	private Image enemyImage;
	
	public BattleGraphics() {
		try {
			canvas = new Canvas(400,200);
			canvas2 = new Canvas(400, 200);
			canvas3 = new Canvas(400, 200);
			gc = canvas.getGraphicsContext2D();
			gc2 = canvas2.getGraphicsContext2D();
			gc3 = canvas3.getGraphicsContext2D();
			backgroundImage = new Image(ClassLoader.getSystemResource("background-scene.png").toString(), 400, 200, false, false);
			getChildren().addAll(canvas, canvas2, canvas3);
			gc.drawImage(backgroundImage, 0, 0);
		} catch (Exception e) {
			System.out.println("cannot find image");
		}
	}
	
	public void drawPartner(test1 currentPokemon) {
		clearPartner();
		partnerImage = new Image(ClassLoader.getSystemResource(getUrl(currentPokemon)).toString(), 100, 0, true, true);
		gc2.drawImage(partnerImage, 70, 130);
	}
	
	public void clearPartner() {
		gc2.clearRect(70, 130, 100, 200);
	}
	
	public void clearEnemyPokemon() {
		gc2.clearRect(245, 45, 80, 80);
	}
	
	public void drawEnemyPokemon(test1 enemyPokemon) {
		enemyImage = new Image(ClassLoader.getSystemResource(getUrl(enemyPokemon)).toString(), 80, 0, true, true);
		gc2.drawImage(enemyImage, 245, 45);
	}
	
	private String getUrl(test1 pokemon) {
		String url;
		switch(pokemon.getName()) {
			case "Magikarp" : url = "yo.png"; break;
			case "Pikachu" : url = "Pikachu.png"; break;
			case "Charmander" : url = "charmander.png"; break;
			case "Squirtle" : url = "squirtle.png"; break;
			case "Bulbasaur" : url = "Bulbasaur.png"; break;
			default: url = "yo.png";
		}
		return url;
	}
	
	public void resetCanvas() {
		canvas = new Canvas();
		backgroundImage = new Image(ClassLoader.getSystemResource("background-scene.png").toString(), 400, 200, false, false);
		getChildren().add(canvas);
		gc.drawImage(backgroundImage, 0, 0);
	}
	
	public GraphicsContext getGraphicsContext() {
		return gc3;
	}
}
