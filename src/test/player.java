package test;

import java.util.ArrayList;
import java.util.List;

public class player {
	private String name;
	private List<test1> playerpokken;
	private int availablepokken;
	private final int maxpokken = 6;
	private int money;
	
	public player(String name) {
		this.name = name;
		playerpokken = new ArrayList<test1>();
		money = 0;
		availablepokken = 0;
	}
	
	public void addpoken(test1 pokken) {
		if(playerpokken.size() < maxpokken) {
			playerpokken.add(pokken);
			System.out.println(pokken.getName() + " is added!");
			availablepokken++;
		} else {
			System.out.println("full!");
		}
	}
	
	public int getAvailablePokken() {
		return availablepokken;
	}
	
	public void setAvailablePokken(int availablepokken) {
		if(availablepokken < 0) {
			availablepokken = 0;
		}
		this.availablepokken = availablepokken;
	}
	
	public List<test1> getpokenList() {
		return playerpokken;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		if(money < 0) {
			money = 0;
		}
		this.money = money;
	}

	public String getName() {
		return name;
	}
	
	
}
