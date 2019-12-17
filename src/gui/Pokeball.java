package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import pokemon.test1;
import test.Player;

public class Pokeball extends TilePane {

	private List<PokeButton> pokeButtonList;
	
	public Pokeball(Player player, Stage primaryStage) {
		setPadding(new Insets(20));
		setVgap(30);
		setHgap(50);
		setPrefColumns(3);
		setPrefRows(3);
		setMaxSize(400, 300);
		pokeButtonList = new ArrayList<PokeButton>();
		int index = 0;
		for(test1 pokemon : player.getpokenList()) {
			PokeButton pokeButton = new PokeButton(pokemon);
			setPokeButton(pokeButton, primaryStage, player, index);
			pokeButtonList.add(pokeButton);
			getChildren().add(pokeButton);
			index++;
		}
	}
	
	//setup pokebutton action to next scene
	private void setPokeButton(PokeButton pokeButton, Stage primaryStage, Player player, int index) {
		pokeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				LevelUp nextScene = new LevelUp(primaryStage, player.getpokenList().get(index), player);
				Scene next = new Scene(nextScene, 800, 500);
				primaryStage.setScene(next);
				primaryStage.show();
			}
		});
	}

}
