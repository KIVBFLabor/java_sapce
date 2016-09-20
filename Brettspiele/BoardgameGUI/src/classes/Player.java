package classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author robert
 */
public class Player
{

    private int position;
    private final String name;
    private int money;

    /**
     *
     * @param name
     */
    public Player(String name)
    {
        this.name = name;
        this.position = 1;
        this.money = 7;
    }

    /**
     *
     * @return
     */
    public int getPosition()
    {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(int position)
    {
        this.position = position;
    }

    /**
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return
     */
    public String printMoney()
    {
        DecimalFormat df = new DecimalFormat("0.##' Euro'");
        return df.format(money);
    }

    /**
     *
     * @return
     */
    public int getMoney()
    {
        return money;
    }

    /**
     *
     * @param money
     */
    public void addMoney(int money)
    {
        if ((this.money + money) < 0)
        {
            this.money = 0;
        }
        else
        {
            this.money += money;
        }
    }

    /**
     *
     * @param dies
     * @return
     */
    public String play(Dice dies[])
    {
        int sum = 0;
        int dieThrow = 0;
        String s = " und ";
        String output = "Spieler " + name + " würfelt";
        for (Dice x : dies)
        {
            if (dieThrow == 0)
            {
                s = " ";
            }
            dieThrow = x.roll();
            sum += dieThrow;
            output += s + dieThrow;
            s = " und ";
        }
        setPosition(sum + getPosition());
        output += ". Neue Position: " + getPosition() + ". Geld: " + printMoney() + ".\n";
        return output;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
