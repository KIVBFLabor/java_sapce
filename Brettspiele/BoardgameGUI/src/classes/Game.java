package classes;

import java.util.ArrayList;

/**
 *
 * @author robert
 */
public final class Game
{

    private final Field gameField;
    private final ArrayList<Player> players = new ArrayList<>();
    private String output = "";
    private Dice dieArray[];
    private boolean running = true;
    private int round = 1;

    /**
     *
     * @param numberOfFields
     * @param dieCount
     * @param dieSideCount
     */
    public Game(int numberOfFields, int dieCount, int dieSideCount)
    {
        this.round = 1;
        this.gameField = new Field(numberOfFields);
        createDies(dieCount, dieSideCount);
    }

    /**
     *
     * @return
     */
    public boolean isRunning()
    {
        return running;
    }

    /**
     *
     * @return
     */
    public String getOutput()
    {
        return output;
    }

    /**
     *
     * @param s
     */
    public void addOutput(String s)
    {
        output += s;
    }

    /**
     *
     * @param player
     */
    public void addPlayer(Player player)
    {
        players.add(player);
    }

    /**
     *
     */
    public void playRound()
    {
        addOutput(printStatus("Runde " + round++));
        for (int i = 0; i < players.size(); i++)
        {
            addOutput(players.get(i).play(dieArray));
            gameField.checkField(players.get(i));
            if (players.get(i).getPosition() > gameField.getNumberOfFields())
            {
                running = false;
            }
        }
        if (running == false)
        {
            getWinner();
        }
    }

    private void getWinner()
    {
        addOutput(printStatus("Gewinner"));
        for (Player x : players)
        {
            if (x.getPosition() > gameField.getNumberOfFields())
            {
                addOutput("\t" + x.getName() + "\n");
            }
        }

    }

    /**
     *
     */
    public void play()
    {
        running = true;
        while (running)
        {
            playRound();
        }
    }

    /**
     *
     * @param dieCount
     * @param dieSideCount
     */
    public void createDies(int dieCount, int dieSideCount)
    {
        dieCount = 2;
        dieSideCount = 6;

        dieArray = new Dice[dieCount];

        for (int i = 0; i < dieArray.length; i++)
        {
            dieArray[i] = new Dice(dieSideCount);
        }
    }

    private String printStatus(String status)
    {
        return "-----\t" + status + "\t ----- \n";
    }

    /**
     *
     * @return
     */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    /**
     *
     * @return
     */
    public String getField()
    {
        return gameField.printField(players);
    }

    /**
     *
     */
    public void restartGame()
    {
        round = 1;
        for (Player x : players)
        {
            x.setPosition(1);
        }
        running = true;
        output += printStatus("Beginne neues Spiel");
    }

    /**
     *
     */
    public void resetGame()
    {
        round = 1;
        for (Player x : players)
        {
            x.setPosition(1);
        }
        running = true;
        output = "";
    }

}
