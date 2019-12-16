package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import test.skill;

public class Magikarp extends test1 {

	public Magikarp() {
		super("Magikarp", Element.WATER, 200, 1, 1, 50);
		skillList.add(new skill("Struggle", Element.NORMAL, 100));
		skillList.add(new skill("Struggle", Element.NORMAL, 0));
		skillList.add(new skill("Struggle", Element.NORMAL, 0));
		skillList.add(new skill("Tackle", Element.NORMAL, 1));
		
   	   }

}
