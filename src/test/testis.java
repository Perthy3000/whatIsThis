package test;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import gui.Blackmarket;
import gui.InfoArea;
import gui.LevelUp;
import gui.Pokeball;
import gui.StatArea;
import pokemon.*;

public class testis extends Application {

	public static void main(String[] args) {
		for(String xString : Font.getFamilies()) {
			System.out.println(xString);
		}
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Player player = new Player("ASH", "Male");
		player.addpoken(new Charmander());
		player.addpoken(new Bulbasaur());
		player.addpoken(new Squirtle());
		player.addpoken(new Pikachu());
		new Battle(player, primaryStage);
		primaryStage.show();
	}

}