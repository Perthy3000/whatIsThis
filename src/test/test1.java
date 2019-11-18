package test;

public abstract class test1 {
	private String name;
	private String element;
	private int attack;
	private int defense;
	private int maxHp;
	private int speed;
	private int currentHp;
	
	public test1(String name, String element, int maxHp, int attack, int defense, int speed) {
		this.name = name;
		this.element = element;
		this.maxHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		currentHp = maxHp;
	}
	
	abstract protected int doDamage(test1 sandbag);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getmaxHp() {
		return maxHp;
	}
	
	public void setCurrentHp(int currentHp) {
		if(currentHp < 0) {
			currentHp = 0;
		}
		this.currentHp = currentHp;
	}
	
	public int getCurrentHp() {
		return currentHp;
	}

//	public void setMaxHp(int maxHp) {
//		this.maxHp = maxHp;
//	}

	public int getSpeed() {
		return speed;
	}

	public void setEvasion(int speed) {
		this.speed = speed;
	}
	
	
}
