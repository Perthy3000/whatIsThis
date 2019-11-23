package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test.player;

public class MainMenu extends VBox {
	
	private Button shopButton;
	private Button randomBattleButton;
	private player player1;
	
	public MainMenu(Stage primaryStage, player player1) {
		setAlignment(Pos.CENTER);
		setSpacing(20);
		shopButton = new Button("Black Market");
		randomBattleButton = new Button("Random Battle");
		shopButton.setPrefSize(100, 50);
		randomBattleButton.setPrefSize(100, 50);
		this.player1 = player1;
		setButtonAction(randomBattleButton, primaryStage);
		setButtonAction(shopButton, primaryStage);
		getChildren().addAll(shopButton, randomBattleButton);
	}
	
	private void setButtonAction(Button button, Stage primaryStage) {
		switch (button.getText()) {
		case "Random Battle":
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					BattleScene rootNode = new BattleScene(player1, primaryStage);
					Scene nextScene = new Scene(rootNode, 500, 500);
					primaryStage.setScene(nextScene);	
				}			
			});
			break;
		case "Black Market":
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					Blackmarket rootNode = new Blackmarket(player1, primaryStage);
					Scene nextScene = new Scene(rootNode, 1200, 500);
					primaryStage.setScene(nextScene);
				}			
			});
			break;
		default:
			break;
		}
	}
	
}
