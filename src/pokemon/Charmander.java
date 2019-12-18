package pokemon;

import javafx.application.Application; 
import javafx.collections.FXCollections;  
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import test.skill;

public class Charmander extends Pokemon {
	
	public Charmander() {
		super("Charmander", Element.FIRE, 40, 6, 2, 6);
		skillList.add(new skill("Flame Shot", Element.FIRE, 2));
		skillList.add(new skill("Flame Shower", Element.FIRE, 3));
		skillList.add(new skill("Flamingo", Element.FIRE, 5000));
		skillList.add(new skill("Flame Burst", Element.FIRE, 4));    
	    	   }
	
}
