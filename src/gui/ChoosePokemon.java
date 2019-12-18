package gui;

import java.util.ArrayList;
import java.util.List;

import exception.CreateCharException;
import exception.NoPokemonException;
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
import test.Player;

public class ChoosePokemon extends GridPane {
	
	private List<PokemonButton> pokeButtons;	//contains all PokeButton
	private Stage primaryStage;	//current stage
	private PokemonButton selectedButton = null;	//current button that is selected
	private test1 selectedPokken;	//current pokemon that is selected
	private Button nextButton;	//button NEXT
	private guigamemanager manager;	//gameManager
	private Label label;
	public ChoosePokemon(CreateCharScene ccs, guigamemanager manager, Stage primaryStage) {
		this.primaryStage = primaryStage;
		pokeButtons = new ArrayList<PokemonButton>();
		this.manager = manager;
		nextButton = new Button("next");
		nextButton.setPrefSize(70, 70);
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		label = new Label("Pokemon: ");
		label.setStyle("-fx-font-size: 20");
		PokemonButton yo3 = new PokemonButton(new Charmander());
		PokemonButton yo4 = new PokemonButton(new Squirtle());
		PokemonButton yo5 = new PokemonButton(new Bulbasaur());
		pokeButtons.add(yo3);
		pokeButtons.add(yo4);
		pokeButtons.add(yo5);
		addRow(1,label);
		addRow(1, yo3, yo4,yo5);
		//addRow(2,nextButton);
		//addRow(1,label);
		for(PokemonButton all : pokeButtons) {
			setPokeButtonAction(all, ccs);
		}
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
	private void setPokeButtonAction(PokemonButton pokebutton, CreateCharScene ccs) {
		pokebutton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSelected(pokebutton, ccs);	//call setSelected function
			}
		});
	}
	
	//set the current selected pokeButton
	private void setSelected(PokemonButton pokebutton, CreateCharScene ccs) {
		selectedButton = pokebutton;
		selectedButton.setSelected();
		for(PokemonButton button : pokeButtons) {
			if(button != selectedButton) {
				button.setUnselected();
			}
		}
		chooseStarter();	//call to select pokemon
		ccs.updatePoke(selectedPokken);
		//add(selectedPokken.getPieChart(),0,8);
		//setButtonAction();	//call setButtonAction
		
	}
	
	public test1 getselectedPokken() throws CreateCharException {
		if(selectedPokken == null) throw new CreateCharException("Choose your pokemon!");
		return selectedPokken;
	}
	
	public Button getNextButton() {
		return nextButton;
	}
	
}
