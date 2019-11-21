package pokemon;

import test.skill;

public class Squirtle extends test1 {
	
	public Squirtle() {
		super("Squirtle", Element.WATER, 50, 5, 3, 5);
		skillList.add(new skill("Water Shot", Element.WATER, 2));
		skillList.add(new skill("Water Shower", Element.WATER, 3));
		skillList.add(new skill("Wateringo", Element.WATER, 5));
		skillList.add(new skill("Water Burst", Element.WATER, 4));
	}
	
}
