package gui;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import test.Player;

public class MainMenuScene extends StackPane {
	private Image backgroundImage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Stage primaryStage;
	private guigamemanager manager;
	private Player player1;
	private MainMenu mainmenu;
	private CharStatus charstatus;
	public MainMenuScene(Stage primaryStage, Player player1) {
		this.primaryStage = primaryStage;
		this.manager = manager;
		GridPane grid = new GridPane();
		canvas = new Canvas(500,800);
		gc = canvas.getGraphicsContext2D();
		backgroundImage = new Image(ClassLoader.getSystemResource("menubg.png").toString(), 500, 800, false, false);
		gc.drawImage(backgroundImage, 0, 0);
		getChildren().add(canvas);
		mainmenu = new MainMenu(primaryStage, player1);
		charstatus = new CharStatus(player1);
		setAlignment(mainmenu, Pos.CENTER);
		//setAlignment(charstatus, Pos.TOP_LEFT);
		ImageView dd = charstatus.getImage();
		grid.setVgap(5);
		grid.setHgap(5);
		grid.addRow(0,dd,charstatus.getNameLabel());
		grid.add(charstatus.getMoneyLabel(),0,2);
		grid.add(charstatus.getCurrentPokeLabel(),1,2);
		setAlignment(grid, Pos.TOP_LEFT);
		getChildren().add(grid);
		getChildren().addAll(charstatus,mainmenu);
		
	}
	
}
