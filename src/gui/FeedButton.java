package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class FeedButton extends Button {

	private int expBoost;
	private int cost;
	
	public FeedButton(int expBoost) {
		this.expBoost = expBoost;
		cost = expBoost*2;
		setAlignment(Pos.CENTER);
		setText("exp:"+Integer.toString(expBoost)+"\ncost:"+Integer.toString(cost));
		setPrefSize(80, 50);
	}
	
	public int getExp() {
		return expBoost;
	}
	
	public int getCost() {
		return cost;
	}
}
