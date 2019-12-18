package gui;

import javafx.stage.Stage;
import pokemon.Magikarp;
import pokemon.Status;
import pokemon.Pokemon;
import test.Battle;
import test.Player;

public class guigamemanager {
	
	private Player player1;
	private Stage primaryStage;
	
	public guigamemanager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void createPlayer(String name, String gender) {
		player1 = new Player(name, gender);
	}
	
	public Player getPlayer() {
		return player1;
	}
	
	public void battle() {
		
	}
	
}
