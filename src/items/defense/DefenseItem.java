package src.items.defense;


import src.App;
import src.items.Item;
import src.perso.Character;
import src.perso.TypeCharacter;

public abstract class DefenseItem implements Item {


    private String name;
    private int stats;
    private String description;

    protected abstract TypeCharacter getUseBy();

    @Override
    public void applyEffect() {
        Character character = App.getInstance().getPersonnage();
        TypeCharacter type = character.getType();

        if (type == getUseBy()) {

            if (character.getDefenseItem() == null) {
                character.setDefenseItem(this);
                System.out.println("You found and equip this item: " + "\n" + this);

            } else if (character.getDefenseItem().getStats() < this.getStats()) {
                character.setDefenseItem(this);
                System.out.println("You found and equip a better item nice !! : " + "\n" + this);
            }

        } else {
            System.out.println("This item is not for you sorry");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getName() + "\n" + "defense bonus + " + getStats() + "\n" + "description : " + "\n" + getDescription();
    }
}
