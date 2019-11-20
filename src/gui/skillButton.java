package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import test.test1;

public class skillButton extends Button {
	
	private int skillnum;
	private test1 pokkeTest1;
	
	public skillButton(int skillnum, test1 pokkeTest1) {
		setPadding(new Insets(5));
		this.pokkeTest1 = pokkeTest1;
		this.skillnum = skillnum;
		setText(pokkeTest1.getskill(skillnum).getSkillname());
	}
}
