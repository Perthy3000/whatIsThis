package test;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
public class PokeButton extends Button{
	 private String pokemon;
	 public PokeButton(String pokemon) {
		 this.pokemon = pokemon;
		 this.setPadding(new Insets(40));
		 setBorder(new Border(new BorderStroke(Color.BEIGE,BorderStrokeStyle.SOLID, 
					CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		 String url="Magikarp.png";
			switch(pokemon) {
				case "Magikarp" : url = "yo.png"; break;
				case "Pikachu" : url = "Pikachu.png"; break;
				case "Charmander" : url = "charmander.png"; break;
				case "Squirtle" : url = "squirtle.png"; break;
			}
			setGraphic(new ImageView(new Image(url)));
		}
}
