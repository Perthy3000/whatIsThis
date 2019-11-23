package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import test.player;

public class guiPokeball extends TilePane {
	private int index =1;
	private int diff;
	private int currentdiff;
	private ObservableList<PokeButton> poke = FXCollections.observableArrayList();
	private Blackmarket blackmarket;
	private player player;
	public guiPokeball (Blackmarket blackmarket,player player) {
		setAlignment(Pos.TOP_CENTER);
		//logListView = new ListView<PokeButton>(poke);
		this.blackmarket = blackmarket;
		setPrefHeight(150);
		this.player = player;
	}
	public void addData(String name) {
		PokeButton pokemon = new PokeButton(name);
		// น่าจะแตกจ้ะ
		this.index=((player.getpokenList().size())-currentdiff)-1;
		setPokeButton(pokemon, index);
		//this.index=((player.getpokenList().size())-currentdiff);
		poke.add(pokemon);
		getChildren().add(pokemon);
	}
	// แตกจ้ะ
	private void setPokeButton(PokeButton button, int index) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				System.out.println(index);
				currentdiff = (player.getpokenList().size() - player.removepokenList(index));
				removePokeButton(index);
				blackmarket.getBuyLog().addData(button.getPokkenName()+" was sold by 100$"); 
				player.setMoney(player.getMoney()+100);
				
			}
		});
	}
	private void removePokeButton(int index) {
		poke.remove(index);
		getChildren().remove(index);
	}
	
}
