package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pokemon.Charmander;
import pokemon.Status;
import pokemon.test1;

public class gameManager {
	private player player1;
	private Scanner in;
	
	public gameManager() {
		in = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("Enter your name :");
		player1 = new player("ASH");
		System.out.println("Choose your partner :");
		System.out.println("1.) Charmander");
		System.out.println("2.) Charmander2");
		System.out.println("3.) Charmander3");
		select();
		//battle();
	}
	
	//select player's pokemon
	private void select() {
		String chosen = in.nextLine();
		test1 pokken = null;
		switch (chosen) {
		case "1":
			pokken = new Charmander();
			break;
		case "2":
			pokken = new Charmander();
			break;
		case "3":
			pokken = new Charmander();
			break;
		case "finish":
			if(player1.getpokenList().size() <= 0) {
				System.out.println("enter name!");
				select();
				return;
			}
			break;
		default:
			System.out.println("enter a valid name!");
		}
		if(pokken != null) {
			player1.addpoken(pokken);
		}
		if(!chosen.equals("finish")) {
			select();
		}
	}
	
//	private void battle() {
//		int turn = 0;
//		test1 enemy = new Charmander();
//		List<test1> playerpokkenList = player1.getpokenList();
//		//choose first pokemon
//		test1 currentpokken = playerpokkenList.get(0);
//		System.out.println("i choose you! " + currentpokken.getName());
//		//battle while player is not out of pokemon and enemy is no fainted
//		while(player1.getAvailablePokken() > 0 && enemy.getCurrentHp() != 0) {
//			boolean exit = false;
//			//change pokemon if current one is fainted
//			currentpokken = choosepokken(currentpokken, playerpokkenList);
//			//continue fighting if none is fainted
//			while (currentpokken.getStatus() != Status.FAINTED && enemy.getStatus() != Status.FAINTED) {
//				//check if player want to continue battle
//				System.out.println("Continue? y : n");
//				String continued = in.next();
//				if(continued.equals("n")) {			//run from fight
//					exit = true;
//					break;
//				} else if(continued.equals("y")){			//continue fighting
//					System.out.println("Choose your move :");		//display moveset
//					for(int i = 0; i < 4; i++) {
//						System.out.println(i + ".) " + currentpokken.getskill(i).getSkillname());
//					}
//					turn++;
//					int numskill = in.nextInt();		//choose skill
//					if(currentpokken.getSpeed() >= enemy.getSpeed()) {
//						System.out.println("-"+currentpokken.getName()+" attack for "+currentpokken.doDamage(enemy, currentpokken.getskill(numskill)));
//						if(enemy.getStatus() != Status.FAINTED) {
//							System.out.println(enemy.getName()+" attack for "+enemy.doDamage(currentpokken, enemy.getskill(0)));
//						}
//					} else {
//						System.out.println(enemy.getName()+" attack for "+enemy.doDamage(currentpokken, enemy.getskill(0)));
//						if(currentpokken.getStatus() != Status.FAINTED) {
//							System.out.println("-"+currentpokken.getName()+" attack for "+currentpokken.doDamage(enemy, currentpokken.getskill(numskill)));
//						}
//					}
//				}
//			}
//			if (exit) {
//				break;
//			}
//			//check for which one is fainted
//			checkfaint(currentpokken, enemy);
//		}
//		//check for winner
//		if(player1.getAvailablePokken() > 0 && enemy.getStatus() == Status.FAINTED) {
//			System.out.println(player1.getName() + " win!");
//		} else if(player1.getAvailablePokken() == 0) {
//			System.out.println("enemy win!");
//		} else {
//			System.out.println("ran away safely");
//		}
//	}
	
	private void checkfaint(test1 currentpokken, test1 enemy) {
		if(currentpokken.getStatus() == Status.FAINTED) {
			System.out.println(currentpokken.getName() + " is fainted!");
		} else {
			System.out.println(enemy.getName() + " is fainted!");
		}
	}
	
	private test1 choosepokken(test1 currentpokken, List<test1> playerpokken) {
		//change pokemon if current one is fainted
		if(currentpokken.getStatus() == Status.FAINTED) {
			for(test1 x : playerpokken) {
				if(x.getStatus() != Status.FAINTED) {
					System.out.println("i choose you! " + x.getName());
					return x;
				}
			}
		}
		return currentpokken;
	}
}
