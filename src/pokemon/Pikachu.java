package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import test.skill;

public class Pikachu extends test1 {

	public Pikachu() {
		super("Pikachu", Element.ElECTRIC, 40, 6, 2, 7);
		skillList.add(new skill("Electric Shot", Element.NORMAL, 2));
		skillList.add(new skill("Electric Shower", Element.ElECTRIC, 3));
		skillList.add(new skill("Electringo", Element.ElECTRIC, 5));
		skillList.add(new skill("Electric Burst", Element.ElECTRIC, 4));

   	   }

}
