package src.items.attack;

import src.App;
import src.items.Item;
import src.perso.Character;
import src.perso.TypeCharacter;

public abstract class AttackItem implements Item {

    private String name;
    private int stats;
    private String description;


    protected abstract TypeCharacter getUseBy();


    @Override
    public void applyEffect() {
        Character player = App.getInstance().getPersonnage();
        TypeCharacter type = player.getType();
        int resetPlayerPower = player.getPower();
        if (type == getUseBy()) {

            if (player.getAttackItem() == null) {
                player.setAttackItem(this);
                player.setPower(player.getPower() + this.getStats());
                System.out.println("You found and equip this item: " + "\n" + this);

            } else if (player.getAttackItem().getStats() < this.getStats()) {
                player.setAttackItem(this);
                player.setPower(resetPlayerPower);
                player.setPower(player.getPower() + this.getStats());
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
        return getName() + "\n" + "attack bonus + " + getStats() + "\n" + "description : " + "\n" + getDescription();
    }
}
