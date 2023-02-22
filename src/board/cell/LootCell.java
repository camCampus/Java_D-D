package src.board.cell;

import src.App;
import src.board.LevelSelection;
import src.items.attack.*;
import src.items.defense.DefenseItem;
import src.items.defense.MagicShield;
import src.items.defense.Shield;
import src.items.heal.PotionItem;
import src.items.Item;
import src.items.heal.ThunderPotion;
import src.perso.Character;
import src.perso.TypeCharacter;

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
        rand = 2;
     switch (rand) {
         case 0 -> this.item = createAttackItem(this.level);
         case 1 -> this.item = createDefenseItem(this.level);
         case 2 -> this.item = createPotionItem();
     }
    }

    private AttackItem createAttackItem(LevelSelection level) {
     int rand = random.nextInt(4);
     AttackItem item = null;

        switch (rand) {
            case 0 -> item = new Sword(level);
            case 1 -> item = new Spell(level);
            case 2 -> item = new Bow(level);
            case 3 -> item = new Stick(level);
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
    private Item createPotionItem() {
        int rand = random.nextInt(2);
        Item item = null;
        rand = 1;
        switch (rand) {
            case 0 -> item = new PotionItem();
            case 1 -> item = new ThunderPotion();
        }
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

    @Override
    public void apply() {
     this.item.applyEffect();
    }
}
