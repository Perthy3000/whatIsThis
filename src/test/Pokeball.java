package test;

import java.util.ArrayList;
import java.util.List;

import pokemon.test1;

public class Pokeball {
	private List<test1> Pokemon_List;
	
	public Pokeball() {
		Pokemon_List = new ArrayList<test1>();
	}
	
	public void addPokemon(test1 Poken) {
		this.Pokemon_List.add(Poken);
	}
	public List<test1> getPokemonList(){
		return this.Pokemon_List;
	}
	public void showAllPokeball() {
		int index = 1;
		for(test1 i : this.Pokemon_List) {
			System.out.println("["+index+"] : "+i.getName());
			index++;
		}
	}
	
}
