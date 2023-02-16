package src.items.attack;

import src.App;
import src.items.Item;
import src.perso.Character;
import src.perso.TypeCharacter;

public abstract class AttackItem implements Item {

    private TypeAttack type;

    AttackItem(TypeAttack type){
        this.type = type;
    }

    protected abstract TypeCharacter getUseBy();


    public TypeAttack getType() {
        return type;
    }

    @Override
    public void applyEffect() {
        boolean valid = false;
        Character character = App.getInstance().getPersonnage();
        TypeCharacter type = character.getType();

        if (type == getUseBy()) {
            System.out.println("Can use this item");
            valid = true;
        }
    }
}
