package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gui.Blackmarket;
import gui.MainMenu;
import gui.PokeButton;
import gui.skillButton;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pokemon.Charmander;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.Status;
import pokemon.test1;
 

public class PokemonShop {
//	private List<test1> pokemons;
	private player player;
	private Blackmarket blackmarket;
	private Stage primarystage;
	private HBox show;
	private VBox bigshow;
	private PokeButton magikarp = new PokeButton("Magikarp");
	private PokeButton perth = new PokeButton("Pikachu");
	private PokeButton choi = new PokeButton("Squirtle");
	Label buyingZone = new Label("Black Market");
	public PokemonShop(player player, Stage primarystage, Blackmarket blackmarket) {
//		pokemons = new ArrayList<test1>();
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
		this.show = new HBox();
		show.setAlignment(Pos.TOP_CENTER);
		show.getChildren().addAll(magikarp,perth,choi);
		setPokeButton(magikarp);
		setPokeButton(perth);
		setPokeButton(choi);
		Button exitButton = new Button();
		exitButton.setText("Exit");
		exitButton.setStyle("-fx-font-size: 15");
		exitButton.setPrefSize(70, 50);
		HBox exit =  new HBox();
		exit.setAlignment(Pos.CENTER);
		exit.getChildren().add(exitButton);
		bigshow = new VBox();
		bigshow.getChildren().addAll(buyingZone,show,exit);
		this.blackmarket.getChildren().add(bigshow);
		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				primarystage.setScene(new Scene(new MainMenu(primarystage, player), 500, 500));
			}
		});
	
	}
	
	public void run(String name) {
		if(player.getpokenList().size()<5) {
		switch(name) {
		case "Magikarp" :
			if(player.getMoney() >= 4000) {
				test1 Magikarp = new Magikarp();
				this.player.setPokeball(Magikarp);
				this.player.addpoken(Magikarp);
				blackmarket.getBuyLog().addData("Magikarp is added!");
				blackmarket.getPokeLog().addData(name);
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
				test1 Choi = new Pikachu();
				this.player.setPokeball(Choi);
				this.player.addpoken(Choi);
				blackmarket.getBuyLog().addData("Choi is added!");
				blackmarket.getPokeLog().addData(name);
			System.out.println("Choi is added!");
				player.setMoney(player.getMoney()-800);
			}
		
			else {
				blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
			}
			break;
		case "Squirtle" :
			if(player.getMoney() >= 100) {
			test1 Perth = new Squirtle();
			this.player.setPokeball(Perth);
			this.player.addpoken(Perth);
			blackmarket.getBuyLog().addData("Perth is added!");
			blackmarket.getPokeLog().addData(name);
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
	private void setPokeButton(PokeButton button) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				run(button.getPokkenName());
			}
		});
	}
}
