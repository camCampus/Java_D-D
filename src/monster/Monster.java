package src.monster;

import src.board.LevelSelection;

import java.util.Random;

public abstract class Monster {
    private int life;
    private int power;
    private Random random;

    protected Monster(MonsterType monsterType, LevelSelection level) {
        this.random = new Random();
        this.life = Life(monsterType, level);
        this.power = Power(monsterType, level);
    }

    private int Power(MonsterType monsterType,  LevelSelection level) {
        int power = 0;
        switch (monsterType) {
            case Gobelin -> power=1;
            case Sorcerer -> power=2;
            case Dragon -> power=4;
        }
        power = (level == LevelSelection.Hard) ? power * 3 : power ;
        return power;
    }

    private int Life(MonsterType monsterType,  LevelSelection level) {
        int life = 0;
        switch (monsterType) {
            case Gobelin -> life=6;
            case Sorcerer -> life=9;
            case Dragon -> life=15;
        }
        life = (level == LevelSelection.Hard) ? life * 2 : life ;
        return life;
    }

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
