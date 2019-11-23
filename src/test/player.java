package test;

import java.util.ArrayList;
import java.util.List;

import pokemon.Status;
import pokemon.test1;

public class player{
	private String name;
	private List<test1> playerpokken;
	private int availablepokken;
	private final int maxpokken = 5;
	private int money;
	private Pokeball pokeball;
	
	public player(String name) {
		this.name = name;
		playerpokken = new ArrayList<test1>();
		money = 0;
		availablepokken = 0;
		pokeball = new Pokeball();
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
		this.playerpokken.remove(index);
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
	
}
