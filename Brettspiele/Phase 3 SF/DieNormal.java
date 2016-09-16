public class DieNormal implements Die {
    private int value;

    public void roll() {
        value = 1 + (int) (6 * Math.random());
    }

    public int value() {
        return value;
    }
}
