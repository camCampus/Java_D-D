package src.items.attack;

public class Sword extends AttackItem {

    private SwordList name;
    private int stats;
    private String description;
    public Sword(SwordList sword, int stats){
        super(TypeAttack.Sword);
        this.name = sword;
        this.stats = stats;
        this.description = getDescription(sword);
    }


    public String getDescription(SwordList sword) {
        String description = "";
        switch (sword){
            case Starter ->
                description = "Old sword, she deal more damage if you take it by the blade and hit with the handle";

            case Ghostwalker ->
                description = "The Ghostwalker is a warrior's sword, feared by all who cross its path. Its sleek and mysterious design is matched only by its unparalleled sharpness and strength.";

            case Extinction ->
                description = "The Extinction sword is a weapon of legend, said to hold the power to bring an end to all that stands in its path. Its gleaming blade, forged from the finest of metals, is etched with runes of immense power.";

        }
        return description;
    }

}
