package test;

import java.util.ArrayList;
import java.util.List;

import pokemon.Status;
import pokemon.test1;

public class Player{
	private String name;
	private List<test1> playerpokken;
	private int availablepokken;
	private final int maxpokken = 6;
	private int money;
	private Pokeball pokeball;
	private String gender;
	public Player(String name, String gender) {
		this.name = name;
		playerpokken = new ArrayList<test1>();
		money = 5000;
		availablepokken = 0;
		pokeball = new Pokeball();
		this.gender = gender;
	}
	public void setPokeball(test1 pokemon) {
		this.pokeball.addPokemon(pokemon);
	}
	public void addpoken(test1 pokken) {
		if(playerpokken.size() < maxpokken) {
			playerpokken.add(pokken);
			System.out.println(pokken.getName() + " is added!");
		} else {
			System.out.println("full!");
		}
	}
	
	public int getAvailablePokken() {
		int availablePokemon = 0;
		for(test1 pokken : playerpokken) {
			if(pokken.getStatus() != Status.FAINTED) {
				availablePokemon++;
			}
		}
		return availablePokemon;
	}
	
	public List<test1> getpokenList() {
		return playerpokken;
	}
	public int removepokenList(int index) {
		playerpokken.remove(index);
		return getpokenList().size();
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
	public Pokeball getPokeBall() {
		return this.pokeball;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return this.gender;
	}
	
}
