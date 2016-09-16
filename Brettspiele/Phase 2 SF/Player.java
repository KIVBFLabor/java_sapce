public class Player {
	private String name;
	private int position = 1;
	private int over; /** Zeigt an, wie viele Felder der Spieler über dem Ziel ist */
	private boolean win = false; /** Zeigt an ob ein Spieler gewonnen hat */

	Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int isOver() {
		return over;
	}

	public boolean won() {
		return win;
	}

	void play(Die d1, Die d2, int lastfield) {
		int roll1 = d1.roll();
		int roll2 = d2.roll();
		position += (roll1 + roll2);
		if(position>=lastfield) {
			over = position - lastfield;
			position = lastfield;
			win = true;
		}
		System.out.print(name +" rolled a "+ roll1 +" and a "+ roll2 +". ");
		System.out.println(name +" is now on field "+ position +".");
	}

	/** showField() zeigt an, wieviele Felder der Spieler bereits gelaufen ist */
	void showField() {
		for(int i = 0; i < position; i++){
			System.out.print(".");
		}
		System.out.println(name);
	}
}
