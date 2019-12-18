package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.test1;
import test.Player;

public class Pokeball extends TilePane {

	private List<PokeButton> pokeButtonList;
	private Image backgroundImage;
	private Canvas canvas;
	private Button backButton;
	private GraphicsContext gc;
	private Player player;
	private Stage primaryStage;
	public Pokeball(Player player, Stage primaryStage) {
		this.player=player;
		this.primaryStage=primaryStage;
		Image image = new Image ("pokeballbg.png");
	    setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
	                                                                  BackgroundRepeat.REPEAT,
	                                                                  BackgroundPosition.DEFAULT,
	                                                                  BackgroundSize.DEFAULT)));
		setPadding(new Insets(20));
		setVgap(10);
		setHgap(20);
		setPrefColumns(3);
		setPrefRows(3);
		setMaxSize(400, 300);
		pokeButtonList = new ArrayList<PokeButton>();
		int index = 0;
		for(test1 pokemon : player.getpokenList()) {
			PokeButton pokeButton = new PokeButton(pokemon);
			setPokeButton(pokeButton, primaryStage, player, index);
			Label nameLabel = new Label();
			Text name = new Text();
			name.setText(pokeButton.getPokkenName());
			name.setFont(Font.font(null, FontWeight.BOLD, FontPosture.REGULAR, 20));
			name.setFill(Color.BLACK); 
		    name.setStrokeWidth(1); 
		    name.setStroke(Color.BLACK); 
		    nameLabel.setText(name.getText());
			nameLabel.setStyle("-fx-padding: 5 5 3 3;");
			VBox vbox = new VBox(pokeButton,name);
			vbox.setSpacing(5);
			vbox.setAlignment(Pos.CENTER);
			pokeButtonList.add(pokeButton);
			if(pokeButtonList.size()<=5) {
				setAlignment(Pos.CENTER);
			}else {
			setAlignment(Pos.BOTTOM_CENTER);}
			getChildren().add(vbox);
			index++;
		}
		backButton = new Button();
		backButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		backButton.setStyle("-fx-background-color: transparent;");
		backButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("backButtonbf.png").toString(), 160, 100, false, false)));
		setAction(backButton);
		setAlignment(backButton, Pos.BOTTOM_CENTER);
		getChildren().add(backButton);
		
	}
	
	//setup pokebutton action to next scene
	private void setPokeButton(PokeButton pokeButton, Stage primaryStage, Player player, int index) {
		pokeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				LevelUp nextScene = new LevelUp(primaryStage, player.getpokenList().get(index), player);
				Scene next = new Scene(nextScene, 900, 500);
				primaryStage.setScene(next);
				primaryStage.setTitle("Manage Pokemon");
				primaryStage.show();
			}
		});
		
		String url;
		//String poke = pokeButton.getPokkenName();
		 if(pokeButton.getPokemon() instanceof Squirtle) {
			 url = "pokeSquirtle.png";
		 }
		 else if(pokeButton.getPokemon()instanceof Bulbasaur) {
			 url = "pokeBulbasaur.png"; 
		 }
		 else if(pokeButton.getPokemon()instanceof Charmander) {
			 url = "pokeCharmander.png"; 
		 }
		 else if(pokeButton.getPokemon()instanceof Pikachu) {
			 url = "pokePikachu.png";
		 }
		 else if(pokeButton.getPokemon()instanceof Magikarp) {
			 url="pokeMagikarp.png";
		 }
		 else {
			 url = "yo.png";
		 }
		 pokeButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource(url).toString())));
	}
	public void setAction(Button button) {
		 button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
					button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("backButton.png").toString(), 160, 100, false, false)));
			}
		 });
		 button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
						button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("backButtonbf.png").toString(), 160, 100, false, false)));
			}
		});
		 button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					MainMenuScene nextBox = new MainMenuScene(primaryStage, player);
					nextBox.setAlignment(Pos.CENTER);
					Scene nextScene = new Scene(nextBox, 500, 800);	
					primaryStage.setTitle("Main Menu");
					primaryStage.setScene(nextScene);
				}
			});
	 }
}
