package src.items.attack;

import src.board.LevelSelection;
import src.perso.TypeCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spell extends AttackItem{

    private String name;
    private int stats;
    private String description;

    private Random random;

    public Spell(LevelSelection level) {
        super(TypeAttack.Sort);
        this.random = new Random();
        this.name = selectName();
        this.stats = selectStats(level);
        this.description = getDescription(name);
    }

    private String selectName() {
        int val = SpellList.values().length;
        int rand = random.nextInt(val);
        List<String> spellList = new ArrayList<>();

        for (SpellList spell : SpellList.values()) {
            spellList.add(spell.name());
        }
        return spellList.get(rand);
    }

    private int selectStats(LevelSelection level) {
        int easy = random.nextInt(1, 6);
        int hard = random.nextInt(6 , 11);
        int stats;
        if (level == LevelSelection.Easy) {
            stats = easy;
        } else {
            stats = hard;
        }
        return stats;
    }
    public String getDescription(String spell) {
        String description = "";

        switch (spell) {
            case "IceArrow" -> description = "Ice Arrow hurt ans slowdown the enemy";
            case "FireBlast" -> description = "Ball of fire, hurt and burn the enemy";
        }
        return description;
    }

    @Override
    protected TypeCharacter getUseBy() {
        return TypeCharacter.Wizard;
    }
}
