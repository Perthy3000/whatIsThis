package test;

import pokemon.Element;

public class skill {
	private String skillname;
	private Element element;
	private int power;
	
	public skill(String skillname, Element element, int power) {
		this.skillname = skillname;
		this.element = element;
		this.power = power;
	}

	public String getSkillname() {
		return skillname;
	}

	public Element getElement() {
		return element;
	}

	public int getPower() {
		return power;
	}
	
}
