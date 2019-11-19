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
		case "pikachu":
			pokken = new pika("Charmander", Element.FIRE , 100, 20, 50, 200);
			break;
		case "pikachu2":
			pokken = new pika("Charmander2", Element.FIRE , 200, 100, 0, 200);
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
		test1 enemy = new pika("Charmander2", Element.FIRE , 200, 100, 0, 200);
//		while (playerpoken.size() > 0 || enemy.getCurrentHp() != 0) {
//			test1 currentpoken = playerpoken.get(0);
//			playerpoken.remove(0);
//			System.out.println("i choose you! " + currentpoken.getName());
//			while(currentpoken.getCurrentHp() != 0 && enemy.getCurrentHp() != 0) {
//				System.out.println("-" + currentpoken.getName() + " attack for " + currentpoken.doDamage(enemy));
//				if(enemy.getCurrentHp() != 0) {
//					System.out.println(enemy.getName() + " attack for " + enemy.doDamage(currentpoken));
//				}
//			}
//			if(currentpoken.getCurrentHp() == 0) {
//				System.out.println(currentpoken.getName() + " is dead!");
//			} else {
//				System.out.println("enemy is dead!");
//			}
//		}
		List<test1> playerpokkenList = player1.getpokenList();
		while(player1.getAvailablePokken() > 0 && enemy.getCurrentHp() != 0) {
			test1 currentpokken = null;
			for(test1 x : playerpokkenList) {
				if(x.getStatus() != Status.FAINTED) {
					currentpokken = x;
				}
			}
			if(currentpokken != null) {
				while (currentpokken.getStatus() != Status.FAINTED && enemy.getStatus() != Status.FAINTED) {
					System.out.println("-"+currentpokken.getName()+" attack for "+currentpokken.doDamage(enemy));
					if(enemy.getStatus() != Status.FAINTED) {
						System.out.println(enemy.getName()+" attack for "+enemy.doDamage(currentpokken));
					}	
				}
				if(currentpokken.getStatus() == Status.FAINTED) {
					System.out.println(currentpokken.getName() + " is fainted!");
					player1.setAvailablePokken(player1.getAvailablePokken()-1);
				} else {
					System.out.println(enemy.getName() + " is fainted!");
				}
			}
		}
		if(player1.getAvailablePokken() > 0) {
			System.out.println(player1.getName() + " win!");
		} else {
			System.out.println("enemy win!");
		}
	}
}
