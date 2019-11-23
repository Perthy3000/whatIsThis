package gui;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test.player;

public class BattleScene extends VBox {

	//private Battle battle;
	private BattleLog log;
	private SkillBar skillBar;
	
	public BattleScene(player player1, Stage primaryStage) {
		setPadding(new Insets(5));
		log = new BattleLog();
		skillBar = new SkillBar(new ArrayList<skillButton>());
		setSpacing(10);
		getChildren().add(skillBar);
		getChildren().add(log);
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
}
