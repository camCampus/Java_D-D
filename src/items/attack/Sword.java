package src.items.attack;

import src.board.LevelSelection;
import src.perso.TypeCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sword extends AttackItem {

    private String name;
    private int stats;
    private String description;
    private Random random;

    public Sword(LevelSelection level){
        super(TypeAttack.Sword);
        this.random = new Random();
        this.name = selectName();
        this.stats = selectStats(level);
        this.description = getDescription(name);
    }



    private String selectName() {
        int val = SwordList.values().length;
        int rand = random.nextInt(val);
        List<String> swordList = new ArrayList<>();

        for (SwordList sword : SwordList.values()) {
            swordList.add(sword.name());
        }
        return swordList.get(rand);
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

    public String getDescription(String sword) {
        String description = "";
        switch (sword){

            case "Ghostwalker" ->
                description = "The Ghostwalker is a warrior's sword, feared by all who cross its path. Its sleek and mysterious design is matched only by its unparalleled sharpness and strength.";

            case "Extinction" ->
                description = "The Extinction sword is a weapon of legend, said to hold the power to bring an end to all that stands in its path. Its gleaming blade, forged from the finest of metals, is etched with runes of immense power.";

        }
        return description;
    }

    public String getName() {
        return name;
    }

    public int getStats() {
        return stats;
    }

    public String getDescription() {
        return description;
    }


    @Override
    protected TypeCharacter getUseBy() {
        return TypeCharacter.Warrior;
    }


}
