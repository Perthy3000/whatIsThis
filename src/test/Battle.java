package test;

import java.util.ArrayList;
import java.util.List;

import gui.BattleScene;
import gui.MainMenu;
import gui.SkillBar;
import gui.skillButton;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pokemon.*;

public class Battle {
	
	private player player1;
	private test1 currentPokemon;
	private test1 enemyPokemon;
	private Stage primaryStage;
	private BattleScene battleScene;
	private List<skillButton> skillButtonList;

	public Battle(player player1, Stage primaryStage, BattleScene battle) {
		battleScene = battle;
		this.player1 = player1;
		for(test1 x : player1.getpokenList()) {
			if(x.getStatus() != Status.FAINTED) {
				currentPokemon = x;
				break;
			}
		}
		List<skill> skillList = currentPokemon.getSkillList();
		skillButtonList = new ArrayList<skillButton>();
		for(int i = 0; i < 4; i++) {
			skillButton button = new skillButton(i, skillList.get(i).getSkillname());
			setSkillButton(button);
			skillButtonList.add(button);
		}
		this.enemyPokemon = new Magikarp();
		this.primaryStage = primaryStage;
		setSkillBar(battle);
		battle.getLog().addData("Wild " + enemyPokemon.getName() + " appear!");
	}
	
	public void setSkillBar(BattleScene battle) {
		battle.setSkillBar(new SkillBar(skillButtonList));
	}
	
	private void setSkillButton(skillButton button) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				attack(button.getSkillNum());
			}
		});
	}
	
	public void attack(int skillNum) {
		if(currentPokemon.getSpeed() >= enemyPokemon.getSpeed()) {
			battleScene.getLog().addData(currentPokemon.getName() + " use " + currentPokemon.getskill(skillNum).getSkillname()
			+ " for " + currentPokemon.doDamage(enemyPokemon, currentPokemon.getskill(skillNum)) + " damage");
			if(enemyPokemon.getStatus() != Status.FAINTED) {
				battleScene.getLog().addData(enemyPokemon.getName() + " attack " + currentPokemon.getName()
				+ " for " + enemyPokemon.doDamage(currentPokemon, enemyPokemon.getskill(skillNum)) + " damage");
			}
		} else {
			battleScene.getLog().addData(enemyPokemon.getName() + " attack " + currentPokemon.getName()
			+ " for " + enemyPokemon.doDamage(currentPokemon, enemyPokemon.getskill(skillNum)) + " damage");
			if(currentPokemon.getStatus() != Status.FAINTED) {
				battleScene.getLog().addData(currentPokemon.getName() + " use " + currentPokemon.getskill(skillNum).getSkillname()
				+ " for " + currentPokemon.doDamage(enemyPokemon, currentPokemon.getskill(skillNum)) + " damage");
			}
		}
		if(currentPokemon.getStatus() == Status.FAINTED || enemyPokemon.getStatus() == Status.FAINTED) {
			exit();
		}
	}
	
	private void exit() {
		for(skillButton x : skillButtonList) {
			x.setDisable(true);
		}
		if(currentPokemon.getStatus() == Status.FAINTED) {
			battleScene.getLog().addData(currentPokemon.getName() + " is fainted!");
			currentPokemon.setCurrentHp(currentPokemon.getmaxHp());
		} else {
			battleScene.getLog().addData(enemyPokemon.getName() + " is fainted!");
		}
		Button exitButton = new Button();
		exitButton.setText("Exit");
		exitButton.setStyle("-fx-font-size: 15");
		exitButton.setPrefSize(70, 50);
		battleScene.getChildren().add(exitButton);
		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				primaryStage.setScene(new Scene(new MainMenu(primaryStage, player1), 500, 500));
			}
		});
	}
}
