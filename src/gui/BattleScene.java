package gui;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test.player;

public class BattleScene extends VBox {

	//private Battle battle;
	private BattleGraphics background;
	private BattleLog log;
	private SkillBar skillBar;
	
	public BattleScene(player player1, Stage primaryStage) {
		setSpacing(10);
		setPadding(new Insets(5));
		log = new BattleLog();
		skillBar = new SkillBar(new ArrayList<skillButton>());
		background = new BattleGraphics();
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
