package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pokemon.test1;
import test.Pokeball;
import test.PokemonShop;
import test.player;

public class Blackmarket extends HBox {
	
	private PokemonShop shop;
	private Buyinglog shoplog;
	private guiPokeball pokelog;
	
	public Blackmarket(player player1, Stage primaryStage) {
		pokelog = new guiPokeball();
		shoplog = new Buyinglog();
		setPadding(new Insets(5));
		setAlignment(Pos.CENTER);
		setSpacing(10);
		shop = new PokemonShop(player1, primaryStage, this);
		for(test1 i : player1.getpokenList()) {
			this.pokelog.addData(i.getName());
			System.out.println(i.getName());
		}
		this.getChildren().add(shoplog);
		VBox pokeball = new VBox();
		Label PokeballZone = new Label("PokeBall");
		PokeballZone.setFont(new Font(18));
		pokeball.getChildren().addAll(PokeballZone,pokelog);
		
		this.getChildren().add(pokeball);
	}
	
	public Buyinglog getBuyLog() {
		return this.shoplog;
	}
	public guiPokeball getPokeLog() {
		return this.pokelog;
	}
}



