package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pokemon.test1;
import test.skill;

public class BattleTest extends VBox {

	private guigamemanager manager;
	private BattleLog log;
	private List<skillButton> skillButtonList;
	private test1 poke1,poke2;
	public BattleTest(test1 poke1, test1 poke2) {
		this.poke1 = poke1;
		this.poke2 = poke2;
		log = new BattleLog();
		setPadding(new Insets(5));
		/*setVgap(10);
		setHgap(10);*/
	setSpacing(10);
	// ตากูปอดละ อย่าลืมไป 
		HBox right = new HBox();
		HBox left = new HBox();
		skillButtonList = new ArrayList<skillButton>();
		for(int i = 0; i < 4; i++) {
			skillButtonList.add(new skillButton(i, poke1.getskill(i).getSkillname()));
		}
		for(int i = 0;  i < 4; i++) {
			right.getChildren().add(skillButtonList.get(i));
		}
		for(int i = 0; i < 4; i++) {
			skillButtonList.add(new skillButton(i, poke2.getskill(i).getSkillname()));
		}
		for(int i = 0;  i < 4; i++) {
			left.getChildren().add(skillButtonList.get(i));
		}
		this.getChildren().addAll(left,right);
		
	}
	public doBattle() {
		
	}
}