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
		setStyle("-fx-padding: 15;" + 
                "-fx-background-width: 3;" +
                "-fx-background-insets: 5;" + 
                "-fx-background-image: url(file:pokemon/border5.png);" +
                "-fx-background-size: 460 72;" +
                "-fx-background-position: top center;" +
                "-fx-background-repeat: no-repeat;");
	}

	public List<skillButton> getSkillButtons() {
		return skillButtonList;
	}
}
