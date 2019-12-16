package gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateChar extends VBox {
	private nameInput nameInput;
	private ChoosePokemon ChoosePokemon;
	private ImageView you;
	public CreateChar(Stage primaryStage, guigamemanager manager, CreateCharScene ccs) {
			nameInput = new nameInput();
//			String name = nameInput.getText();
			String name = "ASH";
			manager.createPlayer(name);
			ChoosePokemon = new ChoosePokemon(ccs);
			you = new ImageView(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false));
		//	setAlignment(Pos.CENTER);
			setAlignment(Pos.TOP_CENTER);
			getChildren().addAll(you,nameInput,ChoosePokemon);
		}
	
	public ChoosePokemon getChoosePokemon() {
		return this.ChoosePokemon;
}
	
}
