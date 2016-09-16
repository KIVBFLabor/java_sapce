public class DieSpecial implements Die {
    private int value;

    public void roll() {
        int random = 1 + (int) (10 * Math.random());
        if ((random % 2) == 0) {
            value = 1;
        } else if (random == 1) {
            value = 6;
        } else {
            value = 2;
        }
    }

    public int value() {
        return value;
    }
}
