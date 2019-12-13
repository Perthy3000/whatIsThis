package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gui.BattleGraphics;
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
	private BattleGraphics graphics;
	private List<skillButton> skillButtonList;

	public Battle(player player1, Stage primaryStage) {
		battleScene = new BattleScene(player1, primaryStage);
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
		//enemyPokemon = new Magikarp();
		randomEnemy();
		this.primaryStage = primaryStage;
		setSkillBar();
		battleScene.getLog().addData("Wild " + enemyPokemon.getName() + " appear!");
		battleScene.getLog().addData(player1.getName() + " sent out " + currentPokemon.getName() + "!");
		primaryStage.setScene(new Scene(battleScene, 500, 500));
		graphics = battleScene.getBattleGraphic();
		graphics.drawPartner(currentPokemon);
		graphics.drawEnemyPokemon(enemyPokemon);
	}
	
	private void randomEnemy() {
		Random randomizer = new Random();
		int randomEnemy = randomizer.nextInt(5);
		switch (randomEnemy) {
			case 0: enemyPokemon = new Magikarp(); break;
			case 1: enemyPokemon = new Charmander(); break;
			case 2: enemyPokemon = new Bulbasaur(); break;
			case 3: enemyPokemon = new Squirtle(); break;
			case 4: enemyPokemon = new Pikachu(); break;
			default: enemyPokemon = new Magikarp();
		}
	}
	
	public void setSkillBar() {
		battleScene.setSkillBar(new SkillBar(skillButtonList));
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
		if(currentPokemon.getStatus() == Status.FAINTED) {
			battleScene.getLog().addData(currentPokemon.getName() + " is fainted!");
			if(player1.getAvailablePokken() == 0) {
				exit();				
			} else {
				for(test1 x : player1.getpokenList()) {
					if(x.getStatus() != Status.FAINTED) {
						currentPokemon = x;
						skillButtonList.clear();
						for(int i = 0; i < 4; i++) {
							skillButton button = new skillButton(i, currentPokemon.getSkillList().get(i).getSkillname());
							setSkillButton(button);
							skillButtonList.add(button);
						}
						setSkillBar();
						battleScene.getLog().addData(player1.getName() + " sent out " + currentPokemon.getName() + "!");
						graphics.resetCanvas();
						graphics.drawPartner(currentPokemon);
						graphics.drawEnemyPokemon(enemyPokemon);
						break;
					}
				}
			}
		} else if(enemyPokemon.getStatus() == Status.FAINTED) {
			exit();
		}
	}
	
	private void exit() {
		for(skillButton x : skillButtonList) {
			x.setDisable(true);
		}
		if(player1.getAvailablePokken() == 0) {
			battleScene.getLog().addData(player1.getName() + " has no pokemon left!");
		} else {
			battleScene.getLog().addData(enemyPokemon.getName() + " is fainted!");
			player1.setMoney(player1.getMoney()+200);
			battleScene.getLog().addData(player1.getName() +" get 200$!");
		}
		for(test1 x : player1.getpokenList()) {
			x.fullHeal();
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
