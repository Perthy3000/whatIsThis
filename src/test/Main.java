package test;

import gui.guigamemanager;
import gui.nameInput;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		//new gameManager().run();
	/*	player choi= new player("Choi");
		new PokemonShop(choi);
		System.out.println("====================");
		System.out.println("My Pokeballs : ");
		choi.getPokeBall().showAllPokeball();*/
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		HBox root2 = new HBox();
		guigamemanager GameManager = new guigamemanager(primaryStage);
		nameInput ameInput = new nameInput(primaryStage, GameManager);
		root.setAlignment(Pos.TOP_CENTER);
		//root2.setAlignment(Pos.CENTER);
//		root.getChildren().addAll(yo,yo2,yo3,yo4,yo5);
		root.getChildren().add(ameInput);
		
		Scene scene2 = new Scene(root,500,500);
 		primaryStage.setScene(scene2);
 		primaryStage.show();
	}
}