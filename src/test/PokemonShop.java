package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonShop {
	List<test1>pokemons;
	private Scanner input;
	private player player;
	public PokemonShop(player player) {
	this.player = player;
	prompt();
	input = new Scanner(System.in);
	run();
}
	public void prompt() {
		System.out.println("Select Pokemon :");
		System.out.println("1: Magikarp");
		System.out.println("2: Choi, The Genius");
		System.out.println("3: Perth3000, The God");
		System.out.println("4: Exit Shop");
	}
	public void run() {
		int select = input.nextInt();
		
		switch(select) {
		case 1 :
			test1 Magikarp = new pika("Magikarp", Element.WATER , 200, 1, 1, 10);
			this.player.pokeball.addPokemon(Magikarp);
			System.out.println("Magikarp is added!");
			break;
		case 2 :
			test1 Choi = new pika("Choi", Element.FIRE, 100, 20, 10, 100);
			this.player.pokeball.addPokemon(Choi);
			System.out.println("Choi is added!");
			break;
		case 3 :
			test1 Perth = new pika("Choi", Element.GRASS, 90, 50, 40, 200);
			this.player.pokeball.addPokemon(Perth);
			System.out.println("Perth is added!");
			break;
		case 4 : 
			return;
		default:
			System.out.println("Wrong Input u edok!!!");
		}
	}
}
