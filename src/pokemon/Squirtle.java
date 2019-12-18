package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import test.skill;

public class Squirtle extends Pokemon {
	
	public Squirtle() {
		super("Squirtle", Element.WATER, 50, 5, 3, 5);
		skillList.add(new skill("Water Shot", Element.WATER, 2));
		skillList.add(new skill("Water Shower", Element.WATER, 3));
		skillList.add(new skill("Wateringo", Element.WATER, 5));
		skillList.add(new skill("Water Burst", Element.WATER, 4));
		
   	   }
	
}
