package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pokemon.test1;
import test.Battle;
import test.player;
import test.skill;

public class BattleScene extends VBox {

	private Battle battle;
	private BattleLog log;
	private SkillBar skillBar;
	
	public BattleScene(player player1, Stage primaryStage) {
		setPadding(new Insets(5));
		log = new BattleLog();
		battle = new Battle(player1, primaryStage, this);
//		skillButtonList = new ArrayList<skillButton>();
//		skillButtonList.add(new skillButton(1, "jeez"));
//		skillBar = new SkillBar(skillButtonList);
		setSpacing(10);
		getChildren().add(skillBar);
		getChildren().add(log);
	}
	
	public BattleLog getLog() {
		return log;
	}
	
	public void setSkillBar(SkillBar skillBar) {
		this.skillBar = skillBar;
	}
}
