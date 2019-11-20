package test;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
		// TODO Auto-generated method stub
		PokeButton yo = new PokeButton("Magikarp");
		PokeButton yo2 = new PokeButton("Pikachu");
		HBox root = new HBox();
		root.getChildren().addAll(yo,yo2);
		Scene scene2 = new Scene(root,2000,2000);
 		primaryStage.setScene(scene2);
 		primaryStage.show();
	}
}