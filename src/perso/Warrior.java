package src.perso;

public class Warrior extends Character {

    private String typeAttack;
    private String typeDefense;
    private String weaponAttack;
    private String protectionDefense;

    public Warrior(String name, TypeCharacter type) {
        super(name, type);
        this.typeAttack = "no item";
        this.typeDefense = "no item";
        this.weaponAttack = "no item";
        this.protectionDefense = "no item";

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
                "Weapon: " + getWeaponAttack() + "\n" +
                "Defense: " + getProtectionDefense();
    }
    public String getTypeAttack() {
        return typeAttack;
    }

    public void setTypeAttack(String typeAttack) {
        this.typeAttack = typeAttack;
    }

    public String getTypeDefense() {
        return typeDefense;
    }

    public void setTypeDefense(String typeDefense) {
        this.typeDefense = typeDefense;
    }

    public String getWeaponAttack() {
        return weaponAttack;
    }

    public void setWeaponAttack(String weaponAttack) {
        this.weaponAttack = weaponAttack;
    }

    public String getProtectionDefense() {
        return protectionDefense;
    }

    public void setProtectionDefense(String protectionDefense) {
        this.protectionDefense = protectionDefense;
    }
}
