package src.items.heal;

import com.diogonunes.jcolor.Attribute;
import src.App;
import src.items.Item;
import src.monster.Monster;
import src.perso.Character;

import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;

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
    public int applySpeBonus(Monster monster) {
        return 0;
    }


    @Override
    public String toString() {
        System.out.println(colorize(".~~~| ITEM |~~~.", Attribute.TEXT_COLOR(255,0,255)));
        return "You found life potion bonus +" + colorize(""+this.up+"", Attribute.GREEN_TEXT())+"HP";
    }
}
