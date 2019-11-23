package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pokemon.*;
import test.player;

public class ChoosePokemon extends GridPane {
	
	private List<PokeButton> pokeButtons;	//contains all PokeButton
	private Stage primaryStage;	//current stage
	private PokeButton selectedButton = null;	//current button that is selected
	private test1 selectedPokken;	//current pokemon that is selected
	private Button nextButton;	//button NEXT
	private guigamemanager manager;	//gameManager
	
	public ChoosePokemon(Stage primaryStage, guigamemanager manager) {
		this.primaryStage = primaryStage;
		pokeButtons = new ArrayList<PokeButton>();
		this.manager = manager;
		nextButton = new Button("next");
		nextButton.setPrefSize(70, 70);
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
	//	PokeButton yo = new PokeButton("Magikarp");
	//	PokeButton yo2 = new PokeButton("Pikachu");
		PokeButton yo3 = new PokeButton("Charmander");
		PokeButton yo4 = new PokeButton("Squirtle");
		PokeButton yo5 = new PokeButton("Bulbasaur");
		//pokeButtons.add(yo);
	//	pokeButtons.add(yo2);
		pokeButtons.add(yo3);
		pokeButtons.add(yo4);
		pokeButtons.add(yo5);
	//	addRow(0, yo2);
		addRow(1, yo3, yo4);
		addRow(2, yo5, nextButton);
		for(PokeButton all : pokeButtons) {
			setPokeButtonAction(all);
		}
	}
	
	//set action on NEXT button
	private void setButtonAction() {
		player player1 = manager.getPlayer();	//call player from gameManager
		MainMenu nextBox = new MainMenu(primaryStage, player1);
		//BattleScene nextBox = new BattleScene(selectedPokken, manager);
		//nextBox.add(new Label(player1.getName() + " choose " + selectedButton.getPokkenName()), 0, 0, 2, 1);
		//BattleScene nextBox = new BattleScene(selectedPokken, manager);
		//BattleTest nextBox = new BattleTest(selectedPokken, new Bulbasaur());
		nextBox.setAlignment(Pos.CENTER);
		//nextBox.add(new Label(player1.getName() + " choose " + selectedButton.getPokkenName()), 0, 0, 2, 1);
		//nextBox.add(new Label(player1.getName() + " choose " + selectedButton.getPokkenName()));
		//nextBox.getChildren().add(new Label(player1.getName() + " choose " + selectedButton.getPokkenName()));
		Scene nextScene = new Scene(nextBox, 500, 500);	//create next scene
		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(player1.getName() + " choose " + selectedButton.getPokkenName());
				player1.addpoken(selectedPokken);	//player add selected pokemon into team
				primaryStage.setScene(nextScene);
			}
		});
	}
	
	//change selected pokemon depends on currently selected button
	private void chooseStarter() {
		String pokkenname = selectedButton.getPokkenName();
		switch (pokkenname) {
		 	case "Magikarp": selectedPokken = new Magikarp(); break;
		 	case "Pikachu": selectedPokken = new Pikachu(); break;
		 	case "Charmander": selectedPokken = new Charmander(); break;
		 	case "Squirtle": selectedPokken = new Squirtle(); break;
		 	case "Bulbasaur": selectedPokken = new Bulbasaur(); break;
		}
	}

	//set action on pokeButton to select current pokemon
	private void setPokeButtonAction(PokeButton pokebutton) {
		pokebutton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSelected(pokebutton);	//call setSelected function
			}
		});
	}
	
	//set the current selected pokeButton
	private void setSelected(PokeButton pokebutton) {
		selectedButton = pokebutton;
		selectedButton.setSelected();
		for(PokeButton button : pokeButtons) {
			if(button != selectedButton) {
				button.setUnselected();
			}
		}
		chooseStarter();	//call to select pokemon
		setButtonAction();	//call setButtonAction
	}
}
