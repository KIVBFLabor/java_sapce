package classes;

import java.util.ArrayList;

/**
 * Class field
 *
 * @author robert
 */
public class Field
{

    private final int numberOfFields;
    private final int badFields[] =
    {
        5, 15, 25, 35
    };
    private final int goodFields[] =
    {
        10, 20, 30, 40
    };

    /**
     * Constructor for a new field
     * 
     * @param fields sets the number of fields on this field.
     */
    public Field(int fields)
    {
        this.numberOfFields = fields;
    }

    /**
     *
     * @return Returns the number of fields on this field
     */
    public int getNumberOfFields()
    {
        return numberOfFields;
    }

    /**
     * Method to get the numbers of all bad fields
     * 
     * @return int[] Returns an array of fields which are bad.
     */
    public int[] getBadFields()
    {
        return badFields;
    }

    /**
     * Method to get the numbers of all good fields
     *
     * @return int[] Returns an array of fields which are good
     */
    public int[] getGoodFields()
    {
        return goodFields;
    }

    /**
     * Method to check if a player is standing on a good field
     *
     * @param position The position of a player
     * @return boolean Returns true if the given position is a good field and false if not
     */
    public boolean isFieldGood(int position)
    {
        boolean x = false;
        for (int i : goodFields)
        {
            if (position == i)
            {
                x = true;
            }
        }
        return x;
    }

    /**
     * Method to check if a player is standing on a bad field
     *
     * @param position The position of a player
     * @return boolean  Returns true if the given position is a bad field and fals if not
     */
    public boolean isFieldBad(int position)
    {
        boolean x = false;
        for (int i : badFields)
        {
            if (position == i)
            {
                x = true;
            }
        }
        return x;
    }

    /**
     * Method to check if the player is standing on a good or bad field. 
     * The money of the given player will automatically be set to the right amount
     * 
     * @param player Object Player, which position should be checked
     */
    public void checkField(Player player)
    {
        if (isFieldBad(player.getPosition()))
        {
            player.addMoney(-7);
        }
        if (isFieldGood(player.getPosition()))
        {
            player.addMoney(10);
        }
    }

    /**
     * Method to print the Field with the given players on it
     *
     * @param players An Array of Players which are playing on the field
     * @return String Returns a String which includes a labeled line for each player displaying its position relative to the others
     */
    public String printField(ArrayList<Player> players)
    {
        String row = "";
        Double d;
        for (Player x : players)
        {
            d = x.getPosition() >= 40 ? 25 : 0.625 * x.getPosition();
            for (int i = 0; i < d.intValue(); i++)
            {
                row += " o";
            }
            row += " >";
            for (int i = d.intValue(); i < 25; i++)
            {
                row += " - ";
            }
            row += " | Spieler " + x.getName() + "\n";
        }
        return row;
    }
}
