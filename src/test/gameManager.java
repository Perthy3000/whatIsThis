package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gameManager {
	private player player1;
	private Scanner in;
	
	public gameManager() {
		in = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("Enter your name :");
		player1 = new player(in.nextLine());
		System.out.println("Choose your partner :");
		System.out.println("1.) pikachu");
		System.out.println("2.) pikachu2");
		select();
		battle();
	}
	
	private void select() {
		String chosen = in.nextLine();
		test1 pokken = null;
		switch (chosen) {
		case "1":
			pokken = new pika("Charmander", Element.FIRE , 100, 20, 50, 100);
			break;
		case "2":
			pokken = new pika("Charmander2", Element.FIRE , 200, 100, 0, 200);
			break;
		case "3":
			pokken = new pika("Charmander3", Element.FIRE, 50, 50, 20, 300);
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
	
	private void battle() {
		int turn = 0;
		test1 enemy = new pika("Charmander2", Element.FIRE , 200, 100, 0, 200);
		List<test1> playerpokkenList = player1.getpokenList();
		//choose first pokemon
		test1 currentpokken = playerpokkenList.get(0);
		System.out.println("i choose you! " + currentpokken.getName());
		//battle while player is not out of pokemon and enemy is no fainted
		while(player1.getAvailablePokken() > 0 && enemy.getCurrentHp() != 0) {
			//change pokemon if current one is fainted
			if(currentpokken.getStatus() == Status.FAINTED) {
				for(test1 x : playerpokkenList) {
					if(x.getStatus() != Status.FAINTED) {
						currentpokken = x;
						System.out.println("i choose you! " + currentpokken.getName());
						break;
					}
				}
			}
			//continue fighting if none is fainted
			while (currentpokken.getStatus() != Status.FAINTED && enemy.getStatus() != Status.FAINTED) {
				turn++;
				if(currentpokken.getSpeed() >= enemy.getSpeed()) {
					System.out.println("-"+currentpokken.getName()+" attack for "+currentpokken.doDamage(enemy));
					if(enemy.getStatus() != Status.FAINTED) {
						System.out.println(enemy.getName()+" attack for "+enemy.doDamage(currentpokken));
					}					
				} else {
					System.out.println(enemy.getName()+" attack for "+enemy.doDamage(currentpokken));
					if(currentpokken.getStatus() != Status.FAINTED) {
						System.out.println("-"+currentpokken.getName()+" attack for "+currentpokken.doDamage(enemy));
					}
				}
			}
			//check for which one is fainted
			if(currentpokken.getStatus() == Status.FAINTED) {
				System.out.println(currentpokken.getName() + " is fainted!");
				player1.setAvailablePokken(player1.getAvailablePokken()-1);
			} else {
				System.out.println(enemy.getName() + " is fainted!");
			}
		}
		//check for winner
		if(player1.getAvailablePokken() > 0) {
			System.out.println(player1.getName() + " win!");
		} else {
			System.out.println("enemy win!");
		}
	}
}
