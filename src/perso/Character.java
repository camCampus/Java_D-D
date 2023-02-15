package src.perso;
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

    private Random random;
    Character(String name, TypeCharacter type) {
        this.name = name;
        this.type = type;
        this.life = randomLife(type);
        this.power = randomPower(type);
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

}


