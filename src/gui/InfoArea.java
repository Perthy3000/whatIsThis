package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pokemon.test1;
import test.Player;

public class InfoArea extends VBox {

	private test1 pokemon;
	private Player player;
	private TextField nameField;
	private List<FeedButton> feedingButton;
	private Label expLabel;
	private Label moneyLabel;
	
	public InfoArea(test1 pokemon, Player player, StatArea statArea) {
		this.pokemon = pokemon;
		this.player = player;
		Label nameLabel = new Label("Change pokemon name");
		getChildren().add(nameLabel);
		setNameField();
		expLabel = new Label(pokemon.getExp()+"/"+pokemon.getMaxExp());
		moneyLabel = new Label(Integer.toString(player.getMoney()));
		feedingButton = new ArrayList<FeedButton>();
		getChildren().addAll(moneyLabel, expLabel);
		setFeedingButton(statArea);	//set all feeding button
		setPadding(new Insets(10));
		setSpacing(20);
	}
	
	private void setFeedingButton(StatArea statArea) {
		HBox feedBox = new HBox();
		feedBox.setSpacing(10);
		int exp = 10;
		for(int i = 0; i < 3; i++) {
			FeedButton feedButton = new FeedButton(exp+i*5);
			feedButton.setOnAction(new EventHandler<ActionEvent>() {
				//when press will add exp and reduce money
				@Override
				public void handle(ActionEvent arg0) {
					if(player.getMoney() >= feedButton.getCost()) {
						pokemon.addExp(feedButton.getExp());
						player.setMoney(player.getMoney()-feedButton.getCost());
						expLabel.setText(pokemon.getExp()+"/"+pokemon.getMaxExp());
						moneyLabel.setText(Integer.toString(player.getMoney()));
						statArea.update();
					} else {
						//add exception
					}
				}
			});
			feedingButton.add(feedButton);
			feedBox.getChildren().add(feedButton);
		}
		getChildren().add(feedBox);
	}
	
	//setting up nameField and change button
	private void setNameField() {
		HBox nameBox = new HBox();
		nameField = new TextField();
		Button changeButton = new Button("Confirm");
		//when pressing confirm will change pokemon name
		changeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				pokemon.setName(nameField.getText());
			}
		});
		
		nameBox.getChildren().addAll(nameField, changeButton);
		getChildren().add(nameBox);
	}
}
