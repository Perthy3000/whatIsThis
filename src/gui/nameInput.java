package gui;

import java.util.ArrayList;
import java.util.List;

import exception.NameException;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class nameInput extends GridPane {
	private List<GenderButton> Buttons;
	private TextField nameinput;
	private Label label;
	private Label label2;
	private Button enterButton;
	private GenderButton maleButton;
	private GenderButton femaleButton;
	private GenderButton selectedButton = null;
	private String selectedGender;
	
	public nameInput(CreateCharScene ccs) {
		Buttons = new ArrayList<GenderButton>();
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		nameinput = new TextField();
		label = new Label("Name :");
		label.setStyle("-fx-font-size: 20");
		label2 = new Label("Gender :");
		label2.setStyle("-fx-font-size: 20");
		enterButton = new Button("Enter");
		enterButton.setPrefSize(70, 40);
		maleButton = new GenderButton("Male");
		femaleButton = new GenderButton("Female");
		Buttons.add(maleButton);
		Buttons.add(femaleButton);
		selectedGender = "Female";
		addRow(2,label, nameinput);
		addRow(2,label2, maleButton,femaleButton);
		for(GenderButton all : Buttons) {
			setButtonAction(all, ccs);
		}
	}

	private void chooseGender(CreateCharScene ccs) {
		String Genderr = selectedButton.getGender();
		switch (Genderr) {
		 	case "Female": selectedGender= "Female"; break;
		 	case "Male": selectedGender = "Male"; break;
		}
		ccs.updateChar(Genderr);
	}
	private void setButtonAction(GenderButton button, CreateCharScene ccs) {
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSelected(button, ccs);	
			}
		});
	}
	
	private void setSelected(GenderButton button, CreateCharScene ccs) {
		selectedButton = button;
		selectedButton.setSelected();
		for(GenderButton buttonn : Buttons) {
			if(buttonn != selectedButton) {
				buttonn.setUnselected();
			}
		}
		chooseGender(ccs);
	}
	
	public String getSelectedGender() {
		return this.selectedGender;
	}
	
	public String getText() throws NameException {
		if(nameinput.getText().trim().isBlank()) throw new NameException("Invalid name!");
		return nameinput.getText().trim();
	}
	 
}
