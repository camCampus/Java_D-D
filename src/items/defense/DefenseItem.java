package src.items.defense;


import src.App;
import src.items.Item;
import src.perso.Character;
import src.perso.TypeCharacter;

public abstract class DefenseItem implements Item {

    protected abstract TypeCharacter getUseBy();
    private TypeDefense type;
    DefenseItem(TypeDefense type) {
        this.type = type;
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
