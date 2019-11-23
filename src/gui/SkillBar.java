package gui;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class SkillBar extends HBox {
	
	public SkillBar(List<skillButton> skillButtonList) {
		setSpacing(10);
		setAlignment(Pos.BOTTOM_CENTER);
		for(skillButton Skill : skillButtonList) {
			getChildren().add(Skill);
		}
	}

}
