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
	private Label label;
	public ChoosePokemon(CreateCharScene ccs) {
		//this.primaryStage = primaryStage;
		pokeButtons = new ArrayList<PokeButton>();
		//this.manager = manager;
		nextButton = new Button("next");
		nextButton.setPrefSize(70, 70);
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		label = new Label("Pokemon: ");
		label.setStyle("-fx-font-size: 25");
		label.setStyle("-fx-font-size: 25");
		PokeButton yo3 = new PokeButton("Charmander");
		PokeButton yo4 = new PokeButton("Squirtle");
		PokeButton yo5 = new PokeButton("Bulbasaur");
		pokeButtons.add(yo3);
		pokeButtons.add(yo4);
		pokeButtons.add(yo5);
		selectedPokken = new Charmander();
		addRow(1,label);
		addRow(1, yo3, yo4,yo5);
	//	addRow(2,nextButton);
		//addRow(1,label);
		for(PokeButton all : pokeButtons) {
			setPokeButtonAction(all, ccs);
		}
	}
	
	//set action on NEXT button
	private void setButtonAction() {
		player player1 = manager.getPlayer();	//call player from gameManager
		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				player1.addpoken(selectedPokken);	//player add selected pokemon into team
				MainMenu nextBox = new MainMenu(primaryStage, player1);
				nextBox.setAlignment(Pos.CENTER);
				Scene nextScene = new Scene(nextBox, 500, 500);	//create next scene
				System.out.println(player1.getName() + " choose " + selectedButton.getPokkenName());
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
	private void setPokeButtonAction(PokeButton pokebutton, CreateCharScene ccs) {
		pokebutton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSelected(pokebutton, ccs);	//call setSelected function
			}
		});
	}
	
	//set the current selected pokeButton
	private void setSelected(PokeButton pokebutton, CreateCharScene ccs) {
		selectedButton = pokebutton;
		selectedButton.setSelected();
		for(PokeButton button : pokeButtons) {
			if(button != selectedButton) {
				button.setUnselected();
			}
		}
		chooseStarter();	//call to select pokemon
		ccs.updateChar(selectedPokken);
		//add(selectedPokken.getPieChart(),0,8);
		//setButtonAction();	//call setButtonAction
		
	}
	public test1 getselectedPokken() {
		return this.selectedPokken;
	}
}
