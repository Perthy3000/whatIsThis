package gui;

import javafx.stage.Stage;
import pokemon.Magikarp;
import pokemon.Status;
import pokemon.test1;
import test.Battle;
import test.player;

public class guigamemanager {
	
	private player player1;
	private Stage primaryStage;
	
	public guigamemanager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void createPlayer(String name) {
		player1 = new player(name);
	}
	
	public player getPlayer() {
		return player1;
	}
	
	public void battle() {
		
	}
	
}
