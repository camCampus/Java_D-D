package src.items;

import src.monster.Monster;

public interface Item {

    void applyEffect();

    int applySpeBonus(Monster monster);
}
