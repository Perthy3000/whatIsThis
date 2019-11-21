package pokemon;

import test.skill;

public class Bulbasaur extends test1{

	public Bulbasaur() {
		super("Bulbasaur", Element.GRASS, 50, 5, 3, 5);
		skillList.add(new skill("Grass Shot", Element.GRASS, 2));
		skillList.add(new skill("Grass Shower", Element.GRASS, 3));
		skillList.add(new skill("Grassingo", Element.GRASS, 5));
		skillList.add(new skill("Grass Burst", Element.GRASS, 4));
	}
}
