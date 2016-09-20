package classes;

import java.util.Random;

/** Class for an Dice Object
 *
 * @author robert
 */
public class Dice
{
    private int sides;

    /** 
     * Construcotr
     *
     * @param Sides sets the number of sides for an die. The number of each side is equal to its value.
     */
    public Dice(int Sides)
    {
        this.sides = Sides;
    }

    /**
     * Function roll to roll the dice and return the value which was rolled.
     * Uses Random() to get a random number in the range of 1 to number of sides.
     * 
     * @return Value which was rolled (Range 1 to number of sides).
     */
    public int roll()
    {
        Random r = new Random();
        return r.nextInt(sides) + 1;
    }
}
