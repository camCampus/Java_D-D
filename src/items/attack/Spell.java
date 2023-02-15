package src.items.attack;

import src.factory.FillLevel;

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

    public Spell createSpell(FillLevel level) {
        Spell spell;

        if (level == FillLevel.Easy ) {
            spell = new Spell(SpellList.FireBlast, 3);
        } else {
            spell = new Spell(SpellList.IceArrow, 7);
        }
        return spell;
    }
}
