package src.items;

import java.util.Random;

public class PotionItem {
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
}
