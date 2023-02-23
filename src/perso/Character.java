package src.perso;
import src.items.Item;
import src.items.attack.AttackItem;
import src.items.defense.DefenseItem;
import src.items.heal.ThunderPotion;
import src.perso.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Character {

    /**
     * Nom du personnage définit par l'utilisateur
     */
    private String name;

    /**
     * le type du personnage Guerrier par default ou Magicien
     */
    private TypeCharacter type;

    /**
     * La vie du personnage
     */
    private int life;

    /**
     * Les dégats du personnage
     */
    private int power;

    private AttackItem attackItem ;
    private DefenseItem defenseItem;
    private int defBonus;
    private boolean alive;
    private Random random;

    private List<AttackItem> inventory;
    private boolean thunderPotion;
    Character(String name, TypeCharacter type) {
        this.name = name;
        this.type = type;
        this.life = randomLife(type);
        this.power = randomPower(type);
        this.attackItem = null;
        this.defenseItem = null;
        this.alive = true;
        this.defBonus = 0;
        this.thunderPotion = false;
        this.inventory = new ArrayList<>();
    }


    public int randomLife(TypeCharacter type) {
        int rand = 0;
        switch (type) {
            case Warrior -> rand = new Random().nextInt(5, 11);
            case Wizard -> rand = new Random().nextInt(3, 7);
        }
        return rand;
    }
    public int randomPower(TypeCharacter type) {
        int rand = 0;
        switch (type) {
            case Warrior -> rand = new Random().nextInt(5, 11);
            case Wizard -> rand = new Random().nextInt(8, 16);
        }
        return rand;
    }
    public String getName() {
        return name;
    }

    public TypeCharacter getType() {
        return type;
    }

    public int getLife() {
        return life;
    }

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TypeCharacter type) {
        this.type = type;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public AttackItem getAttackItem() {
        return attackItem;
    }

    public void setAttackItem(AttackItem attackItem) {
        this.attackItem = attackItem;
        this.setPower(this.attackItem.getStats() + this.getPower());
    }

    public DefenseItem getDefenseItem() {
        return defenseItem;
    }

    public void setDefenseItem(DefenseItem defenseItem) {
        this.defenseItem = defenseItem;
    }

    public int getDefBonus() {
        return defBonus;
    }

    public void setDefBonus(int defBonus) {
        this.defBonus = defBonus;
    }

    public boolean isThunderPotion() {
        return thunderPotion;
    }

    public void setThunderPotion(boolean thunderPotion) {
        this.thunderPotion = thunderPotion;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<AttackItem> getInventory() {
        return inventory;
    }

}


