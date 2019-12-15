package gui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class nameInput extends GridPane {
	
	private TextField nameinput;
	private Label label;
	private Button enterButton;

	public nameInput() {
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		nameinput = new TextField();
		label = new Label("Name :");
		label.setStyle("-fx-font-size: 25");
		enterButton = new Button("Enter");
		enterButton.setPrefSize(70, 40);
	//	setButtonAction(primaryStage, manager);
		addRow(1,label, nameinput);
	//setAlignment(Pos.CENTER_LEFT);
	}
/*	
	public void setButtonAction(Stage primaryStage, guigamemanager manager) {
		enterButton.setOnAction(new ActionEventHandler(primaryStage, manager));
	}
*/	
	private class ActionEventHandler implements EventHandler<ActionEvent> {
		
		guigamemanager manager;
		Stage primaryStage;
		
		public ActionEventHandler(Stage primaryStage, guigamemanager manager) {
			this.primaryStage = primaryStage;
			this.manager = manager;
			this.primaryStage.setTitle("Create your character");
		}

		@Override
		public void handle(ActionEvent arg0) {
			ChoosePokemon nextScene = new ChoosePokemon();
			nextScene.setAlignment(Pos.CENTER);
			String name = nameinput.getText();
			manager.createPlayer(name);
			//Label label = new Label(name+"is created!");
			//label.setAlignment(Pos.TOP_CENTER);
			//nextScene.getChildren().add(label);
			primaryStage.setScene(new Scene(nextScene, 500, 800));
		}
		
	}
	public String getText() {
		return nameinput.getText().trim();
	}
}
