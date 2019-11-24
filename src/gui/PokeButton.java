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

public class PokeButton extends Button{
	
	 private String pokemon;
	 private int cost;
	 private boolean isSelected = false;
	 
	 public PokeButton(String pokemon) {
		 this.pokemon = pokemon;
		 this.setPadding(new Insets(5));
		 this.setPadding(new Insets(10));
		 setBorder(new Border(new BorderStroke(Color.BEIGE,BorderStrokeStyle.SOLID, 
					CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		 setStyle("");
		 setPrefSize(5, 5);
		 String url;
			switch(pokemon) {
				case "Magikarp" : url = "yo.png"; cost = 4000; break;
				case "Pikachu" : url = "Pikachu.png"; cost = 800; break;
				case "Charmander" : url = "charmander.png"; cost = 100; break;
				case "Squirtle" : url = "squirtle.png"; cost = 100; break;
				case "Bulbasaur" : url = "Bulbasaur.png"; cost = 100; break;
				default: url = "yo.png"; cost = 100;
			}
		setGraphic(new ImageView(new Image(ClassLoader.getSystemResource(url).toString())));
		setAction();
	}
	 
	 private void setAction() {
		 String style, defaultstyle = "";
		 switch (pokemon) {
		 	case "Magikarp": style = "-fx-background-color : #00CCCC"; break;
		 	case "Pikachu": style = "-fx-background-color : #FFCC33"; break;
		 	case "Charmander": style = "-fx-background-color : #FF9933"; break;
		 	case "Squirtle": style = "-fx-background-color : #00CCCC"; break;
		 	case "Bulbasaur": style = "-fx-background-color : #99CC33"; break;
		 	default: style = defaultstyle;
		 }
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
		 return pokemon;
	 }
	 
	 public int getCost() {
		 return cost;
	 }
}
