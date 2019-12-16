package gui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class nameInput extends GridPane {
	
	private TextField nameinput;
	private Label label;
	private Button enterButton;
	
//	public nameInput(Stage primaryStage, guigamemanager manager) {
//		setPadding(new Insets(10));
//		setSpacing(30);
//		setAlignment(Pos.CENTER);

	public nameInput() {
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		nameinput = new TextField();
		label = new Label("Name :");
		label.setStyle("-fx-font-size: 25");
		enterButton = new Button("Enter");
		enterButton.setPrefSize(70, 40);
//		setButtonAction(primaryStage, manager);
//		getChildren().addAll(label, nameinput);
	//	setButtonAction(primaryStage, manager);
		addRow(1,label, nameinput);
	//setAlignment(Pos.CENTER_LEFT);
	}

	public String getText() {
		return nameinput.getText().trim();
	}
}
