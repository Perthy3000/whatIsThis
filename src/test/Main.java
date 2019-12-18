package test;

import java.io.IOException;

import gui.HomePage;
import gui.guigamemanager;
import gui.nameInput;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		guigamemanager GameManager = new guigamemanager(primaryStage);
		//nameInput ameInput = new nameInput(primaryStage, GameManager);
		HomePage yo = new HomePage(primaryStage,GameManager);
		root.setAlignment(Pos.TOP_CENTER);
		//root2.setAlignment(Pos.CENTER);
//		root.getChildren().addAll(yo,yo2,yo3,yo4,yo5);
		//root.getChildren().add(ameInput);
		root.getChildren().add(yo);
		primaryStage.setTitle("AWDBPC");
		Scene scene2 = new Scene(root,500,800);
 		primaryStage.setScene(scene2);
 		primaryStage.setResizable(false);
 		primaryStage.show();
	}
	
}