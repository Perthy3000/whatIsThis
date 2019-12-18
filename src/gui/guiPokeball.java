package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pokemon;
import test.Player;

public class guiPokeball extends TilePane {
	private int index;
//	private int diff;
//	private int currentdiff;
	private ObservableList<PokemonButton> poke = FXCollections.observableArrayList();
	private Blackmarket blackmarket;
	private Player player;
	
	public guiPokeball (Blackmarket blackmarket,Player player) {
		setPrefColumns(3);
		setHgap(10);
		setVgap(10);
		setPrefWidth(250);
		//logListView = new ListView<PokeButton>(poke);
		this.blackmarket = blackmarket;
		setPrefHeight(150);
		this.player = player;
	}
	
	public void addData(Pokemon pokemon) {
		PokemonButton pokemonButton = new PokemonButton(pokemon);
		index = poke.size();
		setPokeButton(pokemonButton, index);
		System.out.println(index);
		//this.index=((player.getpokenList().size())-currentdiff);
		poke.add(pokemonButton);
		getChildren().add(pokemonButton);
	}
	
	private void setPokeButton(PokemonButton button, int index) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				System.out.println(index);
//				currentdiff = (player.getpokenList().size() - player.removepokenList(index));
				removePokeButton(index);
				blackmarket.getBuyLog().addData(button.getPokkenName()+" was sold for " + button.getCost() + "$"); 
				player.setMoney(player.getMoney()+button.getCost());
				player.getpokenList().remove(index);
			}
		});
	}
	
	private void removePokeButton(int index) {
		poke.remove(index);
		for(int i = 0; i < poke.size(); i++) {
			setPokeButton(poke.get(i), i);
		}
		getChildren().remove(index);
	}
	
}
