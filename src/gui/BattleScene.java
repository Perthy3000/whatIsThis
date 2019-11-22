package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import pokemon.test1;
import test.skill;

public class BattleScene extends GridPane {

	private guigamemanager manager;
	private BattleLog log;
	private List<skillButton> skillButtonList;
	
	public BattleScene(test1 pokemon, guigamemanager manager) {
		this.manager = manager;
		log = new BattleLog();
		setPadding(new Insets(5));
		setVgap(10);
		setHgap(10);
		skillButtonList = new ArrayList<skillButton>();
		for(int i = 0; i < 4; i++) {
			skillButtonList.add(new skillButton(i, pokemon.getskill(i).getSkillname()));
		}
		for(int i = 0;  i < 4; i++) {
			add(skillButtonList.get(i), i, 1);
		}
	}
}
