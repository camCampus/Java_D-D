package src.monster;

import src.board.LevelSelection;

public class Gobelin extends Monster{
    public Gobelin(LevelSelection level) {
        super( level);
    }

    @Override
    public int Power(LevelSelection level) {
        int power = (level == LevelSelection.Easy)? 1: 3;
        return power;
    }

    @Override
    public int Life(LevelSelection level) {
        int life = (level == LevelSelection.Easy)? 6: 10;
        return life;
    }
}
