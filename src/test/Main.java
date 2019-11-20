package test;

public class Main {

	public static void main(String[] args) {
		//new gameManager().run();
		player choi= new player("Choi");
		new PokemonShop(choi);
		System.out.println("====================");
		System.out.println("My Pokeballs : ");
		choi.getPokeBall().showAllPokeball();
	}
}