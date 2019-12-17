package gui;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test.Player;

public class BattleScene extends VBox {

	//private Battle battle;
	private BattleGraphics background;
	private BattleLog log;
	private SkillBar skillBar;
	
	public BattleScene(Player player1, Stage primaryStage) {
		setSpacing(20);
		setPadding(new Insets(10));
		log = new BattleLog();
		skillBar = new SkillBar(new ArrayList<skillButton>());
		background = new BattleGraphics();
		primaryStage.setTitle("Battle");
/*		BackgroundImage backgroundImage = new BackgroundImage(new Image(ClassLoader.getSystemResource("battle_background.jpg").toString(),
				500, 600, false, false), 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		setBackground(new Background(backgroundImage)); */
		setStyle("-fx-background-color: gray");
		getChildren().add(background);
		getChildren().add(skillBar);
		getChildren().add(log);
	}
	
	public BattleGraphics getBattleGraphic() {
		return background;
	}
	
	public SkillBar getSkillBar() {
		return skillBar;
	}
	
	public BattleLog getLog() {
		return log;
	}
	
	public void setLog(BattleLog log) {
		this.log = log;
	}
	
	public void setSkillBar(SkillBar skillBar) {
		int pos = getChildren().indexOf(this.skillBar);
		getChildren().remove(this.skillBar);
		this.skillBar = skillBar;
		getChildren().add(pos, skillBar);
	}
	
	public void disableSkillBar() {
		for(skillButton button : skillBar.getSkillButtons()) {
			button.setDisable(true);
		}
	}
	
	public void enableSkillBar() {
		for(skillButton button : skillBar.getSkillButtons()) {
			button.setDisable(false);
		}
	}
}
