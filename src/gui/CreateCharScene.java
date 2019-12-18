package gui;

import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.test1;
import exception.CreateCharException;
import exception.NoPokemonException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CreateCharScene extends StackPane {
	private Image backgroundImage;
	private ImageView PokeImage;
	private Button doneButton;
	private Canvas canvas;
	private GraphicsContext gc;
	private guigamemanager manager;
	private Image buttonImage;
	private Stage primaryStage;
	private CreateChar createChar;
	private PieChart piechart;
	private Button nextButton;
	public CreateCharScene(Stage primaryStage,guigamemanager manager) {
		canvas = new Canvas(500,800);
		gc = canvas.getGraphicsContext2D();
		nextButton = new Button();
		nextButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		nextButton.setStyle("-fx-background-color: transparent;");
		buttonImage = new Image(ClassLoader.getSystemResource("nextButtonaf.png").toString(), 320, 100, false, false);
		nextButton.setGraphic(new ImageView(buttonImage));
		setButtonAction(nextButton);
		backgroundImage = new Image(ClassLoader.getSystemResource("createcharbg.png").toString(), 500, 800, false, false);
		PokeImage = new ImageView(new Image(ClassLoader.getSystemResource("blank.png").toString(), 280, 185.6, false, false));
		getChildren().add(canvas);
		gc.drawImage(backgroundImage, 0, 0);
		createChar = new CreateChar(primaryStage,manager, this);
	 	PokeImage.setImage(new Image(ClassLoader.getSystemResource("blank.png").toString(), 280, 185.6, false, false));
		setAlignment(createChar, Pos.CENTER);
		setAlignment(PokeImage,Pos.BOTTOM_CENTER);
		piechart = new PieChart();
		piechart.setMaxSize(320, 320);
		setAlignment(piechart,Pos.CENTER);
		setAlignment(nextButton,Pos.BOTTOM_RIGHT);
		getChildren().addAll(createChar);
		getChildren().add(PokeImage);
		getChildren().add(nextButton);
		
	}
	
	public void updatePoke(test1 pokemon) {
		test1 chosenPokemon;
		try {
			chosenPokemon = createChar.getChoosePokemon().getselectedPokken();
		} catch (CreateCharException e) {
			e.showAlertBox();
			return;
		}
		switch(chosenPokemon.getName()) {
	 	case "Charmander":PokeImage.setImage(new Image(ClassLoader.getSystemResource("tenor.gif").toString(), 280, 185.6, false, false)); 
	 	getChildren().remove(piechart);
	 	piechart = chosenPokemon.getPieChart(); 
	 	piechart.setMaxSize(320, 320);
	 	getChildren().add(piechart);break;
	 	case "Squirtle": 
	 		//createChar.setImage(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false));
	 	 	getChildren().remove(piechart);
		 	piechart = chosenPokemon.getPieChart(); 
		 	piechart.setMaxSize(320, 320);
		 	getChildren().add(piechart);
	 		PokeImage.setImage(new Image(ClassLoader.getSystemResource("squirtleg.gif").toString(), 160,152, false, false)); break;
	 	case "Bulbasaur":
	 		//createChar.setImage(new Image(ClassLoader.getSystemResource("female.png").toString(), 100, 100, false, false));
	 	 	getChildren().remove(piechart);
		 	piechart = chosenPokemon.getPieChart();
		 	piechart.setMaxSize(320, 320);
		 	getChildren().add(piechart);
	 		PokeImage.setImage(new Image(ClassLoader.getSystemResource("Bulbasaurg.gif").toString(), 160, 175, false, false)); break;
		default: 
		}
	}
	public void updateChar(String gender) {
		
		switch(gender) {
		case "Female" : createChar.setImage(new Image(ClassLoader.getSystemResource("female.png").toString(), 100, 100, false, false)); break;
		case "Male" : createChar.setImage(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false)); break;
		default:
		}
	}
	public Button getNextButton() {
		return nextButton;
	}
	
	public void setButtonAction(Button button) {
		 button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("nextButtonbf.png").toString(), 320, 100, false, false)));
			}
		 });
		 button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("nextButtonaf.png").toString(), 320, 100, false, false)));
			}
		});
	
	 }
}

