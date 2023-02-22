package src.items.heal;

import com.diogonunes.jcolor.Attribute;
import src.App;
import src.items.Item;
import src.monster.Monster;
import src.perso.Character;

import static com.diogonunes.jcolor.Ansi.colorize;

public class ThunderPotion implements Item {



    @Override
    public void applyEffect() {
        Character player = App.getInstance().getPersonnage();
        player.setThunderPotion(true);
        System.out.println(colorize(".~~~| ITEM |~~~.", Attribute.TEXT_COLOR(255,0,255)));
    }

    @Override
    public int applySpeBonus(Monster monster) {
        return 0;
    }

}
