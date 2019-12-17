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
import test.Player;

public class Blackmarket extends HBox {
	
	private PokemonShop shop;
	private Buyinglog shoplog;
	private guiPokeball pokelog;
	
	public Blackmarket(Player player1, Stage primaryStage) {
		pokelog = new guiPokeball(this,player1);
		shoplog = new Buyinglog();
		setPadding(new Insets(10));
		setAlignment(Pos.CENTER);
		setSpacing(10);
		shop = new PokemonShop(player1, primaryStage, this);
		int loop=0;
		for(test1 i : player1.getpokenList()) {
			this.pokelog.addData(i);
			System.out.println(i.getName());
		}
		this.getChildren().add(shoplog);
		VBox pokeball = new VBox();
		pokeball.setSpacing(10);
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



