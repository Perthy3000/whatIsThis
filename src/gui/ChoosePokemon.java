package gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ChoosePokemon extends GridPane {
	
	Button nextButton;
	
	public ChoosePokemon() {
		nextButton = new Button("next");
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
//		nextButton.setOnAction(new ActionEvent() {
//			
//		});
	}

}
