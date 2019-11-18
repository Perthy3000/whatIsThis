package test;

public class pika extends test1 {

	public pika(String name, String element, int maxHp, int attack, int defense, int speed) {
		super(name, element, maxHp, attack, defense, speed);
	}

	@Override
	protected int doDamage(test1 sandbag) {
		int calDamage = getAttack()-sandbag.getDefense();
		if(calDamage < 0) {
			calDamage = 0;
		}
		sandbag.setCurrentHp(sandbag.getCurrentHp()-calDamage);
		return calDamage;
	}

}
