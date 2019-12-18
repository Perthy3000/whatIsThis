package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pokemon.test1;
import test.Pokeball;
import test.PokemonShop;
import test.Player;

public class Blackmarket extends VBox {
	
	private PokemonShop shop;
	private Buyinglog shoplog;
	private guiPokeball pokelog;
	
	public Blackmarket(Player player1, Stage primaryStage) {
		Image image = new Image ("marketbg.png");
	    setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
	                                                                  BackgroundRepeat.REPEAT,
	                                                                  BackgroundPosition.DEFAULT,
	                                                                  BackgroundSize.DEFAULT)));
		pokelog = new guiPokeball(this,player1);
		shoplog = new Buyinglog();
		setPadding(new Insets(10));
		setAlignment(Pos.TOP_CENTER);
		setSpacing(20);
		shop = new PokemonShop(player1, primaryStage, this);
		int loop=0;
		for(test1 i : player1.getpokenList()) {
			this.pokelog.addData(i);
			System.out.println(i.getName());
		}
		this.getChildren().add(shoplog);
		VBox pokeball = new VBox();
		pokeball.setSpacing(10);
		Label PokeballZone = new Label("Poke Balls");
		PokeballZone.setFont(new Font(18));
		PokeballZone.setStyle("-fx-text-fill: white");
		pokeball.getChildren().addAll(PokeballZone,pokelog);
		
		this.getChildren().add(pokeball);
		Button exitButton = new Button();
		exitButton.setText("Exit");
		exitButton.setStyle("-fx-font-size: 15");
		exitButton.setPrefSize(70, 50);
		HBox exit =  new HBox();
		exit.setAlignment(Pos.BOTTOM_CENTER);
		exit.getChildren().add(exitButton);
		exit.setPrefHeight(230);
		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				primaryStage.setScene(new Scene(new MainMenuScene(primaryStage, player1), 500, 800));
				primaryStage.setTitle("Main Menu");
			}
		});
		this.getChildren().add(exit);
	}
	
	public Buyinglog getBuyLog() {
		return this.shoplog;
	}
	public guiPokeball getPokeLog() {
		return this.pokelog;
	}
	public PokemonShop getShop() {
		return this.shop;
	}
}



