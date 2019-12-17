package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pokemon.test1;

public class StatArea extends VBox {
	
	private test1 pokemon;
	private Label atkLabel, defLabel, maxHpLabel, spdLabel;

	public StatArea(test1 pokemon) {
		this.pokemon = pokemon;
		atkLabel = new Label(Integer.toString(pokemon.getAttack()));
		defLabel = new Label(Integer.toString(pokemon.getDefense()));
		maxHpLabel = new Label(Integer.toString(pokemon.getmaxHp()));
		spdLabel = new Label(Integer.toString(pokemon.getSpeed()));
		getChildren().addAll(atkLabel, defLabel, maxHpLabel, spdLabel);
	}
	//update stat whenever press feed button
	public void update() {
		atkLabel.setText(Integer.toString(pokemon.getAttack()));
		defLabel.setText(Integer.toString(pokemon.getDefense()));
		maxHpLabel.setText(Integer.toString(pokemon.getmaxHp()));
		spdLabel.setText(Integer.toString(pokemon.getSpeed()));
	}
}
