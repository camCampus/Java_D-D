package src.monster;

import src.board.LevelSelection;

public class Sorcerer extends Monster{
    public Sorcerer (LevelSelection level) {
        super(level);
    }
    @Override
    public int Power(LevelSelection level) {
        int power = (level == LevelSelection.Easy)? 2: 5;
        return power;
    }

    @Override
    public int Life(LevelSelection level) {
        int life = (level == LevelSelection.Easy)? 9: 20;
        return life;
    }
}
