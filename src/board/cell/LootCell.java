package src.board.cell;

import src.board.LevelSelection;
import src.items.attack.AttackItem;
import src.items.attack.Spell;
import src.items.attack.Sword;
import src.items.defense.DefenseItem;
import src.items.defense.MagicShield;
import src.items.defense.Shield;
import src.items.heal.PotionItem;
import src.items.Item;

import java.util.Random;

public class LootCell extends Cell {

 private Random random;
 private Item item;

 private LevelSelection level;
 public LootCell(LevelSelection level) {
     this.random = new Random();
     this.level = level;
     createLootItem();
 }
    private void createLootItem() {
     int rand = random.nextInt(3);

     switch (rand) {
         case 0 -> this.item = createAttackItem(this.level);
         case 1 -> this.item = createDefenseItem(this.level);
         case 2 -> this.item = createPotionItem();
     }
    }

    private AttackItem createAttackItem(LevelSelection level) {
     int rand = random.nextInt(2);
     AttackItem item = null;

        switch (rand) {
            case 0 -> item = new Sword(level);
            case 1 -> item = new Spell(level);
        }

        return item;
    }
    private DefenseItem createDefenseItem(LevelSelection level) {
        int rand = random.nextInt(2);
        DefenseItem item = null;

        switch (rand) {
            case 0 -> item = new Shield(level);
            case 1 -> item = new MagicShield(level);
        }

        return item;
    }
    private PotionItem createPotionItem() {
        PotionItem item = new PotionItem();
        return item;
    }

    public Item getItem() {
        return item;
    }


    @Override
    public Cell getTypeCell() {
        return this;
    }

    @Override
    public Item getAllItem() {
        return this.item;
    }
}
