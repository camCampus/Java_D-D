package src.perso;

public class Warrior extends Character {



    public Warrior(String name, TypeCharacter type) {
        super(name, type);

    }

    /**
     * Methode pour afficher toutes les stats du personnages au joueur
     * @return
     */
    @Override
    public String toString() {
        return  "----------------------------------------" +
                "----| " +      getName()       + " |----" + "\n" +
                "----| "   +"Life: " + getLife() +" |----" + "\n" +
                "----| " +"Power: " + getPower() +" |----" + "\n" +
                "----------------------------------------";
    }


}
