package donjon;


public class Personnage {

    /**
     * Nom du personnage définit par l'utilisateur
     */
    private String name;

    /**
     * le type du personnage Guerrier par default ou Magicien
     */
    private TypePersonage type;

    /**
     * La vie du personnage
     */
    private int life;

    /**
     * Les dégats du personnage
     */
    private int power;

    /**
     * Le type d'attaque du personnage
     */
    private TypeAttack attack;

    /**
     * Le type de defense du personnage
     */
    private TypeDefense defense;
    Personnage(String name, int number) {
        this.name = name;
        this.type = TypePersonage.Warrior;
        this.life = 10;
        this.power = 10;
        this.attack = TypeAttack.Sword;
        this.defense = TypeDefense.Shield;
        this.initPerso(number);
    }

    /**
     * Au moment du choix du type de personnage cette fonction est appeler si je joueur
     * choisit un Mage
     * @param number Le choix du joueur si c'est 1 c'est un guerrier si c'est 2 ou autre c'est
     *               un mage.
     */
    private void initPerso(int number) {
        if (number != 1) {
            this.type = TypePersonage.Wizard;
            this.life = 6;
            this.power = 15;
            this.attack = TypeAttack.Sort;
            this.defense = TypeDefense.IceShield;
        }
    }


    /**
     * Methode pour afficher toutes les stats du personnages au joueur
     * @return
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Type: " + getType() + "\n" +
                "Life: " + getLife() + "\n" +
                "Power: " + getPower() + "\n" +
                "Attack: " + getAttack() + "\n" +
                "Defense: " + getDefense()+ "\n";

    }

    public String getName() {
        return name;
    }

    public TypePersonage getType() {
        return type;
    }

    public int getLife() {
        return life;
    }

    public int getPower() {
        return power;
    }

    public TypeAttack getAttack() {
        return attack;
    }

    public TypeDefense getDefense() {
        return defense;
    }
}


