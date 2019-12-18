package pokemon;

import test.skill;

public class Gyarados extends test1 {
	
	public Gyarados(String name) {
		super(name,Element.WATER, 999, 999, 999, 999);
		skillList.add(new skill("Struggle", Element.NORMAL, 100));
		skillList.add(new skill("Struggle", Element.NORMAL, 0));
		skillList.add(new skill("Struggle", Element.NORMAL, 0));
		skillList.add(new skill("Tackle", Element.NORMAL, 1));
	}
	
	public Gyarados() {
		super("Gyarados",Element.WATER, 999, 999, 999, 999);
		skillList.add(new skill("Struggle", Element.NORMAL, 100));
		skillList.add(new skill("Struggle", Element.NORMAL, 0));
		skillList.add(new skill("Struggle", Element.NORMAL, 0));
		skillList.add(new skill("Tackle", Element.NORMAL, 1));
	}
}
