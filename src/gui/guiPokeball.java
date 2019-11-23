package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class guiPokeball extends VBox {
	private ObservableList<PokeButton> poke = FXCollections.observableArrayList();
//	private ListView<PokeButton> logListView;

	public guiPokeball () {
		setAlignment(Pos.CENTER);
		//logListView = new ListView<PokeButton>(poke);
		setPrefHeight(150);
		//logListView.setPrefWidth(300);
		//logListView.setFocusTraversable(false);
	//	getChildren().add(logListView);
	}
	public void addData(String name) {
		PokeButton pokemon = new PokeButton(name);
		poke.add(pokemon);
		getChildren().add(pokemon);
	}
}
