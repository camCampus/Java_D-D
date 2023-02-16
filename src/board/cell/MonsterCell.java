package src.board.cell;

import src.board.LevelSelection;
import src.items.Item;
import src.monster.*;

import java.util.Random;

public class MonsterCell extends Cell {

    private Monster monster;
    private Random random;

    public MonsterCell(LevelSelection level) {
        this.random = new Random();
        this.monster = createMonster(level);
    }

    private Monster createMonster(LevelSelection level) {
        int rand = random.nextInt(3);
        Monster monster = null;

        switch (rand) {
            case 0 -> monster = new Dragon(MonsterType.Dragon, level);
            case 1 -> monster = new Gobelin(MonsterType.Gobelin, level);
            case 2 -> monster = new Sorcerer(MonsterType.Sorcerer, level);
        }
        return monster;
    }

    @Override
    public Cell getTypeCell() {
        return this;
    }

    @Override
    public Item getAllItem() {
        return null;
    }
}
