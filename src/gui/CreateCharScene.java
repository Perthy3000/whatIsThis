package gui;

import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.test1;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CreateCharScene extends StackPane {
	private Image backgroundImage;
	private ImageView PokeImage;
	private Button doneButton;
	private Canvas canvas;
	private GraphicsContext gc;
	private guigamemanager manager;
	private Stage primaryStage;
	private CreateChar createChar;
	
	public CreateCharScene(Stage primaryStage,guigamemanager manager) {
		canvas = new Canvas(500,800);
		gc = canvas.getGraphicsContext2D();
		backgroundImage = new Image(ClassLoader.getSystemResource("createcharbg.png").toString(), 500, 800, false, false);
		PokeImage = new ImageView(new Image(ClassLoader.getSystemResource("tenor.gif").toString(), 280, 185.6, false, false));
		getChildren().add(canvas);
		gc.drawImage(backgroundImage, 0, 0);
//		gc.drawImage(new Image(ClassLoader.getSystemResource("tenor.gif").toString(), 400, 185.6, false, false), 245, 100);
		createChar = new CreateChar(primaryStage,manager, this);
	 	PokeImage.setImage(new Image(ClassLoader.getSystemResource("tenor.gif").toString(), 280, 185.6, false, false));
		setAlignment(createChar, Pos.CENTER);
		getChildren().addAll(createChar);
//		setAlignment(PokeImage, Pos.CENTER);
		getChildren().add(PokeImage);
	}
	
	public void updateChar(test1 pokemon) {
		switch(createChar.getChoosePokemon().getselectedPokken().getName()) {
	 	case "Charmander":PokeImage.setImage(new Image(ClassLoader.getSystemResource("tenor.gif").toString(), 280, 185.6, false, false));  break;
	 	case "Squirtle": 
	 		createChar.setImage(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false));
	 		PokeImage.setImage(new Image(ClassLoader.getSystemResource("male.png").toString(), 280, 185.6, false, false)); break;
	 	case "Bulbasaur":
	 		createChar.setImage(new Image(ClassLoader.getSystemResource("female.png").toString(), 100, 100, false, false));
	 		PokeImage.setImage(new Image(ClassLoader.getSystemResource("female.png").toString(), 280, 185.6, false, false)); break;
		default: 
		}
	}
}
