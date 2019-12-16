package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test.player;

public class CreateChar extends VBox {
	private nameInput nameInput;
	private ChoosePokemon ChoosePokemon;
	private ImageView you;
	public CreateChar(Stage primaryStage, guigamemanager manager, CreateCharScene ccs) {
			nameInput = new nameInput();
//			String name = nameInput.getText();
			ChoosePokemon = new ChoosePokemon(ccs, manager, primaryStage);
			you = new ImageView(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false));
		//	setAlignment(Pos.CENTER);
			setAlignment(Pos.TOP_CENTER);
			getChildren().addAll(you,nameInput,ChoosePokemon);
			setNextButton(manager, primaryStage);
		}
	
	public ChoosePokemon getChoosePokemon() {
		return this.ChoosePokemon;
	}
	
	public void setImage(Image image) {
		you.setImage(image);
	}
	
	private void setNextButton(guigamemanager manager, Stage primaryStage) {
		ChoosePokemon.getNextButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				manager.createPlayer(nameInput.getText());
				player player1 = manager.getPlayer();	//call player from gameManager
				player1.addpoken(ChoosePokemon.getPokemon());
				MainMenu nextBox = new MainMenu(primaryStage, player1);
				nextBox.setAlignment(Pos.CENTER);
				Scene nextScene = new Scene(nextBox, 500, 500);	//create next scene
				System.out.println(player1.getName() + " choose " + player1.getpokenList().get(0));
				primaryStage.setScene(nextScene);
			}
		});
	}
}
