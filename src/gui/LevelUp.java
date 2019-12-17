package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pokemon.*;
import pokemon.test1;
import test.Player;

public class LevelUp extends HBox {
	
	private InfoArea infoArea;
	private StatArea statArea;
	
	public LevelUp(Stage primaryStage, test1 pokemon, Player player) {
		statArea = new StatArea(pokemon);
		infoArea = new InfoArea(pokemon, player, statArea);
		VBox vBox = new VBox();
		//pokemon image
		ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResource(findImage(pokemon)).toString(), 200, 0, true, false));
		Button exitButton = new Button("exit");
		exitButton.setPrefSize(50, 30);
		vBox.getChildren().addAll(imageView, exitButton);
		//set exit button
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				MainMenuScene nextMainMenuScene = new MainMenuScene(primaryStage, player);
				Scene nextScene = new Scene(nextMainMenuScene, 500, 800);
				primaryStage.setScene(nextScene);
			}
		});
		
		getChildren().addAll(infoArea, vBox, statArea);
		setPadding(new Insets(20));
		setSpacing(30);
	}
	
	//find pokemon image
	private String findImage(test1 pokemon) {
		String url;
		if(pokemon instanceof Charmander) url = "charmander.png";
		else if(pokemon instanceof Bulbasaur) url = "Bulbasaur.png";
		else if(pokemon instanceof Squirtle) url = "squirtle.png";
		else if(pokemon instanceof Pikachu) url = "Pikachu.png";
		else url = "yo.png";
		return url;
	}
}
