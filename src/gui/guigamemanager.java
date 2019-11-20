package gui;

import test.player;

public class guigamemanager {
	
	private player player1;
	
	public guigamemanager() {
	}
	
	public void createPlayer(String name) {
		player1 = new player(name);
	}
}
