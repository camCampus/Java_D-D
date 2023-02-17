package src.monster;

import src.board.LevelSelection;

import java.util.Random;

public abstract class Monster {
    private int life;
    private int power;
    private Random random;

    protected Monster( LevelSelection level) {
        this.random = new Random();
        this.life = Life(level);
        this.power = Power(level);
    }

    public abstract int Power(LevelSelection level);

    public abstract int Life(LevelSelection level);

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

   // public abstract void runAttack();

}
