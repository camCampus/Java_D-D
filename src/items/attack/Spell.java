package src.items.attack;

public class Spell extends AttackItem{

    private SpellList name;
    private int stats;
    private String description;

    public Spell(SpellList spell, int stats) {
        super(TypeAttack.Sort);
        this.name = spell;
        this.stats = stats;
        this.description = getDescription(spell);
    }
    public String getDescription(SpellList spell) {
        String description = "";

        switch (spell) {
            case Startet -> description = "Genrique shazam spell...";
            case IceArrow -> description = "Ice Arrow hurt ans slowdown the enemy";
            case FireBlast -> description = "Ball of fire, hurt and burn the enemy";
        }
        return description;
    }
}
