package src.perso;


public class Wizard extends Character {

    public Wizard(String name, TypeCharacter type) {
        super(name, type);
    }

    @Override
    public String toString() {
        return  getName() + "\n" +
                "Type: " + getType() + "\n" +
                "Life: " + getLife() + "\n" +
                "Power: " + getPower() + "\n";

    }


}
