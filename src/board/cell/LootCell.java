package src.board.cell;
import src.App;
import src.board.Board;
import src.board.CellEntry;
import src.factory.FillLevel;
import src.items.PotionItem;
import src.items.attack.AttackItem;
import src.items.attack.Sword;
import src.items.attack.TypeAttack;
import src.items.defense.DefenseItem;
import src.perso.Character;
import src.perso.TypeCharacter;

import java.util.Random;

public class LootCell implements CellEntry {

    private AttackItem weapon;
    private DefenseItem shield;

    private PotionItem potion;
    private FillLevel level;
    private Random random;
    public LootCell(FillLevel level) {
        this.level = level;
        this.potion = new PotionItem();
        this.weapon = createAttackItem();
        this.random = new Random();
    }
    @Override
    public void apply(Board board) {
        //Check le type du perso

    }

    private TypeCharacter checkType() {
       Character character = App.getInstance().getPersonnage();
       return character.getType();
    }
    private AttackItem createAttackItem() {
        AttackItem item;
        int rand = this.random.nextInt(2);
        if (this.level == FillLevel.Easy) {
            switch (rand) {
                case 0 -> item = new Sword()
            }
        }
    }
    public AttackItem getWeapon() {
        return weapon;
    }

    public DefenseItem getShield() {
        return shield;
    }

    public PotionItem getPotion() {
        return potion;
    }
}
