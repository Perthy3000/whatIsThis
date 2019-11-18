package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gameManager {
	private Scanner in;
	private test1[] pokemon = {new pika("pikachu", "electric" , 100, 20, 50, 200), 
			new pika("pikachu2", "electric" , 200, 100, 0, 200)};
	private List<test1> playerpoken;
	
	public gameManager() {
		in = new Scanner(System.in);
		playerpoken = new ArrayList<test1>();
		}
	
	public void run() {
		System.out.println("Choose your partner :");
		System.out.println("1.) pikachu");
		System.out.println("2.) pikachu2");
		select();
		battle();
	}
	
	private void select() {
		String chosen = in.nextLine();
		switch (chosen) {
		case "pikachu":
			playerpoken.add(new pika("pikachu", "electric" , 100, 20, 50, 200));
			System.out.println("pikachu added!");
			break;
		case "pikachu2":
			playerpoken.add(new pika("pikachu2", "electric" , 200, 100, 0, 200));
			System.out.println("pikachu2 added!");
			break;
		case "finish":
			if(playerpoken.size() <= 0) {
				System.out.println("enter name!");
				select();
				return;
			}
			break;
		default:
			System.out.println("enter a valid name!");
		}
		if(!chosen.equals("finish")) {
			select();
		}
	}
	
	private void battle() {
		test1 enemy = pokemon[1];
		while (playerpoken.size() > 0 || enemy.getCurrentHp() != 0) {
			test1 currentpoken = playerpoken.get(0);
			playerpoken.remove(0);
			System.out.println("i choose you! " + currentpoken.getName());
			while(currentpoken.getCurrentHp() != 0 && enemy.getCurrentHp() != 0) {
				System.out.println("-" + currentpoken.getName() + " attack for " + currentpoken.doDamage(enemy));
				if(enemy.getCurrentHp() != 0) {
					System.out.println(enemy.getName() + " attack for " + enemy.doDamage(currentpoken));
				}
			}
			if(currentpoken.getCurrentHp() == 0) {
				System.out.println("pikachu is dead!");
			} else {
				System.out.println("enemy is dead!");
			}
		}
	}
}
