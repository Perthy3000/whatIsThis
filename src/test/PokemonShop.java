package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonShop {
//	private List<test1> pokemons;
	private Scanner input;
	private player player;
	
	public PokemonShop(player player) {
//		pokemons = new ArrayList<test1>();
		this.player = player;
		input = new Scanner(System.in);
		prompt();
		int x = run();
		while(x>0) {
			System.out.println("Wanna return to the shop? (y/n)?");
			String s = input.next();
			if(s.equals("y")) {
			prompt();
			x=run();}
			else {
				break;
			}
		}
	}
	
	public void prompt() {
		System.out.println("========================");
		System.out.println("Welcome to Black Market Shop");
		System.out.println("Select Pokemon :");
		System.out.println("1: Magikarp");
		System.out.println("2: Choi, The Genius");
		System.out.println("3: Perth3000, The God");
		System.out.println("4: Exit Shop");
		System.out.println("========================");
	}
	
	public int run() {
		int select = input.nextInt();
		switch(select) {
		case 1 :
			if(player.getMoney() >= 4000) {
				test1 Magikarp = new pika("Magikarp", Element.WATER , 200, 1, 1, 10);
				this.player.setPokeball(Magikarp);
				System.out.println("Magikarp is added!");
				player.setMoney(player.getMoney()-4000);
			}
		
			else {
				System.out.println("Not Enough Money! Comeback next time!");
			}
			break;
		case 2 :
			if(player.getMoney() >= 800) {
				test1 Choi = new pika("Choi", Element.FIRE, 100, 20, 10, 100);
				this.player.setPokeball(Choi);
				System.out.println("Choi is added!");
				player.setMoney(player.getMoney()-800);
			}
		
			else {
				System.out.println("Not Enough Money! Comeback next time!");
			}
			break;
		case 3 :
			if(player.getMoney() >= 100) {
			test1 Perth = new pika("Perth", Element.GRASS, 90, 50, 40, 200);
			this.player.setPokeball(Perth);
			System.out.println("Perth is added!");
			player.setMoney(player.getMoney()-100);
			}
			else {
				System.out.println("Not Enough Money! Comeback next time!");
			}
			break;
		case 4 : 
			System.out.println("Byeeeeeeeeeeee");
			return 0;
		default:
			System.out.println("Wrong Input u edok!!!");
			return 0;
		}
		return select;
	}
}
