package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gui.Blackmarket;
import gui.MainMenu;
import gui.MainMenuScene;
import gui.PokemonButton;
import gui.skillButton;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.Status;
import pokemon.Pokemon;
 

public class PokemonShop {
	
	private Player player;
	private Blackmarket blackmarket;
	private Stage primarystage;
	private TilePane show;
	private VBox bigshow;
	private List<PokemonButton> pokeButtons;
	Label buyingZone = new Label("Black Market");
	
	public PokemonShop(Player player, Stage primarystage, Blackmarket blackmarket) {
		pokeButtons = new ArrayList<PokemonButton>();
		pokeButtons.add(new PokemonButton(new Charmander()));
		pokeButtons.add(new PokemonButton(new Squirtle()));
		pokeButtons.add(new PokemonButton(new Bulbasaur()));
		pokeButtons.add(new PokemonButton(new Pikachu()));
		pokeButtons.add(new PokemonButton(new Magikarp()));
		this.player = player;
		this.blackmarket = blackmarket;
		this.primarystage = primarystage;
		buyingZone.setFont(new Font(18));
		prompt();
	}
	
	public void prompt() {
		System.out.println("========================");
		System.out.println("Welcome to Black Market Shop");
		System.out.println("Select Pokemon :");
		System.out.println("1: Magikarp");
		System.out.println("2: Choi, The Genius");
		System.out.println("3: Perth3000, The God");
		System.out.println("4: Exit Shop");
		System.out.println("========================");
		this.show = new TilePane();
		show.setAlignment(Pos.CENTER_LEFT);
		show.setPrefColumns(3);
		for(PokemonButton pokeButton : pokeButtons) {
			show.getChildren().add(pokeButton);
			setPokeButton(pokeButton);
		}
		show.setHgap(10); show.setVgap(10);
		Button exitButton = new Button();
		exitButton.setText("Exit");
		exitButton.setStyle("-fx-font-size: 15");
		exitButton.setPrefSize(70, 50);
		HBox exit =  new HBox();
	//	Label moneyLabel = new Label("Money : " + player.getMoney());
		exit.setAlignment(Pos.BOTTOM_LEFT);
		exit.getChildren().add(exitButton);
		exit.setPrefHeight(230);
		bigshow = new VBox();
		bigshow.setSpacing(10);
		this.blackmarket.getChildren().add(bigshow);
		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				primarystage.setScene(new Scene(new MainMenuScene(primarystage, player), 500, 800));
			}
		});
		bigshow.getChildren().addAll(buyingZone,show,exit);
	}
	
	public void run(String name) {
		if(player.getpokenList().size() < 6) {
			switch(name) {
			case "Magikarp" :
				if(player.getMoney() >= 4000) {
					Pokemon Magikarp = new Magikarp();
					this.player.setPokeball(Magikarp);
					this.player.addpoken(Magikarp);
					blackmarket.getBuyLog().addData("Magikarp is added!");
					blackmarket.getPokeLog().addData(Magikarp);
					System.out.println("Magikarp is added!");
					player.setMoney(player.getMoney()-4000);
				}
			
				else {
				System.out.println("Not Enough Money! Comeback next time!");
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!"); 
				}
				break;
			case "Pikachu" :
				if(player.getMoney() >= 800) {
					Pokemon Choi = new Pikachu();
					this.player.setPokeball(Choi);
					this.player.addpoken(Choi);
					blackmarket.getBuyLog().addData("Choi is added!");
					blackmarket.getPokeLog().addData(Choi);
				System.out.println("Choi is added!");
					player.setMoney(player.getMoney()-800);
				}
			
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			case "Squirtle" :
				if(player.getMoney() >= 100) {
				Pokemon Perth = new Squirtle();
				this.player.setPokeball(Perth);
				this.player.addpoken(Perth);
				blackmarket.getBuyLog().addData("Perth is added!");
				blackmarket.getPokeLog().addData(Perth);
			System.out.println("Perth is added!");
				player.setMoney(player.getMoney()-100);
				}
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			case "Charmander" :
				if(player.getMoney() >= 100) {
				Pokemon Perth = new Charmander();
				this.player.setPokeball(Perth);
				this.player.addpoken(Perth);
				blackmarket.getBuyLog().addData("Perth is added!");
				blackmarket.getPokeLog().addData(Perth);
			System.out.println("Perth is added!");
				player.setMoney(player.getMoney()-100);
				}
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			case "Bulbasaur" :
				if(player.getMoney() >= 100) {
				Pokemon Perth = new Bulbasaur();
				this.player.setPokeball(Perth);
				this.player.addpoken(Perth);
				blackmarket.getBuyLog().addData("Perth is added!");
				blackmarket.getPokeLog().addData(Perth);
			System.out.println("Perth is added!");
				player.setMoney(player.getMoney()-100);
				}
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			default:
				System.out.println("Wrong Input u edok!!!");
			}
		}
		else {
			System.out.println("Full!");
			blackmarket.getBuyLog().addData("Full!");
		}
		
	}
	private void setPokeButton(PokemonButton button) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				run(button.getPokkenName());
			}
		});
	}
}
