package donjon;


class Personnage {
    private String name;
    private TypePersonage type;
    private int life;
    private int power;
    private TypeAttack attack;
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

    private void initPerso(int number) {
        if (number == 2) {
            this.type = TypePersonage.Wizard;
            this.life = 6;
            this.power = 15;
            this.attack = TypeAttack.Sort;
            this.defense = TypeDefense.IceShield;
        }
    }


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


