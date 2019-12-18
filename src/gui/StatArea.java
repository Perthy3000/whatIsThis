package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.Pokemon;

public class StatArea extends VBox {
	
	private Pokemon pokemon;
	private Label atkLabel, defLabel, maxHpLabel, spdLabel;

	public StatArea(Pokemon pokemon) {
		this.pokemon = pokemon;
		setPadding(new Insets(10));
		setSpacing(20);
		atkLabel = new Label(Integer.toString(pokemon.getAttack()));
		defLabel = new Label(Integer.toString(pokemon.getDefense()));
		maxHpLabel = new Label(Integer.toString(pokemon.getmaxHp()));
		spdLabel = new Label(Integer.toString(pokemon.getSpeed()));
		atkLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
		defLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
		maxHpLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
		spdLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
		atkLabel.setText("            "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("            "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("            "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("            "+Integer.toString(pokemon.getSpeed()));
		getChildren().addAll(atkLabel, defLabel, maxHpLabel, spdLabel);
		if(pokemon instanceof Bulbasaur) {atkLabel.setText("                                                                 "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("                                                                 "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("                                                                 "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("                                                                 "+Integer.toString(pokemon.getSpeed()));}
		else if(pokemon instanceof Squirtle) {atkLabel.setText("                                                       "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("                                                       "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("                                                       "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("                                                       "+Integer.toString(pokemon.getSpeed()));}
		else if(pokemon instanceof Pikachu) {atkLabel.setText("                                           "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("                                           "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("                                           "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("                                           "+Integer.toString(pokemon.getSpeed()));}
	}
	//update stat whenever press feed button
	public void update() {
		atkLabel.setText("            "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("            "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("            "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("            "+Integer.toString(pokemon.getSpeed()));
		if(pokemon instanceof Bulbasaur) {atkLabel.setText("                                                                            "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("                                                                            "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("                                                                            "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("                                                                            "+Integer.toString(pokemon.getSpeed()));}
		else if(pokemon instanceof Squirtle) {atkLabel.setText("                                                                            "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("                                                                            "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("                                                                            "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("                                                                            "+Integer.toString(pokemon.getSpeed()));}
		else if(pokemon instanceof Pikachu) {atkLabel.setText("                                                                            "+Integer.toString(pokemon.getAttack()));
		defLabel.setText("                                                                            "+Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText("                                                                            "+Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText("                                                                            "+Integer.toString(pokemon.getSpeed()));}
	}
}
