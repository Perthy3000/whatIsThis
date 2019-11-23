package pokemon;

import java.util.ArrayList;
import java.util.List;

import test.skill;

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

	public int doDamage(test1 sandbag, skill move) {
		int calDamage = getAttack()+move.getPower()-sandbag.getDefense();
		if(calDamage <= 0) {
			calDamage = 1;
		}
		sandbag.setCurrentHp(sandbag.getCurrentHp()-calDamage);
		return calDamage;
	}
	
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

	public void fullHeal() {
		currentHp = maxHp;
		status = Status.READY;
	}

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
