package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import pokemon.test1;

public class BattleGraphics extends StackPane {
	
	private Canvas canvas;
	private GraphicsContext gc;
	private Image backgroundImage;
	private Image partnerImage;
	private Image enemyImage;
	
	public BattleGraphics() {
		try {
			canvas = new Canvas(400,200);
			gc = canvas.getGraphicsContext2D();
			backgroundImage = new Image(ClassLoader.getSystemResource("background-scene.png").toString(), 400, 200, false, false);
			getChildren().add(canvas);
			gc.drawImage(backgroundImage, 0, 0);
		} catch (Exception e) {
			System.out.println("cannot find image");
		}
	}
	
	public void drawPartner(test1 currentPokemon) {
		partnerImage = new Image(ClassLoader.getSystemResource(getUrl(currentPokemon)).toString(), 100, 0, true, true);
		gc.drawImage(partnerImage, 70, 130);
	}
	
	public void drawEnemyPokemon(test1 enemyPokemon) {
		enemyImage = new Image(ClassLoader.getSystemResource(getUrl(enemyPokemon)).toString(), 80, 0, true, true);
		gc.drawImage(enemyImage, 245, 45);
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
}
