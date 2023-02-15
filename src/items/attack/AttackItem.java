package src.items.attack;

public abstract class AttackItem {

    private TypeAttack type;

    AttackItem(TypeAttack type){
        this.type = type;
    }

    public TypeAttack getType() {
        return type;
    }
}
