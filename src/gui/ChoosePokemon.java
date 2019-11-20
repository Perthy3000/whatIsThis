package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoosePokemon extends GridPane {
	
	Button nextButton;
	
	public ChoosePokemon(Stage primaryStage) {
		nextButton = new Button("next");
		nextButton.setPrefSize(100, 100);
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		PokeButton yo = new PokeButton("Magikarp");
		PokeButton yo2 = new PokeButton("Pikachu");
		PokeButton yo3 = new PokeButton("Charmander");
		PokeButton yo4 = new PokeButton("Squirtle");
		PokeButton yo5 = new PokeButton("Bulbasaur");
		addRow(0, yo, yo2);
		addRow(1, yo3, yo4);
		addRow(2, yo5, nextButton);
		setButtonAction(primaryStage);
	}
	
	private void setButtonAction(Stage primaryStage) {
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(new Label("this is as far as you can go"));
		Scene nextScene = new Scene(box, 500, 500);
		nextButton.setOnAction(EventHandler -> primaryStage.setScene(nextScene));
	}

}
