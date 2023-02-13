package src.game;

import java.util.Random;

public class RollDice {
    private int dice;
    private Random random;

    public RollDice() {
        this.dice = this.random.nextInt(6) + 1;
    }
    public int getDice() {
        return dice;
    }
}
