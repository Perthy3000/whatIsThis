package pokemon;

import test.skill;

public class Charmander extends test1 {

	public Charmander() {
		super("Charmander", Element.FIRE, 40, 6, 2, 6);
		skillList.add(new skill("Flame Shot", Element.FIRE, 2));
		skillList.add(new skill("Flame Shower", Element.FIRE, 3));
		skillList.add(new skill("Flamingo", Element.FIRE, 5));
		skillList.add(new skill("Flame Burst", Element.FIRE, 4));
	}
}
