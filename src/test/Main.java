package test;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import gui.BattleLog;
import gui.guigamemanager;
import gui.nameInput;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
//		// TODO Auto-generated method stub
//		PokeButton yo = new PokeButton("Magikarp");
//		yo.setOnMouseEntered(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo.setStyle(
//						"-fx-background-color: #00CCCC;");
//			}
//		}
//		);
//		yo.setOnMouseExited(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo.setStyle(
//						"-fx-background-color: ;");
//			}
//		});
//		
//		PokeButton yo2 = new PokeButton("Pikachu");
//		yo2.setOnMouseEntered(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo2.setStyle(
//						"-fx-background-color: #FFCC33;");
//			}
//		}
//		);
//		yo2.setOnMouseExited(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo2.setStyle(
//						"-fx-background-color: ;");
//			}
//		});
//		PokeButton yo3 = new PokeButton("Charmander");
//		yo3.setOnMouseEntered(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo3.setStyle(
//						"-fx-background-color: #FF9933;");
//			}
//		}
//		);
//		yo3.setOnMouseExited(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo3.setStyle(
//						"-fx-background-color: ;");
//			}
//		});
//		PokeButton yo4 = new PokeButton("Squirtle");
//		yo4.setOnMouseEntered(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo4.setStyle(
//						"-fx-background-color: #00CCCC;");
//			}
//		}
//		);
//		yo4.setOnMouseExited(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo4.setStyle(
//						"-fx-background-color: ;");
//			}
//		});
//		PokeButton yo5 = new PokeButton("Bulbasaur");
//		yo5.setOnMouseEntered(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo5.setStyle(
//						"-fx-background-color: #99CC33;");
//			}
//		}
//		);
//		yo5.setOnMouseExited(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				yo5.setStyle(
//						"-fx-background-color: ;");
//			}
//		});
		HBox root = new HBox();
		HBox root2 = new HBox();
		guigamemanager GameManager = new guigamemanager();
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