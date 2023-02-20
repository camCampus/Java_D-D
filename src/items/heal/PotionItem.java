package src.items.heal;

import src.App;
import src.items.Item;
import src.perso.Character;

import java.util.Random;

public class PotionItem implements Item {
    private int up;
    public PotionItem() {
        this.up = randPotion();
    }
    private int randPotion() {
        Random random = new Random();
        int rand = random.nextInt(2);
        int val;
        if (rand == 0) {
            val = 2;
        } else {
            val = 5;
        }
        return val;
    }


    @Override
    public void applyEffect() {
        Character player = App.getInstance().getPersonnage();
        player.setLife(player.getLife() + this.up);
        System.out.println(this);
    }

    @Override
    public String toString() {
        Character player = App.getInstance().getPersonnage();
        return "You found life potion bonus " + this.up + "\n" + "You have now " + player.getLife() + " hp";
    }
}
