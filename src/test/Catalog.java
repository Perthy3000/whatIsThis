package test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Catalog extends GridPane {
	private ObservableList<PokeButton> PokeButtonList = FXCollections.observableArrayList();
	private PokeButton selectedPokemon = null;
	public Catalog() {
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		final PokeButton koiking= new PokeButton("Magikarp");
		PokeButtonList.add(koiking);
	}
}
