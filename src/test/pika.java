package test;

public class pika extends test1 {

	public pika(String name, Element element, int maxHp, int attack, int defense, int speed) {
		super(name, element, maxHp, attack, defense, speed);
		skillList.add(new skill("Flame Shot", Element.FIRE, 20));
		skillList.add(new skill("Flame Shower", Element.FIRE, 30));
		skillList.add(new skill("Flamingo", Element.FIRE, 50));
		skillList.add(new skill("Flame Burst", Element.FIRE, 40));
	}

	@Override
	protected int doDamage(test1 sandbag, skill move) {
		int calDamage = getAttack()-sandbag.getDefense();
		if(calDamage < 0) {
			calDamage = 0;
		}
		sandbag.setCurrentHp(sandbag.getCurrentHp()-calDamage);
		return calDamage;
	}

}
