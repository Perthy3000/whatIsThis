package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class skillButton extends Button {
	
	private int skillnum;
	
	public skillButton(int skillnum, String skillname) {
		setPadding(new Insets(5));
		setPrefHeight(40);
		setPrefWidth(100);
		this.skillnum = skillnum;
		setText(skillname);
	}
	
	public int getSkillNum() {
		return skillnum;
	}
}
