package src.items.defense;

import src.board.LevelSelection;
import src.items.attack.SwordList;
import src.perso.TypeCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicShield extends DefenseItem {

    private String name;
    private int stats;
    private String description;

    private Random random;
    public MagicShield(LevelSelection level) {
        this.random = new Random();
        this.setName(selectName()) ;
        this.setStats(selectStats(level));
        this.setDescription(getDescription(this.getName()));
    }

    private String selectName() {
        int val = MagicShieldList.values().length;
        int rand = random.nextInt(val);
        List<String> magicShieldList = new ArrayList<>();

        for (MagicShieldList magicShield : MagicShieldList.values()) {
            magicShieldList.add(magicShield.name());
        }
        return magicShieldList.get(rand);
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

    public String getDescription(String shield) {
        String description = "";
        switch (shield) {
            case "FireShield" ->
                description = "Primary Magic Shield";

            case "IceShield" ->
                description = "Powerfull Ice Protection";

        }
        return description;
    }

    @Override
    protected TypeCharacter getUseBy() {
        return TypeCharacter.Wizard;
    }
}
