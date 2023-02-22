package src.perso.inventory;

import src.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addInventoryItem(Item item) {
        this.items.add(item);
    }
    public void removeInventoryItem(Item item) {
        this.items.remove(item);
    }
}
