package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Gyarados;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.test1;

public class BuyButton extends Button {
	 private test1 pokemon;
	 private int cost;
	 private boolean isSelected = false;
	 public BuyButton(test1 pokemon) {
			this.pokemon = pokemon;
			this.setPadding(new Insets(5));
		//	setText(arg0);
			setText("Buy");
			setPrefSize(90, 5);
			setButtonCost();
			setAction();
		}
	 private void setButtonCost() {
		 if(pokemon instanceof Squirtle) {
			cost = 100;
		 }
		 else if(pokemon instanceof Bulbasaur) {
			 cost = 100;
		 }
		 else if(pokemon instanceof Charmander) {
			  cost = 100;
		 }
		 else if(pokemon instanceof Pikachu) {
			  cost = 800;
		 }
		 else if(pokemon instanceof Gyarados) {
			 cost = 10000;
		 }
		 else {
			 cost = 4000;
		 }
		// setGraphic(new ImageView(new Image(ClassLoader.getSystemResource(url).toString())));
	 }
	 
	 private void setAction() {
		 String style, defaultstyle = "";
		 if(pokemon instanceof Charmander) style = "-fx-background-color : #FF9933";
		 else if(pokemon instanceof Bulbasaur) style = "-fx-background-color : #99CC33";
		 else if(pokemon instanceof Squirtle) style = "-fx-background-color : #00CCCC";
		 else if(pokemon instanceof Pikachu) style = "-fx-background-color : #FFCC33";
		 else if(pokemon instanceof Magikarp) style = "-fx-background-color : #00CCCC";
		 else if(pokemon instanceof Gyarados)style = "-fx-background-color : #00CCCC";
		 else style = defaultstyle;
		 
		 setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(!isSelected) setStyle(style);					
			}
		 });
		 setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(!isSelected) setStyle(defaultstyle);
			}
		});
	 }
	 
	 public void setSelected() {
		 isSelected = true;
		 setAction();
	 }
	 
	 public void setUnselected() {
		 isSelected = false;
		 setStyle("");
	 }
	 
	 public String getPokkenName() {
		 return pokemon.getName();
	 }
	 
	 public int getCost() {
		 return cost;
	 }
	 public test1 getPokemon() {
		 return this.pokemon;
	 }
}
