package src.monster;

import src.board.LevelSelection;

public class Dragon extends Monster{
    public Dragon(LevelSelection level) {
        super(level);
    }


    @Override
    public int Power(LevelSelection level) {
        int power = (level == LevelSelection.Easy)? 4: 8;
        return power;
    }

    @Override
    public int Life(LevelSelection level) {
        int life = (level == LevelSelection.Easy)? 15: 22;
        return life;
    }
}
