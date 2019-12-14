package test;

import pokemon.Element;

public class skill {
	private String skillname;
	private Element element, effectiveElement, nEffectiveElement;
	private int power;
	
	public skill(String skillname, Element element, int power) {
		this.skillname = skillname;
		this.element = element;
		this.power = power;
		switch (element) {
		case FIRE:
			effectiveElement = Element.GRASS;
			nEffectiveElement = Element.WATER;
			break;
		case WATER:
			effectiveElement = Element.FIRE;
			nEffectiveElement = Element.GRASS;
			break;
		case GRASS:
			effectiveElement = Element.WATER;
			nEffectiveElement = Element.FIRE;
			break;
		default:
			break;
		}
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
	
	public Element getEffectiveElement() {
		return effectiveElement;
	}
	
	public Element getNEffectiveElement() {
		return nEffectiveElement;
	}
}
