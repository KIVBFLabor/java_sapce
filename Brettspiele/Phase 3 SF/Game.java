import java.util.Scanner;

public class Game {
    private int squareCount = 40;
    private Player[] players;
    private int playercount;
    private boolean running;
    private int round;
    static final Scanner scanner = new Scanner(System.in);

    Game() {
        running = true;
        System.out.println("How many Players are there?");
        int inputPlayers = scanner.nextInt();
        if (inputPlayers < 2 || inputPlayers > 6) {
            throw new IllegalArgumentException("A game can only have between 2 and 6 Players. " +
                    "You entered " + inputPlayers + " Players.");
        }
        this.playercount = inputPlayers;
        players = new Player[playercount];
        for (int i = 0; i < this.playercount; i++) {
            System.out.println("What's Player" + (i + 1) + "'s name?");
            String name = scanner.next();
            players[i] = new Player(name);
        }
    }

    void play() {
        Die[] dice = new Die[2];
        for (int i = 0; i < 2; i++) {
            String dienumber;
            String dietype;
            if (i == 0) {
                dienumber = "first";
            } else {
                dienumber = "second";
            }
            System.out.println("Choose your " + dienumber + " die:");
            System.out.println("(1) normal die (2) special die");
            int input = scanner.nextInt();
            if (input < 1 || input > 2) {
                throw new IllegalArgumentException("There are only two kinds of dice. " +
                        "You entered " + input + " as the kind of die.");
            }
            if (input == 1) {
                dice[i] = new DieNormal();
                dietype = "normal";
            } else {
                dice[i] = new DieSpecial();
                dietype = "special";
            }
            System.out.println("You chose a " + dietype + " die as your " + dienumber + " die.");
            System.out.println();
        }
        System.out.println("----------------------------------------");
        for (int i = 0; i < playercount; i++) {
            players[i].showField();
        }
        System.out.println("----------------------------------------");
        System.out.println();
        scanner.nextLine();
        System.out.println("Press Enter to start the Game");
        /** An Input is always finished by pressing Enter, so it doesn't matter, what else is put into the Input */
        scanner.nextLine();
        System.out.println("*** GAME START ***");
        while (running) {
            round++;
            System.out.println();
            System.out.println("ROUND #" + round);
            System.out.println();
            for (int i = 0; i < playercount; i++) {
                players[i].play(dice[0], dice[1], squareCount);
                if (players[i].finished()) {
                    running = false;
                    break;
                }
            }
            System.out.println();
            System.out.println("----------------------------------------");
            for (int i = 0; i < playercount; i++) {
                players[i].showField();
            }
            System.out.println("----------------------------------------");
            if (!running) {
                int max = 0;
                for (int i = 0; i < playercount; i++) {
                    System.out.println("Player #" + (i + 1) + ": name: " + players[i].getName() +
                            " money: " + players[i].getMoney() + ".00€" +
                            " position: " + players[i].getPosition());
                }
                System.out.println("----------------------------------------");
                System.out.println();
                for (int i = 0; i < playercount; i++) {
                    if (players[i].getMoney() >= max) {
                        max = players[i].getMoney();
                    }
                }
                for (int i = 0; i < playercount; i++) {
                    if (players[i].getMoney() == max) {
                        System.out.println(players[i].getName() + " won the Game!!!");
                    }
                }
            }
            System.out.println();
            if (running) {
                System.out.println("Press Enter to continue");
                scanner.nextLine();
            }
        }
        System.out.println("*** GAME OVER ***");
    }
}
