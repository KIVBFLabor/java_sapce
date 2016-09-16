public class Player {
    private String name;
    private int money = 7;
    private int position = 1;
    /** Shows how many fields the Player is over */
    private int over;
    /** Shows if a Player crossed the finishline */
    private boolean finish = false;


    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean finished() {
        return finish;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    void play(Die d1, Die d2, int lastfield) {
        d1.roll();
        int roll1 = d1.value();
        d2.roll();
        int roll2 = d2.value();
        position += (roll1 + roll2);
        if (position <= 40 && position % 10 == 0) {
            money += 10;
        } else if (position <= 40 && position % 5 == 0) {
            /** A Player can have a negative amount of money */
            money -= 5;
        }
        if (position > lastfield) {
            over = position - lastfield;
            finish = true;
        }
        System.out.print(name + " rolled a " + roll1 + " and a " + roll2 + ". ");
        if (over == 1) {
            System.out.print(name + " is " + over + " field over field " + lastfield + ". ");
        } else if (over > 1) {
            System.out.print(name + " is " + over + " fields over field " + lastfield + ". ");
        } else {
            System.out.print(name + " is now on field " + position + ". ");
        }
        System.out.println(name + " has " + money + ".00€ now.");
    }

    /**
     * showField() shows, how money fields a player already passed
     */
    void showField() {
        for (int i = 0; i < position; i++) {
            System.out.print(".");
        }
        System.out.println(name);
    }
}