package test;

import gui.PokemonButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import pokemon.Magikarp;

public class Catalog extends GridPane {
	private ObservableList<PokemonButton> PokeButtonList = FXCollections.observableArrayList();
	private PokemonButton selectedPokemon = null;
	public Catalog() {
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		final PokemonButton koiking= new PokemonButton(new Magikarp());
		PokeButtonList.add(koiking);
	}
}
