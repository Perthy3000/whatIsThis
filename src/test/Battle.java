package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gui.BattleGraphics;
import gui.BattleScene;
import gui.HitAnimation;
import gui.MainMenu;
import gui.MainMenuScene;
import gui.SkillBar;
import gui.skillButton;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pokemon.*;

public class Battle {
	
	private Player player1;
	private test1 currentPokemon;
	private test1 enemyPokemon;
	private Stage primaryStage;
	private BattleScene battleScene;
	private BattleGraphics graphics;
	private List<skillButton> skillButtonList;
	private Random randomizer = new Random();
	private int turn = 0;

	public Battle(Player player1, Stage primaryStage) {
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
	
	private void doAttack(test1 pokemon, test1 pokemon2, int skillNum, int skillNum2) {
		//String
		battleScene.getLog().getListView().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if(pokemon2.getStatus() != Status.FAINTED && turn == 1) {
					battleScene.getLog().addData(pokemon2.getName() + " use " + pokemon2.getskill(skillNum2).getSkillname()
							+ " for " + pokemon2.doDamage(pokemon, pokemon2.getskill(skillNum2), battleScene) + " damage");
					if(pokemon2.equals(currentPokemon)) {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 220, 20).start();
					} else {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 50, 100).start();
					}
					turn++;
				}
				else if(turn == 0) {
					battleScene.getLog().addData("-" + pokemon.getName() + " use " + pokemon.getskill(skillNum).getSkillname()
							+ " for " + pokemon.doDamage(pokemon2, pokemon.getskill(skillNum), battleScene) + " damage");
					if(pokemon.equals(currentPokemon)) {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 220, 20).start();
					} else {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 50, 100).start();
					}
					checkFaint();
					turn++;					
				}
				if(turn == 2) {
					battleScene.getLog().getListView().setOnMouseClicked(null);
					battleScene.enableSkillBar();
					turn = 0;
					checkFaint();
				}
			}
		});
	}
	
	public void checkFaint() {
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
	
	public void attack(int skillNum) {
		battleScene.disableSkillBar();
		if(currentPokemon.getSpeed() >= enemyPokemon.getSpeed()) {
			doAttack(currentPokemon, enemyPokemon, skillNum, randomizer.nextInt(3));
		} else {
			doAttack(enemyPokemon, currentPokemon, randomizer.nextInt(3), skillNum);
		}
	}
	
	private void exit() {
		battleScene.getLog().getListView().setOnMouseClicked(null);
		battleScene.disableSkillBar();
		if(player1.getAvailablePokken() == 0) {
			battleScene.getBattleGraphic().clearPartner();
			battleScene.getLog().addData(player1.getName() + " has no pokemon left!");
		} else {
			battleScene.getBattleGraphic().clearEnemyPokemon();
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
				primaryStage.setScene(new Scene(new MainMenuScene(primaryStage, player1), 500, 800));
			}
		});
	}
}
