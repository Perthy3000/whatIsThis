package gui;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class SkillBar extends HBox {
	
	private List<skillButton> skillButtonList;
	
	public SkillBar(List<skillButton> skillButtonList) {
		this.skillButtonList = skillButtonList;
		setSpacing(10);
		setAlignment(Pos.BOTTOM_CENTER);
		for(skillButton Skill : skillButtonList) {
			getChildren().add(Skill);
		}
	}

	public List<skillButton> getSkillButtons() {
		return skillButtonList;
	}
}
