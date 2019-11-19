package test;

import java.util.ArrayList;
import java.util.List;

public abstract class test1 {
	private String name;
	private Element element;
	private int attack;
	private int defense;
	private int maxHp;
	private int speed;
	private int currentHp;
	private Status status;
	protected List<skill> skillList;
	
	public test1(String name, Element element, int maxHp, int attack, int defense, int speed) {
		this.name = name;
		this.element = element;
		this.maxHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		currentHp = maxHp;
		status = Status.READY;
		skillList = new ArrayList<skill>();
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	abstract protected int doDamage(test1 sandbag, skill move);
	//abstract protected void skill1();
	//abstract protected void skill2();
	//abstract protected void skill3();
	//abstract protected void skill4();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getElement() {
		return element;
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
		if(currentHp <= 0) {
			currentHp = 0;
			status = Status.FAINTED;
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
	
	public List<skill> getSkillList() {
		return skillList;
	}
	
	public skill getskill(int num) {
		return skillList.get(num);
	}
	
}
