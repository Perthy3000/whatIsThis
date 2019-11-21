package gui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class nameInput extends VBox {
	
	private TextField nameinput;
	private Label label;
	private Button enterButton;
	
	public nameInput(Stage primaryStage, guigamemanager manager) {
		nameinput = new TextField();
		label = new Label("Enter your name");
		enterButton = new Button("Enter");
		setButtonAction(primaryStage, manager);
		getChildren().addAll(label, nameinput, enterButton);
	}
	
	public void setButtonAction(Stage primaryStage, guigamemanager manager) {
		enterButton.setOnAction(new ActionEventHandler(primaryStage, manager));
	}
	
	private class ActionEventHandler implements EventHandler<ActionEvent> {
		
		guigamemanager manager;
		Stage primaryStage;
		
		public ActionEventHandler(Stage primaryStage, guigamemanager manager) {
			this.primaryStage = primaryStage;
			this.manager = manager;
		}

		@Override
		public void handle(ActionEvent arg0) {
			ChoosePokemon nextScene = new ChoosePokemon(primaryStage, manager);
			nextScene.setAlignment(Pos.CENTER);
			String name = nameinput.getText();
			manager.createPlayer(name);
			//Label label = new Label(name+"is created!");
			//label.setAlignment(Pos.TOP_CENTER);
			//nextScene.getChildren().add(label);
			primaryStage.setScene(new Scene(nextScene, 500, 500));
		}
		
	}
}
