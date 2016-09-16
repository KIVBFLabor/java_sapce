import java.util.Scanner;

class Game {
	private int squareCount = 40;
	private Player[] players;
	private int playercount;
	private boolean running;
	private int round;

	Game() {
		running = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many Players are there?");
		int inputPlayers = scanner.nextInt();
		if(inputPlayers < 2 || inputPlayers > 6){
			throw new IllegalArgumentException("A game can only have between 2 and 6 Players. " +
					"You entered "+ inputPlayers +" Players.");
		}
		this.playercount = inputPlayers;
		players = new Player[playercount];
		for(int i = 0; i<this.playercount; i++){
			System.out.println("What's Player"+ (i+1) +"'s name?");
			String name = scanner.next();
			players[i] = new Player(name);
		}
		scanner.close();
	}

	void play() {
		Die d1 = new Die();
		Die d2 = new Die();
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("*** GAME START ***");
		while(running){
			round++;
			System.out.println();
			System.out.println("ROUND #"+round);
			System.out.println();
			for(int i = 0; i<playercount; i++){
				players[i].play(d1, d2, squareCount);
			}
			System.out.println();
			System.out.println("----------------------------------------");
			for(int i = 0; i<playercount; i++){
				players[i].showField();
			}
			System.out.println("----------------------------------------");
			System.out.println();
			for(int i = 0; i<playercount; i++){
				if(players[i].won()){
					running = false;
					if(players[i].isOver()>0){
						System.out.println(players[i].getName() +" won! ("+players[i].isOver()+" fields over)");
					} else {
						System.out.println(players[i].getName() +" won!");
					}
				}
			}
		}
		System.out.println();
		System.out.println("*** GAME OVER ***");
	}

}
