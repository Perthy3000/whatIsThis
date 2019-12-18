package test;

import gui.HomePage;
import gui.guigamemanager;
import javafx.application.Application;
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
		HomePage yo = new HomePage(primaryStage,GameManager);
		root.setAlignment(Pos.TOP_CENTER);
		root.getChildren().add(yo);
		primaryStage.setTitle("AWDBPC");
		Scene scene2 = new Scene(root,500,800);
 		primaryStage.setScene(scene2);
 		primaryStage.setResizable(false);
 		primaryStage.show();
	}
	
}