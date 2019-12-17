package gui;

import exception.NameException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test.Player;

public class CreateChar extends VBox {
	private nameInput nameInput;
	private ChoosePokemon ChoosePokemon;
	private ImageView you;
	private CreateCharScene ccs;
	public CreateChar(Stage primaryStage, guigamemanager manager, CreateCharScene ccs) {
		this.ccs = ccs;
			nameInput = new nameInput(this.ccs);
//			String name = nameInput.getText();
			ChoosePokemon = new ChoosePokemon(this.ccs, manager, primaryStage);
			you = new ImageView(new Image(ClassLoader.getSystemResource("blank.png").toString(), 100, 100, false, false));
		//	setAlignment(Pos.CENTER);
			setAlignment(Pos.TOP_CENTER);
			getChildren().addAll(you,nameInput,ChoosePokemon);
			setNextButton(manager, primaryStage);
		}

	public ChoosePokemon getChoosePokemon() {
		return this.ChoosePokemon;
	}
	public nameInput getNameInput() {
		return this.nameInput;
	}
	
	public void setImage(Image image) {
		you.setImage(image);
	}
	
	private void setNextButton(guigamemanager manager, Stage primaryStage) {
		ccs.getNextButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String name;
				try {
					name = nameInput.getText();
				} catch (NameException e) {
					e.showAlertBox();
					return;
				}
				manager.createPlayer(name, getNameInput().getSelectedGender());
				Player player1 = manager.getPlayer();	//call player from gameManager
				player1.addpoken(ChoosePokemon.getPokemon());
//				player1.setGender(getNameInput().getSelectedGender());
			//	MainMenu nextBox = new MainMenu(primaryStage, player1);
				MainMenuScene nextBox = new MainMenuScene(primaryStage, player1);
				nextBox.setAlignment(Pos.CENTER);
				Scene nextScene = new Scene(nextBox, 500, 800);	//create next scene
				System.out.println(player1.getName() + " choose " + ChoosePokemon.getPokemon().getName());
				primaryStage.setTitle("Main Menu");
				primaryStage.setScene(nextScene);
			}
		});
	}
}
