package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import test.Pokeball;
import test.PokemonShop;
import test.player;

public class Blackmarket extends HBox {
	private PokemonShop shop;
	private Buyinglog shoplog;
	private guiPokeball pokelog;
	public Blackmarket(player player1, Stage primaryStage) {
		setPadding(new Insets(5));
		setSpacing(10);
		shop = new PokemonShop(player1, primaryStage, this);
		this.getChildren().add(pokelog);
		this.getChildren().add(shoplog);
	}
	public Buyinglog getBuyLog() {
		return this.shoplog;
	}
	
}
